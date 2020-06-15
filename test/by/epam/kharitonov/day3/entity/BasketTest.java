package by.epam.kharitonov.day3.entity;

import by.kharitonov.day3.entity.Ball;
import by.kharitonov.day3.entity.BallSize;
import by.kharitonov.day3.entity.Basket;
import by.kharitonov.day3.entity.CustomColor;
import by.kharitonov.day3.exception.BasketBallException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BasketTest {

    @Test
    public void testCreateBasket() {
        Basket actualBasket = new Basket(30, 2);
        Object actual = new double[]{actualBasket.getDiameter(),
                actualBasket.getCapacity(), actualBasket.totalBalls()};
        Object expected = new double[]{30, 2, 0};
        assertEquals(actual, expected);
    }

    @DataProvider(name = "dataForCreateBasketException")
    @Test
    public Object[][] dataForCreateBasketException() {
        return new Object[][]{
                {new double[]{-2, 5}},
                {new double[]{30, -4}},
                {new double[]{0, 0}},
                {new double[]{0, 5}},
                {new double[]{7, 0}}
        };
    }

    @Parameters("parameters")
    @Test(expectedExceptions = BasketBallException.class,
            dataProvider = "dataForCreateBasketException")
    public void testCreateBasketException(double[] parameters)
            throws BasketBallException {
        new Basket(parameters[0],
                (int) parameters[1]);
    }

    @DataProvider(name = "dataForTotalBalls")
    @Test
    public Object[][] dataForTotalBalls() {
        Basket basket1 = new Basket(30, 5);
        Basket basket2 = new Basket(33, 6);
        basket1.add(new Ball(BallSize.SIZE_FIVE,
                CustomColor.RED));
        basket2.add(new Ball(BallSize.SIZE_SIX,
                CustomColor.BLUE));
        basket2.add(new Ball(BallSize.SIZE_THREE,
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
        basket1.add(new Ball(BallSize.SIZE_FIVE,
                CustomColor.RED));
        basket2.add(new Ball(BallSize.SIZE_SIX,
                CustomColor.BLUE));
        basket2.add(new Ball(BallSize.SIZE_THREE,
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