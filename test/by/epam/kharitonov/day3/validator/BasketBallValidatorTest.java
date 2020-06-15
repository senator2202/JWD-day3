package by.epam.kharitonov.day3.validator;

import by.kharitonov.day3.entity.Ball;
import by.kharitonov.day3.entity.BallSize;
import by.kharitonov.day3.entity.Basket;
import by.kharitonov.day3.entity.CustomColor;
import by.kharitonov.day3.validator.BasketBallValidator;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class BasketBallValidatorTest {
    BasketBallValidator basketBallValidator;

    @BeforeTest
    @BeforeGroups(groups = "putBallInBasket")
    public void init() {
        basketBallValidator = new BasketBallValidator();
    }

    @DataProvider(name = "dataForPossibleToPut")
    @Test
    public Object[][] dataForPossibleToPut() {
            Basket emptyBasket = new Basket(33, 2);
            Basket smallBasket = new Basket(15, 10);
            Basket smallEmptyBasket = new Basket(12, 5);
            Basket fullBasket = new Basket(30, 1);
            Ball ball = new Ball(BallSize.SIZE_FIVE, CustomColor.RED);
            fullBasket.add(ball);
            return new Object[][]{
                    {new Ball(BallSize.SIZE_FIVE, CustomColor.BLUE),
                            fullBasket, false},
                    {new Ball(BallSize.SIZE_SIX, CustomColor.GREEN),
                            emptyBasket, true},
                    {new Ball(BallSize.SIZE_SEVEN, CustomColor.RED),
                            smallBasket, false},
                    {new Ball(BallSize.SIZE_THREE, CustomColor.RED),
                            smallEmptyBasket, false}
            };
    }

    @Parameters({"ball", "basket", "expectedResult"})
    @Test(dataProvider = "dataForPossibleToPut", groups = "putBallInBasket",
            priority = 1)
    public void testPossibleToPut(Ball ball, Basket basket,
                                  boolean expectedResult) {
        boolean actualResult = basketBallValidator.possibleToPut(ball, basket);
        assertEquals(actualResult, expectedResult);
    }
}