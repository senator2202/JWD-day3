package by.kharitonov.validator;

import by.kharitonov.entity.Ball;
import by.kharitonov.entity.Basket;

public class BasketBallValidator {
    public boolean possibleToPut(Ball ball, Basket basket) {
        double totalWeight = basket.totalBallsWeight() + ball.getWeight();
        double totalCapacity = basket.getBalls().size() + 1;
        return (totalWeight <= basket.getBallsMaxWeight() &&
                totalCapacity <= basket.getCapacity());
    }
}
