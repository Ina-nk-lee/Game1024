package com.example.demo.model;

import java.util.Random;

/**
 * This class represents the main board of the 1024 Game.
 *
 */
public class Board {
    int[][] grid;
    int BOARD_SIZE = 4;

    /**
     * A Board constructor that creates a 4x4 int grid.
     */
    public Board() {
        grid = new int[BOARD_SIZE][BOARD_SIZE];
        this.clearBoard();
    }

    /**
     * A getter for a int in the Board.
     * @param row of the int in the Board. 0 is the first row.
     * @param col of the int in the Board. 0 is the first column.
     * @return a int with the given row and column.
     */
    protected int getint(int row, int col) {
        return grid[row][col];
    }

    /**
     * A setter for a int's number.
     * @param value of the number.
     * @param row of the int in the Board. 0 is the first row.
     * @param col of the int in the Board. 0 is the first column.
     */
    protected void setNum(int value, int row, int col) {
        grid[row][col].setNum(value);
    }

    /**
     * A method that initializes a game.
     * It picks two ints on the board randomly and changes their numbers to 1.
     */
    public void initGame() {
        Random random = new Random();

        int randomRowA = random.nextInt(BOARD_SIZE);
        int randomColA = random.nextInt(BOARD_SIZE);

        grid[randomRowA][randomColA].setNum(1);

        int randomRowB = random.nextInt(BOARD_SIZE);
        int randomColB = random.nextInt(BOARD_SIZE);

        while(randomRowA == randomRowB && randomColA == randomColB) {
            randomRowB = random.nextInt(BOARD_SIZE);
            randomColB = random.nextInt(BOARD_SIZE);
        }

        grid[randomRowB][randomColB].setNum(1);
    }

    protected void clearBoard() {
        for(int row = 0; row < BOARD_SIZE; row++) {
            for(int col = 0; col < BOARD_SIZE; col++) {
                grid[row][col] = new int();
            }
        }
    }

    public void pushLeft() {
        for(int row = 0; row < BOARD_SIZE; row++) {
            if(!isRowAllZero(row)) {
                moveLeft(row);
            }
        }
    }

    public void moveLeft(int row) {
        for(int i = 0; i < BOARD_SIZE - 1; i++) {
            for(int col = i; col < BOARD_SIZE - 1; col++) {
                int curr = grid[row][col];
                if(curr.getNum() == 0) {
                    swap(row, col, row, col + 1);
                }
            }
        }
    }

    private void swap(int rowA, int colA, int rowB, int colB) {
        int temp = grid[rowA][colA];
        grid[rowA][colA] = grid[rowB][colB];
        grid[rowB][colB] = temp;
    }

    /**
     * Checks whether all the ints in a row  zero.
     * @param row to be checked.
     * @return true if all the ints are zero, false if not.
     */
    private boolean isRowAllZero(int row) {
        boolean result = true;
        for(int col = 0; col < BOARD_SIZE && result; col++) {
            int curr = grid[row][col];
            if(curr.getNum() != 0) {
                result = false;
            }
        }
        return result;
    }

    private void merge(int intA, int intB) {

    }

    protected int[][] getGrid() {
        return grid;
    }

    /**
     * Converts a Board grid into String.
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(int row = 0; row < BOARD_SIZE; row++) {
            for(int col = 0; col < BOARD_SIZE; col++) {
                result.append(grid[row][col].getNum()).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }
}
