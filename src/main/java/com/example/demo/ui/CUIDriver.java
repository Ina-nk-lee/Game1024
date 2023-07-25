package com.example.demo.ui;

import com.example.demo.model.Board;

import java.util.Scanner;

public class CUIDriver {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Board board = new Board();
        board.startGame();
        boolean keepPlaying = true;

        while(keepPlaying) {
            System.out.println(board);
            if(board.isGameOver()) {
                break;
            }
            try {
                char command = scan.nextLine().toUpperCase().charAt(0);
                if(command == 'Q') {
                    keepPlaying = false;
                }
                board.push(command);
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println(e);
            }
        }
    }
}
