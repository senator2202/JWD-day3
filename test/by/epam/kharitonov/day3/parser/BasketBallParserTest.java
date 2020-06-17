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
    BasketBallParser basketBallParser;

    @BeforeTest
    @BeforeGroups(groups = "writing/reading")
    private void init() {
        basketBallParser = new BasketBallParser();
    }

    @Test(groups = "writing/reading", priority = 3)
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
}