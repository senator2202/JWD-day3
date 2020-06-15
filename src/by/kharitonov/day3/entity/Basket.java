package by.kharitonov.day3.entity;

import by.kharitonov.day3.exception.BasketBallException;
import by.kharitonov.day3.validator.BasketBallValidator;
import by.kharitonov.day3.exception.BasketBallException;
import by.kharitonov.day3.validator.BasketBallValidator;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private double diameter;
    private int capacity;
    private ArrayList<Ball> balls;

    private Basket(double diameter, int capacity) {
        this.capacity = capacity;
        this.diameter = diameter;
        balls = new ArrayList<>();
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public static Basket createBasket(double diameter, int capacity)
            throws BasketBallException {
        BasketBallValidator basketBallValidator = new BasketBallValidator();
        if (!basketBallValidator.validateBasketParameters(diameter, capacity)) {
            throw new BasketBallException("Wrong basket parameters!");
        }
        return new Basket(diameter, capacity);
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
