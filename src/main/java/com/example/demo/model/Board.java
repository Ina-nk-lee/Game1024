package com.example.demo.model;

import java.util.Random;
import java.util.Scanner;

/**
 * This class represents the main board of a 1024 Game.
 * A user should merge same numbers to get to the 1024 tile.
 * The Board can be pushed into four directions, left, right, up and down,
 * by entering A (left), D (right), W (Up), and D (Down).
 * A 1 tile or a 2 tile is automatically added with every move.
 * The game is over when there is no space to add a tile and there is no available tile to be merged.
 */
public class Board {
    private int[][] grid;
    private static final int BOARD_SIZE = 4;

    /**
     * A Board constructor that creates a 4x4 int grid with two tiles with one.
     */
    public Board() {
        grid = new int[BOARD_SIZE][BOARD_SIZE];
    }

    /**
     * Starts a 1024 Game.
     * It adds two tiles to the Board in the beginning and keep receiving user input to push the Board
     * in four directions until the game is over or the user quits the game by entering 'Q'.
     */
    public void startGame() {
        Scanner scan = new Scanner(System.in);
        char command;

        addTile();
        addTile();

        while(!isGameOver()) {
            System.out.println(this);
            try {
                command = scan.nextLine().toUpperCase().charAt(0);
                if(command == 'Q') {
                    break;
                } else {
                    push(command);
                }
            } catch(StringIndexOutOfBoundsException e) {
                System.out.println("Enter: A (Left) / W (Up) / S(Down) / D(Right).");
            }
        }
    }

    /**
     * Clears the Board with a zero in all tiles.
     */
    protected void clearBoard() {
        for(int row = 0; row < BOARD_SIZE; row++) {
            for(int col = 0; col < BOARD_SIZE; col++) {
                grid[row][col] = 0;
            }
        }
    }

    /**
     * A method that inserts a tile.
     * It picks an empty tile on the board randomly and changes the tile's number to 1 or 2.
     * Does nothing if the board is full.
     */
    public void addTile() {
        if(hasSpaceInBoard()) {
            Random random = new Random();

            int randomRowA = random.nextInt(BOARD_SIZE);
            int randomColA = random.nextInt(BOARD_SIZE);

            while(grid[randomRowA][randomColA] != 0) {
                randomRowA = random.nextInt(BOARD_SIZE);
                randomColA = random.nextInt(BOARD_SIZE);
            }

            int variant = random.nextInt(100);
            if(variant < 5) {
                grid[randomRowA][randomColA] = 2;
            } else {
                grid[randomRowA][randomColA] = 1;
            }
        }
    }

    /**
     * Pushes the board to the given direction (Left, Right, Up, Down).
     * @param dir is the direction to push (Left - A, Right - S, Up - W, Down - D)
     */
    public void push(char dir) {
        switch(dir) {
            case 'A':
                for(int row = 0; row < BOARD_SIZE; row++) {
                    pushLeft(row);
                }
                addTile();
                break;
            case 'D':
                for(int row = 0; row < BOARD_SIZE; row++) {
                    pushRight(row);
                }
                addTile();
                break;
            case 'W':
                for(int col = 0; col < BOARD_SIZE; col++) {
                    pushUp(col);
                }
                addTile();
                break;
            case 'S':
                for(int col = 0; col < BOARD_SIZE; col++) {
                    pushDown(col);
                }
                addTile();
                break;
            default:
                System.out.println("Enter: A (Left) / W (Up) / S(Down) / D(Right).");
        }
    }

    /**
     * Moves all non-zero numbers in a given row to the left.
     * Does nothing if there is no space to go.
     * @param row to be rearranged
     */
    public void moveLeft(int row) {
        if(hasSpaceInRow(row)) {
            //  Creates a new int[] row to replace the existing row in the grid.
            int[] newRow = new int[BOARD_SIZE];
            int index = 0;

            for(int col = 0; col < BOARD_SIZE; col++) {
                if(grid[row][col] != 0) {
                    newRow[index] = grid[row][col];
                    index++;
                }
            }

            grid[row] = newRow;
        }
    }

    /**
     * Moves all non-zero numbers in a given row to the right.
     * Does nothing if there is no space to go.
     * @param row to be rearranged
     */
    public void moveRight(int row) {
        if(hasSpaceInRow(row)) {
            //  Creates a new int[] row to replace the existing row in the grid.
            int[] newRow = new int[BOARD_SIZE];
            int index = BOARD_SIZE - 1;

            for(int col = BOARD_SIZE - 1; col >= 0; col--) {
                if(grid[row][col] != 0) {
                    newRow[index] = grid[row][col];
                    index--;
                }
            }

            grid[row] = newRow;
        }
    }

    /**
     * Moves up all non-zero numbers in a given column.
     * Does nothing if there is no space to go.
     * @param col to be rearranged
     */
    public void moveUp(int col) {
        if(hasSpaceInCol(col)) {
            //  Creates a new int[] to replace numbers in the given column to move them up.
            int[] newCol = new int[BOARD_SIZE];
            int index = 0;

            for(int row = 0; row < BOARD_SIZE; row++) {
                if(grid[row][col] != 0) {
                    newCol[index] = grid[row][col];
                    index++;
                }
            }

            for(int row = 0; row < BOARD_SIZE; row++) {
                grid[row][col] = newCol[row];
            }
        }
    }

    /**
     * Moves down all non-zero numbers in a given column.
     * Does nothing if there is no space to go.
     * @param col to be rearranged
     */
    public void moveDown(int col) {
        if(hasSpaceInCol(col)) {
            //  Creates a new int[] to replace numbers in the given column to move them up.
            int[] newCol = new int[BOARD_SIZE];
            int index = BOARD_SIZE - 1;

            for(int row = BOARD_SIZE - 1; row >= 0; row--) {
                if(grid[row][col] != 0) {
                    newCol[index] = grid[row][col];
                    index--;
                }
            }

            for(int row = BOARD_SIZE - 1; row >= 0; row--) {
                grid[row][col] = newCol[row];
            }
        }
    }

    /**
     * Fills gaps and merges two same adjacent numbers in the given row to the left.
     * @param row where numbers to be merged
     */
    private void pushLeft(int row) {
        moveLeft(row);
        if(hasDupInRow(row)) {
            for(int col = 0; col < BOARD_SIZE - 1; col++) {
                if(grid[row][col] == grid[row][col + 1]) {
                    grid[row][col] *= 2;
                    grid[row][col + 1] = 0;
                }
            }
            moveLeft(row);
        }
    }

    /**
     * Fills gaps and merges two same adjacent numbers in the given row to the right.
     * @param row where numbers to be merged
     */
    private void pushRight(int row) {
        moveRight(row);
        if(hasDupInRow(row)) {
            for(int col = BOARD_SIZE - 1; col > 0; col--) {
                if(grid[row][col] == grid[row][col - 1]) {
                    grid[row][col] *= 2;
                    grid[row][col - 1] = 0;
                }
            }
            moveRight(row);
        }
    }

    /**
     * Fills gaps and merges two same adjacent numbers in the given column upwards.
     * @param col where numbers to be merged
     */
    private void pushUp(int col) {
        moveUp(col);
        if(hasDupInCol(col)) {
            for(int row = 0; row < BOARD_SIZE - 1; row++) {
                if(grid[row][col] == grid[row + 1][col]) {
                    grid[row][col] *= 2;
                    grid[row + 1][col] = 0;
                }
            }
            moveUp(col);
        }
    }

    /**
     * Fills gaps and merges two same adjacent numbers in the given column downwards.
     * @param col where numbers to be merged
     */
    private void pushDown(int col) {
        moveDown(col);
        if(hasDupInCol(col)) {
            for(int row = BOARD_SIZE - 1; row > 0; row--) {
                if(grid[row][col] == grid[row - 1][col]) {
                    grid[row][col] *= 2;
                    grid[row - 1][col] = 0;
                }
            }
            moveDown(col);
        }
    }

    /**
     * Checks if the game is over.
     * Game over if there is no number to merge and there is no space to add a tile.
     * @return true if the game is over, false if not.
     */
    public boolean isGameOver() {
        for(int i = 0; i < BOARD_SIZE; i++) {
            if(hasDupInRow(i) || hasSpaceInRow(i)|| hasDupInCol(i) || hasSpaceInCol(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if there is an empty tile on the Board.
     * @return true if there is an empty tile, false if not
     */
    private boolean hasSpaceInBoard() {
        for(int i = 0; i < BOARD_SIZE; i++) {
            if(hasSpaceInRow(i)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if there is an empty tile on the row.
     * @param row to be checked
     * @return true if there is an empty tile on the row, false if not
     */
    private boolean hasSpaceInRow(int row) {
        for(int col = 0; col < BOARD_SIZE; col++) {
            if(grid[row][col] == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if there is an empty tile on the column.
     * @param col to be checked
     * @return true if there is an empty tile on the column, false if not
     */
    private boolean hasSpaceInCol(int col) {
        for(int row = 0; row < BOARD_SIZE; row++) {
            if(grid[row][col] == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if there are adjacent duplicate numbers in the given row.
     * @param row to be checked
     * @return true if there are duplicates, false if not.
     */
    private boolean hasDupInRow(int row) {
        for(int col = 0; col < BOARD_SIZE - 1; col++) {
            if(grid[row][col] != 0 && grid[row][col] == grid[row][col + 1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if there are same adjacent duplicate numbers in the given column.
     * @param col to be checked
     * @return true if there are duplicates, false if not.
     */
    private boolean hasDupInCol(int col) {
        for(int row = 0; row < BOARD_SIZE - 1; row++) {
            if(grid[row][col] != 0 && grid[row][col] == grid[row + 1][col]) {
                return true;
            }
        }
        return false;
    }

    /**
     * A getter for the grid of the board.
     * @return the grid
     */
    public int[][] getGrid() {
        return grid;
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
     * Converts a Board grid into String.
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(int row = 0; row < BOARD_SIZE; row++) {
            for(int col = 0; col < BOARD_SIZE; col++) {
                result.append(grid[row][col]).append("\t");
            }
            result.append("\n");
        }
        result.setLength(result.length() - 1);
        return result.toString();
    }
}
