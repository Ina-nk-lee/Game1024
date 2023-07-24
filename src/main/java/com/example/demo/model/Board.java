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
    }

    /**
     * A getter for number on the Board.
     * @param row of the int in the Board. 0 is the first row.
     * @param col of the int in the Board. 0 is the first column.
     * @return a int with the given row and column.
     */
    protected int getNum(int row, int col) {
        return grid[row][col];
    }

    /**
     * A setter for a number on the Board.
     * @param value of the number.
     * @param row of the int in the Board. 0 is the first row.
     * @param col of the int in the Board. 0 is the first column.
     */
    protected void setNum(int value, int row, int col) {
        grid[row][col] = value;
    }

    /**
     * A method that initializes a game.
     * It picks two ints on the board randomly and changes their numbers to 1.
     */
    public void initGame() {
        Random random = new Random();

        int randomRowA = random.nextInt(BOARD_SIZE);
        int randomColA = random.nextInt(BOARD_SIZE);

        grid[randomRowA][randomColA] = 1;

        int randomRowB = random.nextInt(BOARD_SIZE);
        int randomColB = random.nextInt(BOARD_SIZE);

        while(randomRowA == randomRowB && randomColA == randomColB) {
            randomRowB = random.nextInt(BOARD_SIZE);
            randomColB = random.nextInt(BOARD_SIZE);
        }

        grid[randomRowB][randomColB] = 1;
    }

    /**
     * Initializes the Board with a zero in all tiles.
     */
    protected void initBoard() {
        for(int row = 0; row < BOARD_SIZE; row++) {
            for(int col = 0; col < BOARD_SIZE; col++) {
                grid[row][col] = 0;
            }
        }
    }

    /**
     * Pushes the Board to left.
     */
    public void pushLeft() {
        for(int row = 0; row < BOARD_SIZE; row++) {
            if(!isRowAllZero(row)) {
                moveLeft(row);
            }
        }
    }

    /**
     * Moves all non-zero numbers in a given row to the left.
     * @param row to move numbers
     */
    public void moveLeft(int row) {
        int[] newRow = new int[BOARD_SIZE];
        int j = 0;

        for(int col = 0; col < BOARD_SIZE; col++) {
            if(grid[row][col] != 0) {
                newRow[j] = grid[row][col];
                j++;
            }
        }

        grid[row] = newRow;
    }

    /**
     * Checks whether how many numbers in a row are zero.
     * @param row to be checked.
     * @return the number of zeros in the row.
     */
    private boolean isRowAllZero(int row) {
        boolean result = true;
        for(int i = 0; i < BOARD_SIZE; i++) {
            if(grid[row][i] != 0) {
                result = false;
            }
        }
        return result;
    }

    private void swap(int rowA, int colA, int rowB, int colB) {
        int temp = grid[rowA][colA];
        grid[rowA][colA] = grid[rowB][colB];
        grid[rowB][colB] = temp;
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
                result.append(grid[row][col]).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }
}
