package by.epam.kharitonov.day3.file;

import by.kharitonov.day3.entity.Ball;
import by.kharitonov.day3.entity.BallType;
import by.kharitonov.day3.entity.Basket;
import by.kharitonov.day3.entity.CustomColor;
import by.kharitonov.day3.exception.BasketBallRuntimeException;
import by.kharitonov.day3.file.BasketFileReader;
import org.testng.Assert;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BasketFileReaderTest {
    BasketFileReader basketFileReader;

    @BeforeTest
    @BeforeGroups(groups = {"writing/reading", "serialization/deserialization"})
    private void init() {
        basketFileReader = new BasketFileReader();
    }

    @Test(groups = "serialization/deserialization", priority = 1)
    public void testDeserializeBasket() {
        Basket actual = basketFileReader.
                deserializeBasket("BasketSerialization.txt");
        Basket expected = new Basket(30, 5);
        expected.add(new Ball(BallType.SIZE_FIVE, CustomColor.RED));
        expected.add(new Ball(BallType.SIZE_SEVEN, CustomColor.BLUE));
        expected.add(new Ball(BallType.SIZE_SIX, CustomColor.GREEN));
        expected.add(new Ball(BallType.SIZE_THREE, CustomColor.BLACK));
        Assert.assertEquals(actual, expected);
    }

    @Test(groups = "serialization/deserialization", priority = 2,
            expectedExceptions = BasketBallRuntimeException.class)
    public void testDeserializeBasketException() {
        Basket actual = basketFileReader.
                deserializeBasket("ExceptionSerialization.txt");
    }

    @Test(groups = "writing/reading", priority = 1)
    public void testReadBasket() {
        String actual = basketFileReader.readBasket("Basket.txt");
        String expected = "30.0 5\n" +
                "SIZE_FIVE RED\n" +
                "SIZE_SEVEN BLUE\n" +
                "SIZE_SIX GREEN\n" +
                "SIZE_THREE BLACK";
        Assert.assertEquals(actual, expected);
    }

    @Test(groups = "writing/reading", priority = 2,
            expectedExceptions = BasketBallRuntimeException.class)
    public void testReadBasketException() {
        basketFileReader.readBasket("Exception.txt");
    }
}