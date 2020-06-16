package by.kharitonov.day3.service;

import by.kharitonov.day3.entity.Ball;
import by.kharitonov.day3.entity.Basket;
import by.kharitonov.day3.entity.CustomColor;

public class BasketBallService {
    public boolean putBallInBasket(Ball ball, Basket basket) {
        return basket.add(ball);
    }

    public boolean removeBallFromBasket(Basket basket, int index) {
        return basket.remove(index);
    }

    public double totalBallsWeight(Basket basket) {
        double sum = 0;
        for (int i = 0; i < basket.totalBalls(); i++) {
            sum += basket.getBall(i).getBallType().getWeight();
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
