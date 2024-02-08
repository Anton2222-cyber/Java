package edu.itstep.inheritance;

public abstract class Shape {
    private String borderColor;
    private String backgroundColor;

    public Shape(String borderColor, String backgroundColor) {
        this.borderColor = borderColor;
        this.backgroundColor = backgroundColor;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
    //ctrl + O
    //alt + insert


    @Override
    public String toString() {
        return ", " +
                "borderColor='" + borderColor + '\'' +
                ", backgroundColor='" + backgroundColor + '\'' +
                '}';
    }

    public abstract double calcArea();
}
