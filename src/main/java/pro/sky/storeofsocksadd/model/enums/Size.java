package pro.sky.storeofsocksadd.model.enums;

/**
 * Размеры носков.
 */
public enum Size {

    MEDIUM(0.0, 12.0),
    MIDDLE(12.1, 24.0),
    HARD(24.1, 36.0);

    private final double after;
    private final double before;


    Size(double after, double before) {
        this.after = after;
        this.before = before;
    }

    public double getAfter() {
        return after;
    }

    public double getBefore() {
        return before;
    }
}
