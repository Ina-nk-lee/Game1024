package com.example.demo.model;

import javafx.scene.paint.Color;

public class Tile {
    private int num;
    private Color color;

    public Tile() {
        num = 0;
        color = Color.PAPAYAWHIP;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int newNum) {
        num = newNum;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color newColor) {
        color = newColor;
    }

    public void multiply() {
        this.setNum(num * 2);
        this.setColor(color.deriveColor(0, 1.05, 1, 1));
    }
}
