package by.kharitonov.day3.creator;

import by.kharitonov.day3.entity.Basket;
import by.kharitonov.day3.exception.BasketBallException;
import by.kharitonov.day3.validator.BasketBallValidator;

public class BasketCreator {
    public Basket createBasket(double diameter, int capacity)
            throws BasketBallException {
        BasketBallValidator basketBallValidator = new BasketBallValidator();
        if (!basketBallValidator.validateBasketParameters(diameter, capacity)) {
            throw new BasketBallException("Wrong basket parameters!");
        }
        return new Basket(diameter, capacity);
    }
}
