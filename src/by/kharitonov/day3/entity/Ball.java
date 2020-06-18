package by.kharitonov.day3.entity;

import java.io.Serializable;

public class Ball implements Serializable {
    private final BallType ballType;
    private final CustomColor color;

    public Ball(BallType ballType, CustomColor color) {
        this.ballType = ballType;
        this.color = color;
    }

    public BallType getBallType() {
        return ballType;
    }

    public CustomColor getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ball ball = (Ball) o;
        if (ballType != ball.ballType) {
            return false;
        }
        return (ballType == ball.ballType && color == ball.color);
    }

    @Override
    public int hashCode() {
        int result = ballType.hashCode();
        result = 31 * result + color.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ball{");
        sb.append("ballType=").append(ballType);
        sb.append(", color=").append(color);
        sb.append('}');
        return sb.toString();
    }
}
