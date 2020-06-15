package by.kharitonov.day3.service;

import by.kharitonov.day3.entity.CustomColor;
import by.kharitonov.day3.validator.BasketBallValidator;
import by.kharitonov.day3.entity.Ball;
import by.kharitonov.day3.entity.Basket;
import by.kharitonov.day3.entity.CustomColor;
import by.kharitonov.day3.validator.BasketBallValidator;

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
