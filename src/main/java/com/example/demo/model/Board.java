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
        for(int row = 0; row < SIZE; row++) {
            for(int col = 0; col < SIZE; col++) {
                grid[row][col] = new Tile();
            }
        }
    }

    /**
     * A getter for a Tile in the Board.
     * @param row of the tile in the Board.
     * @param col of the tile in the Board.
     * @return a Tile with the given row and column.
     */
    public Tile getTile(int row, int col) {
        return grid[row][col];
    }

    /**
     * A method that initializes a game.
     * It picks two Tiles on the board randomly and changes their numbers to 1.
     */
    public void initGame() {
        Random random = new Random();

        int randomRow = random.nextInt(SIZE);
        int randomCol = random.nextInt(SIZE);

        grid[randomRow][randomCol].setNum(1);

        randomRow = random.nextInt(SIZE);
        randomCol = random.nextInt(SIZE);

        grid[randomRow][randomCol].setNum(1);
    }

    public void pushLeft() {
        for(int row = 0; row < SIZE; row++) {
            if(!isRowAllZero(row)) {
                moveLeft(row);
            }
        }
    }

    public void moveLeft(int row) {
        for(int col = 0; col < SIZE; col++) {
            Tile curr = grid[row][col];
            if(curr.getNum() == 0) {
                for(int next = col; next < SIZE; next++) {
                    swap(row, next, row, next + 1);
                }
            }
        }
    }

    public void swap(int rowA, int colA, int rowB, int colB) {
        Tile temp = grid[rowA][colA];
        grid[rowA][colA] = grid[rowB][colB];
        grid[rowB][colB] = temp;
    }

    public boolean isRowAllZero(int row) {
        boolean result = true;
        for(int col = 0; col < SIZE && result; col++) {
            Tile curr = grid[row][col];
            if(curr.getNum() != 0) {
                result = false;
            }
        }
        return result;
    }

    public void merge(Tile tileA, Tile tileB) {

    }
}
