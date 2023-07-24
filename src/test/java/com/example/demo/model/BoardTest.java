package com.example.demo.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {
    Board testBoard;
    int SIZE = 4;

    @BeforeEach
    void runBefore() {
        testBoard = new Board();
    }

    @Test
    void testBuildBoard() {
        assertEquals("0 0 0 0 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n", testBoard.toString());
    }

    @Test
    void testInitGame() {
        testBoard.initGame();
        int[][] testGrid = testBoard.getGrid();
        int count = 0;

        for(int row = 0; row < SIZE; row++) {
            for(int col = 0; col < SIZE; col++) {
                if(testGrid[row][col] == 1) {
                    count++;
                }
            }
        }

        assertEquals(2, count);
    }

    @Test
    void testGetNum() {
        testBoard.setNum(1, 0, 0);
        testBoard.setNum(2, 0, 1);
        assertEquals("1 2 0 0 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n", testBoard.toString());
    }

    @Test
    void testPushLeftWhenLeftIsEmpty() {
        testBoard.setNum(1, 0, 1);
        testBoard.setNum(2, 0, 2);
        testBoard.pushLeft();
        assertEquals("1 2 0 0 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n", testBoard.toString());

        testBoard.initBoard();
        testBoard.setNum(1, 0, 2);
        testBoard.setNum(2, 0, 3);
        testBoard.pushLeft();
        assertEquals("1 2 0 0 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n", testBoard.toString());
    }

    @Test
    void testPushLeftWhenMiddleIsEmpty() {
        testBoard.setNum(1, 1, 1);
        testBoard.setNum(2, 1, 3);
        testBoard.pushLeft();
        assertEquals("0 0 0 0 \n" +
                "1 2 0 0 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n", testBoard.toString());
    }

    @Test
    void testPushLeftWhenRightIsEmpty() {
        testBoard.setNum(1, 0, 1);
        testBoard.setNum(2, 0, 2);
        testBoard.pushLeft();
        assertEquals("1 2 0 0 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n", testBoard.toString());
    }
}
