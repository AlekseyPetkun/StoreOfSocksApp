package pro.sky.storeofsocksadd.model.enums;

/**
 * Цвета носков.
 */
public enum Color {

    BLACK("черный"),
    WHITE("белый"),
    YELLOW("желтый"),
    RED("красный"),
    BLUE("синий"),
    GREEN("зеленый"),
    ORANGE("оранжевый");
    private final String translationColor;

    Color(String translationColor) {
        this.translationColor = translationColor;
    }

    public String getTranslationColor() {
        return translationColor;
    }
}
