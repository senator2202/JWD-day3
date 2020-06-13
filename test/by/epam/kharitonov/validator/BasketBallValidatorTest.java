package by.epam.kharitonov.validator;

import by.kharitonov.entity.Ball;
import by.kharitonov.entity.BallSize;
import by.kharitonov.entity.Basket;
import by.kharitonov.entity.CustomColor;
import by.kharitonov.exception.BasketBallException;
import by.kharitonov.validator.BasketBallValidator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BasketBallValidatorTest {
    BasketBallValidator basketBallValidator;

    @BeforeTest
    public void init() {
        basketBallValidator = new BasketBallValidator();
    }

    @DataProvider(name = "dataForPossibleToPut")
    @Test
    public Object[][] dataForPossibleToPut() {
        try {
            Basket emptyBasket = new Basket(33, 2);
            Basket smallBasket = new Basket(15, 10);
            Basket smallEmptyBasket = new Basket(12, 5);
            Basket fullBasket = new Basket(30, 1);
            Ball ball = new Ball(BallSize.SIZE_FIVE, CustomColor.RED);
            fullBasket.getBalls().add(ball);
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
        } catch (BasketBallException e) {
            return new Object[][]{};
        }
    }

    @Parameters({"ball", "basket", "expectedResult"})
    @Test(dataProvider = "dataForPossibleToPut")
    public void testPossibleToPut(Ball ball, Basket basket,
                                  boolean expectedResult) {
        boolean actualResult = basketBallValidator.possibleToPut(ball, basket);
        assertEquals(actualResult, expectedResult);
    }
}