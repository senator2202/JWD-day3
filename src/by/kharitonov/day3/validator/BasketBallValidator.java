package by.kharitonov.day3.validator;

import by.kharitonov.day3.entity.Ball;
import by.kharitonov.day3.entity.Basket;

public class BasketBallValidator {
    public boolean possibleToPut(Ball ball, Basket basket) {
        int totalCapacity = basket.totalBalls() + 1;
        return (totalCapacity <= basket.getCapacity() &&
                ball.getBallType().getDiameter() <= basket.getDiameter());
    }
    public boolean validateBasketParameters(double diameter, int capacity) {
        return (diameter > 0 && capacity >= 1);
    }
}
