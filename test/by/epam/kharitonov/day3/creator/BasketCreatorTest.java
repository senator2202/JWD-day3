package by.epam.kharitonov.day3.creator;

import by.kharitonov.day3.creator.BasketCreator;
import by.kharitonov.day3.entity.Basket;
import by.kharitonov.day3.exception.BasketBallException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BasketCreatorTest {
    private BasketCreator basketCreator;

    @BeforeTest
    private void init() {
        basketCreator = new BasketCreator();
    }

    @DataProvider(name = "dataForCreateBasket")
    @Test
    public Object[][] dataForCreateBasket() {
        return new Object[][]{
                {30, 2, new Basket(30, 2)},
                {0.1, 1, new Basket(0.1, 1)}
        };
    }

    @Parameters({"diameter", "capacity", "expectedResult"})
    @Test(dataProvider = "dataForCreateBasket")
    public void testCreateBasket(double diameter, int capacity,
                                 Basket expectedResult) {
        try {
            Basket actualResult = basketCreator.createBasket(diameter,
                    capacity);
            Assert.assertEquals(actualResult, expectedResult);
        } catch (BasketBallException e) {
            Assert.fail();
        }
    }

    @DataProvider(name = "dataForCreateBasketException")
    @Test
    public Object[][] dataForCreateBasketException() {
        return new Object[][]{
                {0, 2},
                {2.3, 0},
                {-2.3, 23},
                {30.3, -2}
        };
    }

    @Parameters({"diameter", "capacity", "expectedResult"})
    @Test(dataProvider = "dataForCreateBasketException",
            expectedExceptions = BasketBallException.class)
    public void testCreateBasketException(double diameter, int capacity)
            throws BasketBallException {
        basketCreator.createBasket(diameter, capacity);
    }
}