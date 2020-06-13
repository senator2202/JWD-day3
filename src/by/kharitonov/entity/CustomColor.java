package by.kharitonov.entity;

public enum CustomColor {
    RED(0), GREEN(1), BLUE(2), YELLOW(3), PINK(4), PURPLE(5),
    BLACK(6), WHITE(7);

    private final int color;

    CustomColor(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }
}
