package com.example.demo.ui.tools;

import com.example.demo.model.Board;
import javafx.scene.input.KeyEvent;

public class Controller {
    private static Board board;

    private Controller() {
    }

    public static void setController(Board newBoard) {
        board = newBoard;
    }

    public static void onKeyPress(KeyEvent e) {
        switch(e.getCode()) {
            case LEFT:
                board.push('A');
                BoardBuilder.updateBoard();
                break;
            case RIGHT:
                board.push('D');
                BoardBuilder.updateBoard();
                break;
            case UP:
                board.push('W');
                BoardBuilder.updateBoard();
                break;
            case DOWN:
                board.push('S');
                BoardBuilder.updateBoard();
                break;
            default:
                break;
        }
    }
}