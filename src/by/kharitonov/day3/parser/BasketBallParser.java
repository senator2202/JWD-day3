package by.kharitonov.day3.parser;

import by.kharitonov.day3.entity.Ball;
import by.kharitonov.day3.entity.BallType;
import by.kharitonov.day3.entity.Basket;
import by.kharitonov.day3.entity.CustomColor;

public class BasketBallParser {
    public Basket parseBasket(String data) {
        String[] params = data.split("\n");
        String[] basketParams = params[0].split("\\s");
        Double diameter = Double.parseDouble(basketParams[0]);
        int capacity = Integer.parseInt(basketParams[1]);
        Basket basket = new Basket(diameter, capacity);
        for (int i = 1; i < params.length; i++) {
            Ball ball = parseBall(params[i]);
            basket.add(ball);
        }
        return basket;
    }

    public Ball parseBall(String data) {
        String[] ballParams = data.split("\\s");
        BallType ballType = BallType.valueOf(ballParams[0]);
        CustomColor color = CustomColor.valueOf(ballParams[1]);
        return new Ball(ballType, color);
    }
}
