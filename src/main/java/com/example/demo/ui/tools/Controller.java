package com.example.demo.ui.tools;

import javafx.scene.input.KeyEvent;

public class Controller {
    private Controller() {
    }

    public static void onKeyPress(KeyEvent e) {
        switch(e.getCode()) {
            case LEFT:
                BoardBuilder.push('A');
                BoardBuilder.updateBoard();
                break;
            case RIGHT:
                BoardBuilder.push('D');
                BoardBuilder.updateBoard();
                break;
            case UP:
                BoardBuilder.push('W');
                BoardBuilder.updateBoard();
                break;
            case DOWN:
                BoardBuilder.push('S');
                BoardBuilder.updateBoard();
                break;
            default:
                break;
        }
    }
}