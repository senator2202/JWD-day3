package by.epam.kharitonov.day3.service;

import by.kharitonov.day3.entity.Ball;
import by.kharitonov.day3.entity.BallType;
import by.kharitonov.day3.entity.Basket;
import by.kharitonov.day3.entity.CustomColor;
import by.kharitonov.day3.service.BasketBallService;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class BasketBallServiceTest {
    private BasketBallService basketBallService;

    @BeforeTest
    @BeforeGroups(groups = "putBallInBasket")
    private void init() {
        basketBallService = new BasketBallService();
    }

    @DataProvider(name = "dataForPutBallInBasket")
    @Test
    public Object[][] dataForPutBallInBasket() {
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
    @Test(dataProvider = "dataForPutBallInBasket", groups = "putBallInBasket",
            priority = 2)
    public void testPutBallInBasket(Ball ball, Basket basket,
                                    boolean expectedResult) {
        boolean actualResult = basketBallService.putBallInBasket(ball, basket);
        assertEquals(actualResult, expectedResult);
    }

    @DataProvider(name = "dataForRemoveBallFromBasket")
    @Test
    public Object[][] dataForRemoveBallFromBasket() {
        Basket basket = new Basket(30, 5);
        basket.add(new Ball(BallType.SIZE_FIVE, CustomColor.RED));
        basket.add(new Ball(BallType.SIZE_SEVEN, CustomColor.BLUE));
        basket.add(new Ball(BallType.SIZE_SIX, CustomColor.GREEN));
        basket.add(new Ball(BallType.SIZE_THREE, CustomColor.BLACK));
        return new Object[][]{
                {basket, 0, true},
                {basket, -1, false},
                {basket, 2, true},
                {basket, 4, false},
                {basket, 25, false}
        };
    }

    @Parameters({"basket", "index", "expectedResult"})
    @Test(dataProvider = "dataForRemoveBallFromBasket")
    public void testRemoveBallFromBasket(Basket basket, int index,
                                         boolean expectedResult) {
        boolean actualResult = basketBallService.removeBallFromBasket(basket,
                index);
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testTotalBallsWeight() {
        Basket basket = new Basket(33, 5);
        Ball ball = new Ball(BallType.SIZE_SIX, CustomColor.RED);
        basket.add(ball);
        ball = new Ball(BallType.SIZE_SEVEN, CustomColor.BLUE);
        basket.add(ball);
        ball = new Ball(BallType.SIZE_THREE, CustomColor.GREEN);
        basket.add(ball);
        ball = new Ball(BallType.SIZE_FIVE, CustomColor.YELLOW);
        basket.add(ball);
        double actualResult = basketBallService.totalBallsWeight(basket);
        assertEquals(actualResult, 1.97, 0.002);
    }

    @DataProvider(name = "dataForTotalColorBalls")
    @Test
    public Object[][] dataForTotalColorBalls() {
        Basket basket = new Basket(33, 15);
        Ball ball = new Ball(BallType.SIZE_SIX, CustomColor.RED);
        basket.add(ball);
        ball = new Ball(BallType.SIZE_SEVEN, CustomColor.BLUE);
        basket.add(ball);
        ball = new Ball(BallType.SIZE_THREE, CustomColor.BLUE);
        basket.add(ball);
        ball = new Ball(BallType.SIZE_FIVE, CustomColor.RED);
        basket.add(ball);
        ball = new Ball(BallType.SIZE_SIX, CustomColor.YELLOW);
        basket.add(ball);
        ball = new Ball(BallType.SIZE_SEVEN, CustomColor.BLUE);
        basket.add(ball);
        return new Object[][]{
                {CustomColor.RED, basket, 2},
                {CustomColor.BLUE, basket, 3},
                {CustomColor.YELLOW, basket, 1}
        };
    }

    @Parameters({"color", "basket", "expectedResult"})
    @Test(dataProvider = "dataForTotalColorBalls",
            dependsOnMethods = "testPutBallInBasket")
    public void testTotalColorBalls(CustomColor color, Basket basket,
                                    int expectedResult) {
        int actualResult = basketBallService.totalColorBalls(color, basket);
        assertEquals(actualResult, expectedResult);
    }
}