package by.kharitonov.service;

import by.epam.kharitonov.validator.BasketBallValidatorTest;
import by.kharitonov.entity.Ball;
import by.kharitonov.entity.BallSize;
import by.kharitonov.entity.Basket;
import by.kharitonov.entity.CustomColor;
import by.kharitonov.exception.BasketBallException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class BasketBallServiceTest {
    BasketBallService basketBallService;

    @BeforeTest
    private void init() {
        basketBallService = new BasketBallService();
    }

    @DataProvider(name = "dataForPutBallInBasket")
    @Test
    public Object[][] dataForPutBallInBasket() {//????????????????????
        BasketBallValidatorTest helpTest = new BasketBallValidatorTest();
        return helpTest.dataForPossibleToPut();
    }

    @Parameters({"ball", "basket", "expectedResult"})
    @Test(dataProvider = "dataForPutBallInBasket")
    public void testPutBallInBasket(Ball ball, Basket basket,
                                    boolean expectedResult) {
        boolean actualResult = basketBallService.putBallInBasket(ball, basket);
        assertEquals(actualResult, expectedResult);
    }

    @Test(dependsOnMethods = "testPutBallInBasket")
    public void testTotalBallsWeight() {
        try {
            Basket basket = new Basket(33, 5);
            Ball ball = new Ball(BallSize.SIZE_SIX, CustomColor.RED);
            basketBallService.putBallInBasket(ball, basket);
            ball = new Ball(BallSize.SIZE_SEVEN, CustomColor.BLUE);
            basketBallService.putBallInBasket(ball, basket);
            ball = new Ball(BallSize.SIZE_THREE, CustomColor.GREEN);
            basketBallService.putBallInBasket(ball, basket);
            ball = new Ball(BallSize.SIZE_FIVE, CustomColor.YELLOW);
            basketBallService.putBallInBasket(ball, basket);
            double actualResult = basketBallService.totalBallsWeight(basket);
            assertEquals(actualResult, 1.97, 0.002);
        } catch (BasketBallException e) {
            fail();
        }
    }

    @DataProvider(name = "dataForTotalColorBalls")
    @Test
    public Object[][] dataForTotalColorBalls() {
        try {
            Basket basket = new Basket(33, 15);
            Ball ball = new Ball(BallSize.SIZE_SIX, CustomColor.RED);
            basketBallService.putBallInBasket(ball, basket);
            ball = new Ball(BallSize.SIZE_SEVEN, CustomColor.BLUE);
            basketBallService.putBallInBasket(ball, basket);
            ball = new Ball(BallSize.SIZE_THREE, CustomColor.BLUE);
            basketBallService.putBallInBasket(ball, basket);
            ball = new Ball(BallSize.SIZE_FIVE, CustomColor.RED);
            basketBallService.putBallInBasket(ball, basket);
            ball = new Ball(BallSize.SIZE_SIX, CustomColor.YELLOW);
            basketBallService.putBallInBasket(ball, basket);
            ball = new Ball(BallSize.SIZE_SEVEN, CustomColor.BLUE);
            basketBallService.putBallInBasket(ball, basket);
            return new Object[][]{
                    {CustomColor.RED, basket, 2},
                    {CustomColor.BLUE, basket, 3},
                    {CustomColor.YELLOW, basket, 1}
            };
        } catch (BasketBallException e) {
            return new Object[][]{};
        }
    }

    @Parameters({"color", "basket", "expectedResult"})
    @Test(dataProvider = "dataForTotalColorBalls",
            dependsOnMethods = "testPutBallInBasket")
    public void testTotalColorBalls(CustomColor color, Basket basket,
                                    int expectedResult) {
        int actualResult = basketBallService.totalColorBalls(color, basket);
        assertEquals(actualResult,expectedResult);
    }
}