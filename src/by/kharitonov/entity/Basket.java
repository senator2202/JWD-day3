package by.kharitonov.entity;

import by.kharitonov.exception.BasketBallException;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private double diameter;
    private int capacity;
    private ArrayList<Ball> balls;

    public Basket(double diameter, int capacity)
            throws BasketBallException {
        if (diameter <= 0 || capacity <= 0) {
            throw new BasketBallException("Wrong basket parameters!");
        }
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
