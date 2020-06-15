package by.kharitonov.day3.entity;

import java.util.ArrayList;

public class Basket {
    private double diameter;
    private int capacity;
    private ArrayList<Ball> balls;

    public Basket(double diameter, int capacity) {
        this.capacity = capacity;
        this.diameter = diameter;
        balls = new ArrayList<>();
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public void add(Ball ball) {
        balls.add(ball);
    }

    public Ball getBall(int index) {
        return balls.get(index);
    }

    public int totalBalls() {
        return balls.size();
    }

    public double totalBallsWeight() {
        double result = 0;
        for (Ball b : balls) {
            result += b.getBallSize().getWeight();
        }
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Basket{");
        sb.append("diameter=").append(diameter);
        sb.append(", capacity=").append(capacity);
        sb.append('}');
        return sb.toString();
    }
}
