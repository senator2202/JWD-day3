package by.epam.kharitonov.day3.parser;

import by.kharitonov.day3.entity.Ball;
import by.kharitonov.day3.entity.BallType;
import by.kharitonov.day3.entity.Basket;
import by.kharitonov.day3.entity.CustomColor;
import by.kharitonov.day3.parser.BasketBallParser;
import org.testng.Assert;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BasketBallParserTest {
    private BasketBallParser basketBallParser;

    @BeforeTest
    @BeforeGroups(groups = {"writing/reading", "fileStreaming"})
    private void init() {
        basketBallParser = new BasketBallParser();
    }

    @Test(groups = {"writing/reading", "fileStreaming"}, priority = 4)
    public void testParseBasket() {
        String data = "30.0 5\n" +
                "SIZE_FIVE RED\n" +
                "SIZE_SEVEN BLUE\n" +
                "SIZE_SIX GREEN\n" +
                "SIZE_THREE BLACK";
        Basket actualBasket = basketBallParser.parseBasket(data);
        Basket expectedBasket = new Basket(30, 5);
        expectedBasket.add(new Ball(BallType.SIZE_FIVE, CustomColor.RED));
        expectedBasket.add(new Ball(BallType.SIZE_SEVEN, CustomColor.BLUE));
        expectedBasket.add(new Ball(BallType.SIZE_SIX, CustomColor.GREEN));
        expectedBasket.add(new Ball(BallType.SIZE_THREE, CustomColor.BLACK));
        Assert.assertEquals(actualBasket, expectedBasket);
    }

    @Test(groups = {"writing/reading", "fileStreaming"}, priority = 0)
    public void testReverseParseBasket() {
        Basket basket = new Basket(30, 5);
        basket.add(new Ball(BallType.SIZE_FIVE, CustomColor.RED));
        basket.add(new Ball(BallType.SIZE_SEVEN, CustomColor.BLUE));
        basket.add(new Ball(BallType.SIZE_SIX, CustomColor.GREEN));
        basket.add(new Ball(BallType.SIZE_THREE, CustomColor.BLACK));
        String actualResult = basketBallParser.reverseParseBasket(basket);
        String expectedResult = "30.0 5\n" +
                "SIZE_FIVE RED\n" +
                "SIZE_SEVEN BLUE\n" +
                "SIZE_SIX GREEN\n" +
                "SIZE_THREE BLACK";
        Assert.assertEquals(actualResult, expectedResult);
    }
}