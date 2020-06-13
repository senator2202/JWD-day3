package by.kharitonov.service;

import by.kharitonov.entity.Ball;
import by.kharitonov.entity.Basket;
import by.kharitonov.entity.CustomColor;
import by.kharitonov.validator.BasketBallValidator;

public class BasketBallService {
    public boolean putBallInBasket(Ball ball, Basket basket) {
        BasketBallValidator validator = new BasketBallValidator();
        if (!validator.possibleToPut(ball, basket)) {
            return false;
        }
        basket.getBalls().add(ball);
        return true;
    }

    public double totalBallsWeight(Basket basket) {
        double sum = 0;
        for (Ball b : basket.getBalls()) {
            sum += b.getBallSize().getWeight();
        }
        return sum;
    }

    public int totalColorBalls(CustomColor color, Basket basket) {
        int count = 0;
        for (Ball b : basket.getBalls()) {
            if (b.getColor() == color) {
                count++;
            }
        }
        return count;
    }
}
