package by.kharitonov.day3.file;

import by.kharitonov.day3.entity.Ball;
import by.kharitonov.day3.entity.Basket;

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
        try(FileWriter writer = new FileWriter(fileName, false))
        {
            StringBuilder result= new StringBuilder();
            result.append(basket.getDiameter());
            result.append(" ").append(basket.getCapacity());
            for (int i=0; i<basket.totalBalls(); i++) {
                Ball ball = basket.getBall(i);
                result.append("\n").append(ball.getBallType());
                result.append(" ").append(ball.getColor());
            }
            writer.write(result.toString());
            writer.flush();
            return true;
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
