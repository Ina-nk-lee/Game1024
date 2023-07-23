package com.example.demo.model;

public class Tile {
    private int num;

    public Tile() {
        num = 0;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int newNum) {
        num = newNum;
    }

    public void multiply() {
        this.setNum(num * 2);
    }
}
