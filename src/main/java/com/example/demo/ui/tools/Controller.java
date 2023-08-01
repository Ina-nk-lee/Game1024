package com.example.demo.ui.tools;

import javafx.scene.input.KeyEvent;

public class Controller {
    private Controller() {
    }

    public static void onKeyPress(KeyEvent e) {
        BoardBuilder.updateBoard();
        switch(e.getCode()) {
            case LEFT:
                BoardBuilder.push('A');
                break;
            case RIGHT:
                BoardBuilder.push('D');
                break;
            case UP:
                BoardBuilder.push('W');
                break;
            case DOWN:
                BoardBuilder.push('S');
                break;
            default:
                break;
        }
    }
}