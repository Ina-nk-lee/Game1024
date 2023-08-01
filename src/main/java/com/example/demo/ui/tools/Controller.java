package com.example.demo.ui.tools;

import javafx.scene.input.KeyEvent;

public class Controller {

    /**
     * Processes a key press to control a 1024 game.
     * @param e is a key press event.
     */
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