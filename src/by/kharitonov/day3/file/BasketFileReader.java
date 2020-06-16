package by.kharitonov.day3.file;

import by.kharitonov.day3.entity.Basket;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class BasketFileReader {
    public Basket deserializeBasket(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream
                (new FileInputStream(fileName))) {
            return (Basket) ois.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
