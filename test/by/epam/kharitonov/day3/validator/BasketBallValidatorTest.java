package by.epam.kharitonov.day3.validator;

import by.kharitonov.day3.entity.Ball;
import by.kharitonov.day3.entity.BallType;
import by.kharitonov.day3.entity.Basket;
import by.kharitonov.day3.entity.CustomColor;
import by.kharitonov.day3.validator.BasketBallValidator;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class BasketBallValidatorTest {
    private BasketBallValidator basketBallValidator;

    @BeforeTest
    @BeforeGroups(groups = {"putBallInBasket", "addBall"})
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
        Ball ball = new Ball(BallType.SIZE_FIVE, CustomColor.RED);
        fullBasket.add(ball);
        return new Object[][]{
                {new Ball(BallType.SIZE_FIVE, CustomColor.BLUE),
                        fullBasket, false},
                {new Ball(BallType.SIZE_SIX, CustomColor.GREEN),
                        emptyBasket, true},
                {new Ball(BallType.SIZE_SEVEN, CustomColor.RED),
                        smallBasket, false},
                {new Ball(BallType.SIZE_THREE, CustomColor.RED),
                        smallEmptyBasket, false}
        };
    }

    @Parameters({"ball", "basket", "expectedResult"})
    @Test(dataProvider = "dataForPossibleToPut",
            groups = {"putBallInBasket", "addBall"},
            priority = 1)
    public void testPossibleToPut(Ball ball, Basket basket,
                                  boolean expectedResult) {
        boolean actualResult = basketBallValidator.possibleToPut(ball, basket);
        assertEquals(actualResult, expectedResult);
    }

    @DataProvider(name = "dataForValidateBasketParameters")
    @Test
    public Object[][] dataForValidateBasketParameters() {
        return new Object[][]{
                {2.0, 3, true},
                {0.0, 2, false},
                {-5.1, -2, false},
                {-7.2, 0, false},
                {0.1, 1, true}
        };
    }

    @Parameters({"diameter", "capacity", "expectedResult"})
    @Test(dataProvider = "dataForValidateBasketParameters")
    public void testValidateBasketParameters(double diameter,
                                             int capacity,
                                             boolean expectedResult) {
        boolean actualResult =
                basketBallValidator.validateBasketParameters(diameter,
                        capacity);
        assertEquals(actualResult, expectedResult);
    }
}