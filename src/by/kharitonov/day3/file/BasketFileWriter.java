package by.kharitonov.day3.file;

import by.kharitonov.day3.entity.Basket;
import by.kharitonov.day3.parser.BasketBallParser;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
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

    public boolean writeBasket(Basket basket, String fileName) {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            BasketBallParser parser = new BasketBallParser();
            String result = parser.reverseParseBasket(basket);
            writer.write(result);
            writer.flush();
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean outputStreamBasket(Basket basket, String fileName) {
        try (FileOutputStream fileOutputStream =
                     new FileOutputStream(fileName)) {
            BasketBallParser parser = new BasketBallParser();
            String data = parser.reverseParseBasket(basket);
            fileOutputStream.write(data.getBytes());
            fileOutputStream.flush();
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
