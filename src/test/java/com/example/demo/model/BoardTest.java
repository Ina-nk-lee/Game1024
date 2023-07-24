package com.example.demo.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {
    Board testBoard;
    Tile tileA;
    Tile tileB;
    int SIZE = 4;

    @BeforeEach
    void runBefore() {
        testBoard = new Board();
        tileA = new Tile();
        tileB = new Tile();
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
        Tile[][] testGrid = testBoard.getGrid();
        int count = 0;

        for(int row = 0; row < SIZE; row++) {
            for(int col = 0; col < SIZE; col++) {
                if(testGrid[row][col].getNum() == 1) {
                    count++;
                }
            }
        }

        assertEquals(2, count);
    }

    @Test
    void testGetTile() {
        testBoard.getTile(0, 0).setNum(1);
        testBoard.getTile(0, 1).setNum(2);
        assertEquals("1 2 0 0 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n", testBoard.toString());
    }

    @Test
    void testPushLeftWhenLeftIsEmpty() {
        testBoard.getTile(0, 1).setNum(1);
        testBoard.getTile(0, 2).setNum(2);
        testBoard.pushLeft();
        assertEquals("1 2 0 0 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n", testBoard.toString());
    }

    @Test
    void testPushLeftWhenMiddleIsEmpty() {
        testBoard.getTile(0, 0).setNum(1);
        testBoard.getTile(0, 3).setNum(2);
        testBoard.pushLeft();
        assertEquals("1 2 0 0 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n", testBoard.toString());

        testBoard.clearBoard();
        testBoard.getTile(0, 1).setNum(1);
        testBoard.getTile(0, 3).setNum(2);
        testBoard.pushLeft();
        assertEquals("1 2 0 0 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n", testBoard.toString());
    }

    @Test
    void testPushLeftWhenRightIsEmpty() {
        testBoard.getTile(0, 1).setNum(1);
        testBoard.getTile(0, 3).setNum(2);
        testBoard.pushLeft();
        assertEquals("1 2 0 0 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n", testBoard.toString());
    }
}
