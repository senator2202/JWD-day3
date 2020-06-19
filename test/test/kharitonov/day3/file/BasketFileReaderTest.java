package test.kharitonov.day3.file;

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
    private BasketFileReader basketFileReader;
    private String testData;
    private Basket testBasket;

    @BeforeTest
    @BeforeGroups(groups = {"writing/reading", "serialization/deserialization",
            "fileStreaming"})
    private void init() {
        basketFileReader = new BasketFileReader();
        testData = "30.0 5\n" +
                "SIZE_FIVE RED\n" +
                "SIZE_SEVEN BLUE\n" +
                "SIZE_SIX GREEN\n" +
                "SIZE_THREE BLACK";
        testBasket = new Basket(30, 5);
        testBasket.add(new Ball(BallType.SIZE_FIVE, CustomColor.RED));
        testBasket.add(new Ball(BallType.SIZE_SEVEN, CustomColor.BLUE));
        testBasket.add(new Ball(BallType.SIZE_SIX, CustomColor.GREEN));
        testBasket.add(new Ball(BallType.SIZE_THREE, CustomColor.BLACK));
    }

    @Test(groups = "serialization/deserialization", priority = 1)
    public void testDeserializeBasket() {
        Basket actual = basketFileReader.
                deserializeBasket("BasketSerialization.txt");
        Basket expected = testBasket;
        Assert.assertEquals(actual, expected);
    }

    @Test(groups = "serialization/deserialization", priority = 2,
            expectedExceptions = BasketBallRuntimeException.class)
    public void testDeserializeBasketException() {
        basketFileReader.
                deserializeBasket("ExceptionSerialization.txt");
    }

    @Test(groups = "writing/reading", priority = 2)
    public void testReadBasket() {
        String actual = basketFileReader.readBasket("Basket.txt");
        String expected = testData;
        Assert.assertEquals(actual, expected);
    }

    @Test(groups = "writing/reading", priority = 3,
            expectedExceptions = BasketBallRuntimeException.class)
    public void testReadBasketException() {
        basketFileReader.readBasket("Exception.txt");
    }

    @Test(groups = "fileStreaming", priority = 2)
    public void testInputStreamBasket() {
        String actual = basketFileReader.
                inputStreamBasket("BasketStream.txt");
        String expected = testData;
        Assert.assertEquals(actual, expected);
    }

    @Test(groups = "fileStreaming", priority = 3,
            expectedExceptions = BasketBallRuntimeException.class)
    public void testInputStreamBasketException() {
        basketFileReader.inputStreamBasket("Exception.txt");
    }
}