package by.kharitonov.day3.parser;

import by.kharitonov.day3.entity.Ball;
import by.kharitonov.day3.entity.BallType;
import by.kharitonov.day3.entity.Basket;
import by.kharitonov.day3.entity.CustomColor;

public class BasketBallParser {
    public Basket parseBasket(String data) {
        String[] params = data.split("\n");
        String[] basketParams = params[0].split("\\s");
        double diameter = Double.parseDouble(basketParams[0]);
        int capacity = Integer.parseInt(basketParams[1]);
        Basket basket = new Basket(diameter, capacity);
        for (int i = 1; i < params.length; i++) {
            Ball ball = parseBall(params[i]);
            basket.add(ball);
        }
        return basket;
    }

    private Ball parseBall(String data) {
        String[] ballParams = data.split("\\s");
        BallType ballType = BallType.valueOf(ballParams[0]);
        CustomColor color = CustomColor.valueOf(ballParams[1]);
        return new Ball(ballType, color);
    }

    public String reverseParseBasket(Basket basket) {
        StringBuilder result = new StringBuilder();
        result.append(basket.getDiameter());
        result.append(" ").append(basket.getCapacity());
        for (int i = 0; i < basket.totalBalls(); i++) {
            String ballData = reverseParseBall(basket.getBall(i));
            result.append("\n").append(ballData);
        }
        return result.toString();
    }

    private String reverseParseBall(Ball ball) {
        StringBuilder result = new StringBuilder();
        result.append(ball.getBallType());
        result.append(" ").append(ball.getColor());
        return result.toString();
    }
}
