package by.epam.kharitonov.day3.entity;

import by.kharitonov.day3.entity.Ball;
import by.kharitonov.day3.entity.BallType;
import by.kharitonov.day3.entity.Basket;
import by.kharitonov.day3.entity.CustomColor;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class BasketTest {
    @DataProvider(name = "dataForTestAdd")
    @Test
    public Object[][] dataForTestAdd() {
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
    @Test(dataProvider = "dataForTestAdd", groups = "addBall", priority = 2)
    public void testAdd(Ball ball, Basket basket,
                        boolean expectedResult) {
        boolean actualResult = basket.add(ball);
        assertEquals(actualResult, expectedResult);
    }

    @DataProvider(name = "dataForRemoveTest")
    @Test
    public Object[][] dataForRemoveTest() {
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
    @Test(dataProvider = "dataForRemoveTest")
    public void testRemove(Basket basket, int index,
                           boolean expectedResult) {
        boolean actualResult = basket.remove(index);
        assertEquals(actualResult, expectedResult);
    }

    @DataProvider(name = "dataForGetBall")
    @Test
    public Object[][] dataForGetBall() {
        Basket basket = new Basket(30, 5);
        Ball ball1 = new Ball(BallType.SIZE_FIVE, CustomColor.RED);
        Ball ball2 = new Ball(BallType.SIZE_SEVEN, CustomColor.BLUE);
        Ball ball3 = new Ball(BallType.SIZE_SIX, CustomColor.GREEN);
        Ball ball4 = new Ball(BallType.SIZE_THREE, CustomColor.BLACK);
        basket.add(ball1);
        basket.add(ball2);
        basket.add(ball3);
        basket.add(ball4);
        basket.add(ball1);
        return new Object[][]{
                {basket, 0, ball1},
                {basket, 1, ball2},
                {basket, 2, ball3},
                {basket, 3, ball4},
                {basket, 4, ball1},
        };
    }

    @Parameters({"basket", "index", "exectedResult"})
    @Test(dataProvider = "dataForGetBall")
    public void testGetBall(Basket basket, int index, Ball expectedResult) {
        Ball actualResult = basket.getBall(index);
        assertEquals(actualResult, expectedResult);
    }

    @DataProvider(name = "dataForTotalBalls")
    @Test
    public Object[][] dataForTotalBalls() {
        Basket basket1 = new Basket(30, 5);
        Basket basket2 = new Basket(33, 6);
        basket1.add(new Ball(BallType.SIZE_FIVE,
                CustomColor.RED));
        basket2.add(new Ball(BallType.SIZE_SIX,
                CustomColor.BLUE));
        basket2.add(new Ball(BallType.SIZE_THREE,
                CustomColor.YELLOW));

        return new Object[][]{
                {new Basket(25, 15), 0},
                {basket1, 1},
                {basket2, 2}
        };
    }

    @Parameters({"basket", "expectedResult"})
    @Test(dataProvider = "dataForTotalBalls")
    public void testTotalBalls(Basket basket, int expectedResult) {
        int actualResult = basket.totalBalls();
        assertEquals(actualResult, expectedResult);
    }

    @DataProvider(name = "dataForTotalBallsWeight")
    @Test
    public Object[][] dataForTotalBallsWeight() {
        Basket basket1 = new Basket(30, 5);
        Basket basket2 = new Basket(33, 6);
        basket1.add(new Ball(BallType.SIZE_FIVE,
                CustomColor.RED));
        basket2.add(new Ball(BallType.SIZE_SIX,
                CustomColor.BLUE));
        basket2.add(new Ball(BallType.SIZE_THREE,
                CustomColor.YELLOW));

        return new Object[][]{
                {new Basket(25, 15), 0},
                {basket1, 0.49},
                {basket2, 0.86}
        };
    }

    @Parameters({"basket", "expectedResult"})
    @Test(dataProvider = "dataForTotalBallsWeight")
    public void testTotalBallsWeight(Basket basket, double expectedResult) {
        double actualResult = basket.totalBallsWeight();
        assertEquals(actualResult, expectedResult, 0.0001);
    }

}