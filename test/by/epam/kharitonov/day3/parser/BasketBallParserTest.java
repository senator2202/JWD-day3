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
    private final String testData;
    private final Basket testBasket;

    {
        testData = "30.0 5\n" +
                "SIZE_FIVE RED\n" +
                "SIZE_SEVEN BLUE\n" +
                "SIZE_SIX GREEN\n" +
                "SIZE_THREE BLACK";
        testBasket = new Basket(30, 5);
        testBasket.add(new Ball(BallType.SIZE_FIVE, CustomColor.RED));
        testBasket.add(new Ball(BallType.SIZE_SEVEN, CustomColor.BLUE));
        testBasket.add(new Ball(BallType.SIZE_SIX, CustomColor.GREEN));
        testBasket.add(new Ball(BallType.SIZE_THREE, CustomColor.BLACK));
    }

    @BeforeTest
    @BeforeGroups(groups = {"writing/reading", "fileStreaming"})
    private void init() {
        basketBallParser = new BasketBallParser();
    }

    @Test(groups = {"writing/reading", "fileStreaming"}, priority = 4)
    public void testParseBasket() {
        Basket actualBasket = basketBallParser.parseBasket(testData);
        Assert.assertEquals(actualBasket, testBasket);
    }

    @Test(groups = {"writing/reading", "fileStreaming"})
    public void testReverseParseBasket() {
        String actualResult = basketBallParser.reverseParseBasket(testBasket);
        Assert.assertEquals(actualResult, testData);
    }
}