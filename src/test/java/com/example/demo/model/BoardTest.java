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
        assertEquals("""
                1 2 0 0\s
                0 0 0 0\s
                0 0 0 0\s
                0 0 0 0\s
                """, testBoard.toString());
    }

    @Test
    void testPushLeft() {
        testBoard.setNum(2, 0, 1);
        testBoard.setNum(2, 0, 2);
        testBoard.setNum(2, 0, 3);
        testBoard.push('L');
        assertEquals("""
                4 2 0 0\s
                0 0 0 0\s
                0 0 0 0\s
                0 0 0 0\s
                """, testBoard.toString());

        testBoard.initBoard();
        testBoard.setNum(2, 1, 0);
        testBoard.setNum(2, 1, 1);
        testBoard.setNum(4, 1, 3);
        testBoard.push('L');
        assertEquals("""
                0 0 0 0\s
                4 4 0 0\s
                0 0 0 0\s
                0 0 0 0\s
                """, testBoard.toString());

        testBoard.initBoard();
        testBoard.setNum(2, 0, 0);
        testBoard.setNum(2, 0, 1);
        testBoard.setNum(1, 0, 2);
        testBoard.setNum(1, 0, 3);

        testBoard.push('L');
        assertEquals("""
                4 2 0 0\s
                0 0 0 0\s
                0 0 0 0\s
                0 0 0 0\s
                """, testBoard.toString());
    }

    @Test
    void testPushRight() {
        testBoard.setNum(2, 0, 1);
        testBoard.setNum(2, 0, 2);
        testBoard.setNum(2, 0, 3);
        testBoard.push('R');
        assertEquals("""
                0 0 2 4\s
                0 0 0 0\s
                0 0 0 0\s
                0 0 0 0\s
                """, testBoard.toString());

        testBoard.initBoard();
        testBoard.setNum(4, 1, 0);
        testBoard.setNum(4, 1, 1);
        testBoard.setNum(1, 1, 3);
        testBoard.push('R');
        assertEquals("""
                0 0 0 0\s
                0 0 8 1\s
                0 0 0 0\s
                0 0 0 0\s
                """, testBoard.toString());

        testBoard.initBoard();
        testBoard.setNum(4, 0, 0);
        testBoard.setNum(4, 0, 1);
        testBoard.setNum(4, 0, 2);
        testBoard.push('R');
        assertEquals("""
                0 0 4 8\s
                0 0 0 0\s
                0 0 0 0\s
                0 0 0 0\s
                """, testBoard.toString());
    }

    @Test
    void testPushUp() {
        testBoard.setNum(1, 2, 1);
        testBoard.setNum(1, 3, 1);
        testBoard.push('U');
        assertEquals("""
                0 2 0 0\s
                0 0 0 0\s
                0 0 0 0\s
                0 0 0 0\s
                """, testBoard.toString());

        testBoard.initBoard();
        testBoard.setNum(2, 0, 2);
        testBoard.setNum(2, 1, 2);
        testBoard.setNum(2, 3, 2);
        testBoard.push('U');
        assertEquals("""
                0 0 4 0\s
                0 0 2 0\s
                0 0 0 0\s
                0 0 0 0\s
                """, testBoard.toString());

        testBoard.initBoard();
        testBoard.setNum(1, 0, 3);
        testBoard.setNum(1, 1, 3);
        testBoard.setNum(2, 2, 3);
        testBoard.push('U');
        assertEquals("""
                0 0 0 2\s
                0 0 0 2\s
                0 0 0 0\s
                0 0 0 0\s
                """, testBoard.toString());

        testBoard.setNum(1, 0, 3);
        testBoard.setNum(1, 1, 3);
        testBoard.setNum(1, 2, 3);
        testBoard.setNum(1, 3, 3);
        testBoard.push('U');
        assertEquals("""
                0 0 0 2\s
                0 0 0 2\s
                0 0 0 0\s
                0 0 0 0\s
                """, testBoard.toString());
    }

    @Test
    void testPushDown() {
        testBoard.setNum(1, 2, 1);
        testBoard.setNum(1, 3, 1);
        testBoard.push('D');
        assertEquals("""
                0 0 0 0\s
                0 0 0 0\s
                0 0 0 0\s
                0 2 0 0\s
                """, testBoard.toString());

        testBoard.initBoard();
        testBoard.setNum(2, 0, 2);
        testBoard.setNum(2, 1, 2);
        testBoard.setNum(2, 3, 2);
        testBoard.push('D');
        assertEquals("""
                0 0 0 0\s
                0 0 0 0\s
                0 0 2 0\s
                0 0 4 0\s
                """, testBoard.toString());

        testBoard.initBoard();
        testBoard.setNum(1, 0, 3);
        testBoard.setNum(1, 1, 3);
        testBoard.setNum(2, 2, 3);
        testBoard.push('D');
        assertEquals("""
                0 0 0 0\s
                0 0 0 0\s
                0 0 0 2\s
                0 0 0 2\s
                """, testBoard.toString());

        testBoard.initBoard();
        testBoard.setNum(1, 0, 3);
        testBoard.setNum(1, 1, 3);
        testBoard.setNum(1, 2, 3);
        testBoard.setNum(1, 3, 3);
        testBoard.push('D');
        assertEquals("""
                0 0 0 0\s
                0 0 0 0\s
                0 0 0 2\s
                0 0 0 2\s
                """, testBoard.toString());
    }
}
