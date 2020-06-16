package by.kharitonov.day3.entity;

import by.kharitonov.day3.validator.BasketBallValidator;

import java.io.Serializable;
import java.util.ArrayList;

public class Basket implements Serializable {
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

    public double getDiameter() {
        return diameter;
    }

    public boolean add(Ball ball) {
        if (possibleToAddBall(ball)) {
            balls.add(ball);
            return true;
        } else {
            return false;
        }
    }

    private boolean possibleToAddBall(Ball ball) {
        BasketBallValidator validator = new BasketBallValidator();
        return validator.possibleToPut(ball, this);
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
            result += b.getBallType().getWeight();
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Basket basket = (Basket) o;

        return (diameter == basket.diameter &&
                capacity == basket.capacity &&
                balls.equals(basket.balls));
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(diameter);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + capacity;
        result = 31 * result + balls.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Basket{");
        sb.append("diameter=").append(diameter);
        sb.append(", capacity=").append(capacity);
        sb.append(", balls now=").append(balls.size());
        sb.append('}');
        return sb.toString();
    }
}
