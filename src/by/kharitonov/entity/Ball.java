package by.kharitonov.entity;

import java.awt.*;

public class Ball {
    private double diameter;
    private Color color;
    private double weight;

    public Ball(double diameter, Color color, double weight) {
        this.diameter = diameter;
        this.color = color;
        this.weight = weight;
    }

    public double getDiameter() {
        return diameter;
    }

    public Color getColor() {
        return color;
    }

    public double getWeight() {
        return weight;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
