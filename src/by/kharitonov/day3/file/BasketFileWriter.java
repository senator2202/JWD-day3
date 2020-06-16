package by.kharitonov.day3.file;

import by.kharitonov.day3.entity.Basket;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class BasketFileWriter {
    public boolean serializeBasket(Basket basket, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream
                (new FileOutputStream(fileName))) {
            oos.writeObject(basket);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
