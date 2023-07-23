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
        int count = 0;
        for(int row = 0; row < SIZE; row++) {
            for(int col = 0; col < SIZE; col++) {
                //if()
            }
        }
    }
}
