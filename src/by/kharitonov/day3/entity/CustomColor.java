package by.kharitonov.day3.entity;

import java.io.Serializable;

public enum CustomColor implements Serializable {
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
