package com.example.probabilitysim;

public class Marble {
    private String color;
    private int total;

    public Marble(String color, int total) {
        this.color=color;
        this.total=total;
    }
    public String getColor() {
        return color;
    }

    public int getTotal() {
        return total;
    }

    public void displayInfo() {
    }
}