package by.kharitonov.day3.service;

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
        basket.add(ball);
        return true;
    }

    public double totalBallsWeight(Basket basket) {
        double sum = 0;
        for (int i = 0; i < basket.totalBalls(); i++) {
            sum += basket.getBall(i).getBallSize().getWeight();
        }
        return sum;
    }

    public int totalColorBalls(CustomColor color, Basket basket) {
        int count = 0;
        for (int i = 0; i < basket.totalBalls(); i++) {
            if (basket.getBall(i).getColor() == color) {
                count++;
            }
        }
        return count;
    }
}
