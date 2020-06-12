package by.kharitonov.service;

import by.kharitonov.entity.Ball;
import by.kharitonov.entity.Basket;
import by.kharitonov.exception.BasketBallException;
import by.kharitonov.validator.BasketBallValidator;

public class BasketBallService {
    public void putBallInBasket(Ball ball, Basket basket)
            throws BasketBallException {
        BasketBallValidator validator = new BasketBallValidator();
        if (!validator.possibleToPut(ball,basket)) {
            throw new BasketBallException("Impossible to put the ball" +
                    " in this basket!");
        }
        basket.getBalls().add(ball);
    }
}
