package by.epam.kharitonov.day3.file;

import by.kharitonov.day3.entity.Ball;
import by.kharitonov.day3.entity.BallType;
import by.kharitonov.day3.entity.Basket;
import by.kharitonov.day3.entity.CustomColor;
import by.kharitonov.day3.file.BasketFileReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasketFileReaderTest {
    BasketFileReader basketFileReader = new BasketFileReader();

    @Test
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
}