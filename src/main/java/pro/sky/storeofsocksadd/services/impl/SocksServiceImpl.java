package pro.sky.storeofsocksadd.services.impl;

import org.springframework.stereotype.Service;
import pro.sky.storeofsocksadd.exceptions.QuantityLimitException;
import pro.sky.storeofsocksadd.exceptions.ValidationException;
import pro.sky.storeofsocksadd.model.Socks;
import pro.sky.storeofsocksadd.model.enums.Color;
import pro.sky.storeofsocksadd.model.enums.Size;
import pro.sky.storeofsocksadd.services.SocksService;
import pro.sky.storeofsocksadd.services.ValidationService;

import java.util.*;

/**
 * Бизнес-логика по работе с носками
 */
@Service
public class SocksServiceImpl implements SocksService {

    private final ValidationService validationService;

    private final List<Socks> socksList = new ArrayList<>();

    public SocksServiceImpl(ValidationService validationService) {
        this.validationService = validationService;
    }

    @Override
    public Socks add(Color color, Size size, int cottonPart, int quantity) {

            if (socksList.size() > 0) {
                int sum;
                for (int i = 0; i < socksList.size(); i++) {
                    if (color.equals(socksList.get(i).getColor())
                            && size.equals(socksList.get(i).getSize())
                            && cottonPart == socksList.get(i).getCottonPart()) {

                        sum = socksList.get(i).getQuantity() + quantity;

                        socksList.set(i, new Socks(color, size, cottonPart, sum));
                        return socksList.get(i);
                    }
                }
            }
            Socks newSocks = new Socks(color, size, cottonPart, quantity);
            save(newSocks);
            return newSocks;
    }

    @Override
    public Socks save(Socks socks) {
        if (!validationService.validate(socks)) {
            throw new ValidationException(socks.toString());
        }

        socksList.add(socks);
        return socks;
    }

    @Override
    public Socks editCount(Color color, Size size, int cottonPart, int quantity) {
        if (socksList.size() > 0) {
            int difference;
            for (int i = 0; i < socksList.size(); i++) {
                if (color.equals(socksList.get(i).getColor())
                        && size.equals(socksList.get(i).getSize())
                        && cottonPart == socksList.get(i).getCottonPart()) {

                    if (quantity > socksList.get(i).getQuantity()) {
                        throw new QuantityLimitException("Заданное количество пар носков превысило количество пар на складе!");
                    }
                    difference = socksList.get(i).getQuantity() - quantity;
                    socksList.set(i, new Socks(color, size, cottonPart, difference));
                    return socksList.get(i);
                }
            }
        }
        throw new QuantityLimitException("На складе нет носков!");
    }

    @Override
    public String getAllByParameters(Color color, Size size, int cottonMin, int cottonMax) {

        String countSocksString;
        int sum=0;
        for (int i = 0; i < socksList.size(); i++) {
            if (color.equals(socksList.get(i).getColor())
                    && size.equals(socksList.get(i).getSize())
                    && socksList.get(i).getCottonPart() >= cottonMin
                    && socksList.get(i).getCottonPart() <= cottonMax) {

                sum += socksList.get(i).getQuantity();
            }
        }
        countSocksString = Integer.toString(sum);
        return countSocksString;
    }
}
