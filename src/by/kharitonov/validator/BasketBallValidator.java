package by.kharitonov.validator;

import by.kharitonov.entity.Ball;
import by.kharitonov.entity.Basket;

public class BasketBallValidator {
    public boolean possibleToPut(Ball ball, Basket basket) {
        int totalCapacity = basket.getBalls().size() + 1;
        return (totalCapacity <= basket.getCapacity() &&
                ball.getBallSize().getDiameter() <= basket.getDiameter());
    }

    public boolean validateBasketParameters(double diameter, double capacity) {
        return (diameter > 0 && capacity >= 1);
    }
}
