package com.example.demo.model;

import java.util.Random;

/**
 * This class represents the main board of the 1024 Game.
 *
 */
public class Board {
    Tile[][] grid;
    int SIZE = 4;

    /**
     * A Board constructor that creates a 4x4 Tile grid.
     */
    public Board() {
        grid = new Tile[SIZE][SIZE];
        this.clearBoard();
    }

    /**
     * A getter for a Tile in the Board.
     * @param row of the tile in the Board. 0 is the first row.
     * @param col of the tile in the Board. 0 is the first column.
     * @return a Tile with the given row and column.
     */
    protected Tile getTile(int row, int col) {
        return grid[row][col];
    }

    /**
     * A setter for a Tile's number.
     * @param value of the number.
     * @param row of the tile in the Board. 0 is the first row.
     * @param col of the tile in the Board. 0 is the first column.
     */
    protected void setNum(int value, int row, int col) {
        grid[row][col].setNum(value);
    }

    /**
     * A method that initializes a game.
     * It picks two Tiles on the board randomly and changes their numbers to 1.
     */
    public void initGame() {
        Random random = new Random();

        int randomRowA = random.nextInt(SIZE);
        int randomColA = random.nextInt(SIZE);

        grid[randomRowA][randomColA].setNum(1);

        int randomRowB = random.nextInt(SIZE);
        int randomColB = random.nextInt(SIZE);

        while(randomRowA == randomRowB && randomColA == randomColB) {
            randomRowB = random.nextInt(SIZE);
            randomColB = random.nextInt(SIZE);
        }

        grid[randomRowB][randomColB].setNum(1);
    }

    protected void clearBoard() {
        for(int row = 0; row < SIZE; row++) {
            for(int col = 0; col < SIZE; col++) {
                grid[row][col] = new Tile();
            }
        }
    }

    public void pushLeft() {
        for(int row = 0; row < SIZE; row++) {
            if(!isRowAllZero(row)) {
                moveLeft(row);
            }
        }
    }

    public void moveLeft(int row) {
        for(int i = 0; i < SIZE - 1; i++) {
            for(int col = i; col < SIZE - 1; col++) {
                Tile curr = grid[row][col];
                if(curr.getNum() == 0) {
                    swap(row, col, row, col + 1);
                }
            }
        }
    }

    // 1 0 0 2
    // 1 0 0 2
    // 1 0 2 0

    private void swap(int rowA, int colA, int rowB, int colB) {
        Tile temp = grid[rowA][colA];
        grid[rowA][colA] = grid[rowB][colB];
        grid[rowB][colB] = temp;
    }

    /**
     * Checks whether all the Tiles in a row  zero.
     * @param row to be checked.
     * @return true if all the Tiles are zero, false if not.
     */
    private boolean isRowAllZero(int row) {
        boolean result = true;
        for(int col = 0; col < SIZE && result; col++) {
            Tile curr = grid[row][col];
            if(curr.getNum() != 0) {
                result = false;
            }
        }
        return result;
    }

    private void merge(Tile tileA, Tile tileB) {

    }

    protected Tile[][] getGrid() {
        return grid;
    }

    /**
     * Converts a Board grid into String.
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(int row = 0; row < SIZE; row++) {
            for(int col = 0; col < SIZE; col++) {
                result.append(grid[row][col].getNum()).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }
}
