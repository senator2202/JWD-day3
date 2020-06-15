package by.kharitonov.day3.entity;

public class Ball {
    private BallSize ballSize;
    private CustomColor color;

    public Ball(BallSize ballSize, CustomColor color) {
        this.ballSize = ballSize;
        this.color = color;
    }

    public BallSize getBallSize() {
        return ballSize;
    }

    public void setBallSize(BallSize ballSize) {
        this.ballSize = ballSize;
    }

    public CustomColor getColor() {
        return color;
    }

    public void setColor(CustomColor color) {
        this.color = color;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ball{");
        sb.append("ballSize=").append(ballSize);
        sb.append(", color=").append(color);
        sb.append('}');
        return sb.toString();
    }
}
