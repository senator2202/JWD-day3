package by.epam.kharitonov.day3.entity;

import by.kharitonov.entity.Ball;
import by.kharitonov.entity.BallSize;
import by.kharitonov.entity.Basket;
import by.kharitonov.entity.CustomColor;
import by.kharitonov.exception.BasketBallException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class BasketTest {

    @Test
    public void testCreateBasket() {
        try {
            Basket actualBasket = Basket.createBasket(30, 2);
            Object actual = new double[]{actualBasket.getDiameter(),
                    actualBasket.getCapacity(), actualBasket.totalBalls()};
            Object expected = new double[]{30, 2, 0};
            assertEquals(actual, expected);
        } catch (BasketBallException e) {
            fail();
        }
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
        Basket.createBasket(parameters[0],
                (int) parameters[1]);
    }

    @DataProvider(name = "dataForTotalBalls")
    @Test
    public Object[][] dataForTotalBalls() {
        try {
            Basket basket1 = Basket.createBasket(30, 5);
            Basket basket2 = Basket.createBasket(33, 6);
            basket1.getBalls().add(new Ball(BallSize.SIZE_FIVE,
                    CustomColor.RED));
            basket2.getBalls().add(new Ball(BallSize.SIZE_SIX,
                    CustomColor.BLUE));
            basket2.getBalls().add(new Ball(BallSize.SIZE_THREE,
                    CustomColor.YELLOW));

            return new Object[][]{
                    {Basket.createBasket(25, 15), 0},
                    {basket1, 1},
                    {basket2, 2}
            };
        } catch (BasketBallException e) {
            return new Object[][]{};
        }
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
        try {
            Basket basket1 = Basket.createBasket(30, 5);
            Basket basket2 = Basket.createBasket(33, 6);
            basket1.getBalls().add(new Ball(BallSize.SIZE_FIVE,
                    CustomColor.RED));
            basket2.getBalls().add(new Ball(BallSize.SIZE_SIX,
                    CustomColor.BLUE));
            basket2.getBalls().add(new Ball(BallSize.SIZE_THREE,
                    CustomColor.YELLOW));

            return new Object[][]{
                    {Basket.createBasket(25, 15), 0},
                    {basket1, 0.49},
                    {basket2, 0.86}
            };
        } catch (BasketBallException e) {
            return new Object[][]{};
        }
    }

    @Parameters({"basket", "expectedResult"})
    @Test(dataProvider = "dataForTotalBallsWeight")
    public void testTotalBallsWeight(Basket basket, double expectedResult) {
        double actualResult = basket.totalBallsWeight();
        assertEquals(actualResult, expectedResult, 0.0001);
    }
}