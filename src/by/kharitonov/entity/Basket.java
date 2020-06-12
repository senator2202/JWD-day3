package by.kharitonov.entity;

import java.util.ArrayList;

public class Basket {
    private double capacity;
    private double ballsMaxWeight;
    ArrayList<Ball> balls;

    public Basket(double capacity, double ballsMaxWeight) {
        this.capacity = capacity;
        this.ballsMaxWeight = ballsMaxWeight;
        balls = new ArrayList<>();
    }

    public ArrayList<Ball> getBalls() {
        return balls;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getBallsMaxWeight() {
        return ballsMaxWeight;
    }

    public void setBallsMaxWeight(double ballsMaxWeight) {
        this.ballsMaxWeight = ballsMaxWeight;
    }

    public double totalBallsWeight() {
        double result = 0;
        for (Ball b : balls) {
        result+=b.getWeight();
        }
        return result;
    }
}
