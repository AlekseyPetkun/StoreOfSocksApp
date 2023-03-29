package pro.sky.storeofsocksadd.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.storeofsocksadd.model.Socks;
import pro.sky.storeofsocksadd.model.enums.Color;
import pro.sky.storeofsocksadd.model.enums.Size;
import pro.sky.storeofsocksadd.services.SocksService;


@RestController
@RequestMapping("/api/socks")
@Tag(name = "API по работе с партиями носков",
        description = "CRUD-операции для работы с партиями носков")
public class ShopSocksController {

    private final SocksService socksService;

    public ShopSocksController(SocksService socksService) {
        this.socksService = socksService;
    }


    @PostMapping
    @Operation(
            summary = "Регистрация товара на склад",
            description = "Нужно написать параметры товара (цвет, размер, содержание хлопка) и количество" +
                    "данного товара"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Удалось добавить приход"
    )
    @ApiResponse(
            responseCode = "400",
            description = "Параметры запроса отсутствуют или имеют некорректный формат"
    )
    @ApiResponse(
            responseCode = "500",
            description = "Произошла ошибка, не зависящая от вызывающей стороны"
    )
    public ResponseEntity<Socks> saveNewSocks(@RequestParam(required = false) Color color,
                                              @RequestParam(required = false) Size size,
                                              @RequestParam(required = false) Integer cottonPart,
                                              @RequestParam(required = false) Integer quantity) {

        try {
            return ResponseEntity.ok(socksService.add(color, size, cottonPart, quantity));
        } catch (RuntimeException e) {
            e.getStackTrace();
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping()
    @Operation(
            summary = "Регистрация отпуска носков со склада",
            description = "Нужно написать параметры товара (цвет, размер, содержание хлопка) и количество, " +
                    "для отпуска товара со склада"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Удалось произвести отпуск носков со склада"
    )
    @ApiResponse(
            responseCode = "400",
            description = "Товара нет на складе в нужном количестве или параметры запроса" +
                    "имеют некорректный формат"
    )
    @ApiResponse(
            responseCode = "500",
            description = "Произошла ошибка, не зависящая от вызывающей стороны"
    )
    public ResponseEntity<Socks> registration(@RequestParam(required = false) Color color,
                                              @RequestParam(required = false) Size size,
                                              @RequestParam(required = false) Integer cottonPart,
                                              @RequestParam(required = false) Integer quantity) {

        try {
            return ResponseEntity.ok(socksService.editCount(color, size, cottonPart, quantity));
        } catch (RuntimeException e) {
            e.getStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    @Operation(
            summary = "Общее количество носков на складе",
            description = "Нужно написать параметры товара (цвет, размер, содержание хлопка)"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Запрос выполнен, результат в теле ответа в виде строкового представления целого числа"
    )
    @ApiResponse(
            responseCode = "400",
            description = "Параметры запроса отсутствуют или имеют некорректный формат"
    )
    @ApiResponse(
            responseCode = "500",
            description = "Произошла ошибка, не зависящая от вызывающей стороны"
    )
    public ResponseEntity<String> getAllSocks(@RequestParam(required = false) Color color,
                                              @RequestParam(required = false) Size size,
                                              @RequestParam(required = false) Integer cottonMin,
                                              @RequestParam(required = false) Integer cottonMax) {

        try {
            return ResponseEntity.ok(socksService.getAllByParameters(color, size, cottonMin, cottonMax));
        } catch (RuntimeException e) {
            e.getStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping
    @Operation(
            summary = "Списание испорченных (бракованных) носков",
            description = "Нужно написать параметры товара (цвет, размер, содержание хлопка) и количество, " +
                    "для отпуска товара со склада"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Запрос выполнен, товар списан со склада"
    )
    @ApiResponse(
            responseCode = "400",
            description = "Параметры запроса отсутствуют или имеют некорректный формат"
    )
    @ApiResponse(
            responseCode = "500",
            description = "Произошла ошибка, не зависящая от вызывающей стороны"
    )
    public ResponseEntity<Socks> deleteDefectSocks(@RequestParam(required = false) Color color,
                                                   @RequestParam(required = false) Size size,
                                                   @RequestParam(required = false) Integer cottonPart,
                                                   @RequestParam(required = false) Integer quantity) {

        try {
            return ResponseEntity.ok(socksService.editCount(color, size, cottonPart, quantity));
        } catch (RuntimeException e) {
            e.getStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}
