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
        assertEquals("""
                0\t0\t0\t0\t
                0\t0\t0\t0\t
                0\t0\t0\t0\t
                0\t0\t0\t0\t""", testBoard.toString());
    }

    @Test
    void testAddTile() {
        testBoard.addTile();
        int[][] testGrid = testBoard.getGrid();
        int count = 0;

        for(int row = 0; row < SIZE; row++) {
            for(int col = 0; col < SIZE; col++) {
                if(testGrid[row][col] == 1) {
                    count++;
                }
            }
        }

        assertEquals(1, count);
    }

    @Test
    void testGetNum() {
        testBoard.setNum(1, 0, 0);
        testBoard.setNum(2, 0, 1);
        assertEquals("""
                1\t2\t0\t0\t
                0\t0\t0\t0\t
                0\t0\t0\t0\t
                0\t0\t0\t0\t""", testBoard.toString());
    }

    @Test
    void testPushLeft() {
        int[][] testGrid = testBoard.getGrid();
        int count = 0;

        testBoard.setNum(2, 0, 1);
        testBoard.setNum(2, 0, 2);
        testBoard.setNum(2, 0, 3);
        testBoard.push('A');
        for(int row = 0; row < SIZE; row++) {
            for(int col = 0; col < SIZE; col++) {
                if(testGrid[row][col] == 4) {
                    count++;
                }
            }
        }
        assertEquals(1, count);

        count = 0;
        testBoard.clearBoard();
        testBoard.setNum(2, 1, 0);
        testBoard.setNum(2, 1, 1);
        testBoard.setNum(4, 1, 3);
        testBoard.push('A');
        for(int row = 0; row < SIZE; row++) {
            for(int col = 0; col < SIZE; col++) {
                if(testGrid[row][col] == 4) {
                    count++;
                }
            }
        }
        assertEquals(2, count);

        count = 0;
        testBoard.clearBoard();
        testBoard.setNum(2, 0, 0);
        testBoard.setNum(2, 0, 1);
        testBoard.setNum(1, 0, 2);
        testBoard.setNum(1, 0, 3);
        testBoard.push('A');

        for(int row = 0; row < SIZE; row++) {
            for(int col = 0; col < SIZE; col++) {
                if(testGrid[row][col] == 4) {
                    count++;
                }
            }
        }
        assertEquals(1, count);
    }

    @Test
    void testPushRight() {
        int[][] testGrid = testBoard.getGrid();
        int count = 0;
        testBoard.setNum(2, 0, 1);
        testBoard.setNum(2, 0, 2);
        testBoard.setNum(2, 0, 3);
        testBoard.push('D');
        for(int row = 0; row < SIZE; row++) {
            for(int col = 0; col < SIZE; col++) {
                if(testGrid[row][col] == 4) {
                    count++;
                }
            }
        }
        assertEquals(1, count);

        count = 0;
        testBoard.clearBoard();
        testBoard.setNum(4, 1, 0);
        testBoard.setNum(4, 1, 1);
        testBoard.setNum(1, 1, 3);
        testBoard.push('D');
        for(int row = 0; row < SIZE; row++) {
            for(int col = 0; col < SIZE; col++) {
                if(testGrid[row][col] == 8) {
                    count++;
                }
            }
        }
        assertEquals(1, count);

        count = 0;
        testBoard.clearBoard();
        testBoard.setNum(4, 0, 0);
        testBoard.setNum(4, 0, 1);
        testBoard.setNum(4, 0, 2);
        testBoard.push('D');
        for(int row = 0; row < SIZE; row++) {
            for(int col = 0; col < SIZE; col++) {
                if(testGrid[row][col] == 4) {
                    count++;
                }
            }
        }
        assertEquals(1, count);
    }

    @Test
    void testPushUp() {
        int[][] testGrid = testBoard.getGrid();
        int count = 0;
        testBoard.setNum(1, 2, 1);
        testBoard.setNum(1, 3, 1);
        testBoard.push('W');
        for(int row = 0; row < SIZE; row++) {
            for(int col = 0; col < SIZE; col++) {
                if(testGrid[row][col] == 2) {
                    count++;
                }
            }
        }
        assertEquals(1, count);

        count = 0;
        testBoard.clearBoard();
        testBoard.setNum(2, 0, 2);
        testBoard.setNum(2, 1, 2);
        testBoard.setNum(2, 3, 2);
        testBoard.push('W');
        for(int row = 0; row < SIZE; row++) {
            for(int col = 0; col < SIZE; col++) {
                if(testGrid[row][col] == 4) {
                    count++;
                }
            }
        }
        assertEquals(1, count);

        count = 0;
        testBoard.clearBoard();
        testBoard.setNum(1, 0, 3);
        testBoard.setNum(1, 1, 3);
        testBoard.setNum(2, 2, 3);
        testBoard.push('W');
        for(int row = 0; row < SIZE; row++) {
            for(int col = 0; col < SIZE; col++) {
                if(testGrid[row][col] == 2) {
                    count++;
                }
            }
        }
        assertEquals(2, count);

        count = 0;
        testBoard.setNum(1, 0, 3);
        testBoard.setNum(1, 1, 3);
        testBoard.setNum(1, 2, 3);
        testBoard.setNum(1, 3, 3);
        testBoard.push('W');
        for(int row = 0; row < SIZE; row++) {
            for(int col = 0; col < SIZE; col++) {
                if(testGrid[row][col] == 2) {
                    count++;
                }
            }
        }
        assertEquals(2, count);
    }

    @Test
    void testPushDown() {
        int[][] testGrid = testBoard.getGrid();
        int count = 0;
        testBoard.setNum(1, 2, 1);
        testBoard.setNum(1, 3, 1);
        testBoard.push('S');
        for(int row = 0; row < SIZE; row++) {
            for(int col = 0; col < SIZE; col++) {
                if(testGrid[row][col] == 2) {
                    count++;
                }
            }
        }
        assertEquals(1, count);

        count = 0;
        testBoard.clearBoard();
        testBoard.setNum(2, 0, 2);
        testBoard.setNum(2, 1, 2);
        testBoard.setNum(2, 3, 2);
        testBoard.push('S');
        for(int row = 0; row < SIZE; row++) {
            for(int col = 0; col < SIZE; col++) {
                if(testGrid[row][col] == 4) {
                    count++;
                }
            }
        }
        assertEquals(1, count);

        count = 0;
        testBoard.clearBoard();
        testBoard.setNum(1, 0, 3);
        testBoard.setNum(1, 1, 3);
        testBoard.setNum(2, 2, 3);
        testBoard.push('S');
        for(int row = 0; row < SIZE; row++) {
            for(int col = 0; col < SIZE; col++) {
                if(testGrid[row][col] == 2) {
                    count++;
                }
            }
        }
        assertEquals(2, count);

        count = 0;
        testBoard.clearBoard();
        testBoard.setNum(1, 0, 3);
        testBoard.setNum(1, 1, 3);
        testBoard.setNum(1, 2, 3);
        testBoard.setNum(1, 3, 3);
        testBoard.push('S');
        for(int row = 0; row < SIZE; row++) {
            for(int col = 0; col < SIZE; col++) {
                if(testGrid[row][col] == 2) {
                    count++;
                }
            }
        }
        assertEquals(2, count);
    }
}
