package by.kharitonov.entity;

public enum BallSize {
    SIZE_THREE(18.0, 0.32),
    SIZE_FIVE(22.3, 0.49),
    SIZE_SIX(23.2, 0.54),
    SIZE_SEVEN(24.2, 0.62);

    private final double diameter;//centimeter
    private final double weight;//kilogram

    BallSize(double diameter, double weight) {
        this.diameter = diameter;
        this.weight = weight;
    }

    public double getDiameter() {
        return diameter;
    }

    public double getWeight() {
        return weight;
    }
}
