package by.epam.kharitonov.day3.file;

import by.kharitonov.day3.entity.Ball;
import by.kharitonov.day3.entity.BallType;
import by.kharitonov.day3.entity.Basket;
import by.kharitonov.day3.entity.CustomColor;
import by.kharitonov.day3.file.BasketFileWriter;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasketFileWriterTest {
    BasketFileWriter basketFileWriter = new BasketFileWriter();

    @Test
    public void testSerializeBasket() {
        Basket basket = new Basket(30, 5);
        basket.add(new Ball(BallType.SIZE_FIVE, CustomColor.RED));
        basket.add(new Ball(BallType.SIZE_SEVEN, CustomColor.BLUE));
        basket.add(new Ball(BallType.SIZE_SIX, CustomColor.GREEN));
        basket.add(new Ball(BallType.SIZE_THREE, CustomColor.BLACK));
        boolean actual = basketFileWriter.serializeBasket(basket,
                "BasketSerialization.txt");
        Assert.assertTrue(actual);
    }
}