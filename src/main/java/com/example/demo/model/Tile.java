package com.example.demo.model;

import javafx.animation.TranslateTransition;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Tile extends StackPane {
    private int num;
    private Rectangle sqr;
    private Text text;
    public TranslateTransition slide;
    private final int WIDTH = 50;

    public Tile() {
        this.num = 0;
        this.sqr = new Rectangle(WIDTH, WIDTH);
        updateColor();
        this.getChildren().addAll(this.sqr);

        slide = new TranslateTransition(Duration.millis(2000), this);
    }

    /**
     * A getter for a tile's number.
     * @return a tile's number.
     */
    public int getNumber() {
        return this.num;
    }

    public int getLength() {
        return WIDTH;
    }

    /**
     * Updates the color of a tile depending on its number.
     */
    private void updateColor() {
        Color color = Color.rgb(70, 70, 70);
        switch(this.num) {
            case 1:
                color = Color.web("fcf9f2");
                break;
            case 2:
                color = Color.web("f4e4cf");
                break;
            case 4:
                color = Color.web("f0cdb0");
                break;
            case 8:
                color = Color.web("eeb496");
                break;
            case 16:
                color = Color.web("ed9a84");
                break;
            case 32:
                color = Color.web("e97e79");
                break;
            case 64:
                color = Color.web("e36076");
                break;
            case 128:
                color = Color.web("dd598e");
                break;
            case 256:
                color = Color.web("ce59a7");
                break;
            case 512:
                color = Color.web("b35fc0");
                break;
            case 1024:
                color = Color.web("8a69d4");
                break;
        }
        sqr.setFill(color);
    }

    /**
     * Updates the text of a tile depending on its number.
     */
    private void updateText() {
        String numStr = "";
        if(this.num != 0) {
            numStr = Integer.toString(num);
        }
        this.text = new Text(numStr);
        this.text.setFont(Font.font(20));
    }

    /**
     * Sets a tile's number and updates the appearance of it accordingly.
     * @param newNum to be set.
     */
    public void updateTile(int newNum) {
        if(this.num != newNum) {
            this.num = newNum;
            updateColor();
            updateText();
            this.getChildren().clear();
            this.getChildren().addAll(this.sqr, this.text);
        }
    }

    public void slideLeft() {
        if(this.num != 0) {
            this.toFront();
            slide.setByX(-250);
            slide.play();
        }
    }

    public void slideRight() {
        if(this.num != 0) {
            this.toFront();
            slide.setByX(250);
            slide.play();
        }
    }
}
