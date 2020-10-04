package sda.fitapp.entity;

public enum LifeStyle {
    VERYLOW(1.2), LOW(1.4), MIDDLE(1.6), HIGH(1.8), VERYHIGH(2.0);

    private final double numVal;

    LifeStyle(double numVal) {
        this.numVal = numVal;
    }

    public double getNumVal() {
        return numVal;
    }
}
