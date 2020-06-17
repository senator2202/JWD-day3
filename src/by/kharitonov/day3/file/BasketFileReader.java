package by.kharitonov.day3.file;

import by.kharitonov.day3.entity.Basket;
import by.kharitonov.day3.exception.BasketBallRuntimeException;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;

public class BasketFileReader {
    public Basket deserializeBasket(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream
                (new FileInputStream(fileName))) {
            return (Basket) ois.readObject();
        } catch (Exception ex) {
            throw new BasketBallRuntimeException("Error, while opening file!");
        }
    }

    public String readBasket(String fileName) {
        try (FileReader reader = new FileReader(fileName)) {
            int c;
            StringBuilder sb = new StringBuilder();
            while ((c = reader.read()) != -1) {
                sb.append((char) c);
            }
            return sb.toString();
        } catch (IOException ex) {
            throw new BasketBallRuntimeException("Error, while opening file!");
        }
    }
}
