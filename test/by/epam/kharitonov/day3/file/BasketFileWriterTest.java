package by.epam.kharitonov.day3.file;

import by.kharitonov.day3.entity.Ball;
import by.kharitonov.day3.entity.BallType;
import by.kharitonov.day3.entity.Basket;
import by.kharitonov.day3.entity.CustomColor;
import by.kharitonov.day3.file.BasketFileWriter;
import org.testng.Assert;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BasketFileWriterTest {
    private BasketFileWriter basketFileWriter;
    private final Basket testBasket;

    {
        testBasket = new Basket(30, 5);
        testBasket.add(new Ball(BallType.SIZE_FIVE, CustomColor.RED));
        testBasket.add(new Ball(BallType.SIZE_SEVEN, CustomColor.BLUE));
        testBasket.add(new Ball(BallType.SIZE_SIX, CustomColor.GREEN));
        testBasket.add(new Ball(BallType.SIZE_THREE, CustomColor.BLACK));
    }

    @BeforeTest
    @BeforeGroups(groups = {"serialization/deserialization", "writing/reading",
            "fileStreaming"})
    public void init() {
        basketFileWriter = new BasketFileWriter();
    }

    @Test(groups = "serialization/deserialization", priority = 0)
    public void testSerializeBasket() {
        Basket basket = testBasket;
        boolean actual = basketFileWriter.serializeBasket(basket,
                "BasketSerialization.txt");
        Assert.assertTrue(actual);
    }

    @Test(groups = "writing/reading", priority = 1)
    public void testWriteBasket() {
        Basket basket = testBasket;
        boolean actual = basketFileWriter.writeBasket(basket,
                "Basket.txt");
        Assert.assertTrue(actual);
    }

    @Test(groups = "fileStreaming", priority = 1)
    public void testOutputStreamBasket() {
        Basket basket = testBasket;
        boolean actual = basketFileWriter.outputStreamBasket(basket,
                "BasketStream.txt");
        Assert.assertTrue(actual);
    }
}