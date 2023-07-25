package com.example.demo.model;

import java.util.Random;

/**
 * This class represents the main board of the 1024 Game.
 */
public class Board {
    int[][] grid;
    int BOARD_SIZE = 4;

    /**
     * A Board constructor that creates a 4x4 int grid with two tiles with one.
     */
    public Board() {
        grid = new int[BOARD_SIZE][BOARD_SIZE];
    }

    public void startGame() {
        addTile();
        addTile();
    }

    /**
     * Initializes the Board with a zero in all tiles.
     */
    protected void clearBoard() {
        for(int row = 0; row < BOARD_SIZE; row++) {
            for(int col = 0; col < BOARD_SIZE; col++) {
                grid[row][col] = 0;
            }
        }
    }

    /**
     * A getter for number on the Board.
     * @param row of the int in the Board. 0 is the first row.
     * @param col of the int in the Board. 0 is the first column.
     * @return a number in the given row and column.
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
     * A method that inserts two tiles.
     * It picks two empty tiles on the board randomly and changes their numbers to 1.
     */
    protected void addTile() {
        boolean isSpace = false;

        for(int row = 0; row < BOARD_SIZE; row++) {
            for(int col = 0; col < BOARD_SIZE; col++) {
                if(grid[row][col] == 0) {
                    isSpace = true;
                }
            }
        }

        if(isSpace) {
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
     * @param dir is the direction to push
     */
    public void push(char dir) {
        switch(dir) {
            case 'A':
                for(int row = 0; row < BOARD_SIZE; row++) {
                    if(isRowMovable(row)) {
                        moveLeft(row);
                        mergeLeft(row);
                    }
                }
                addTile();
                break;
            case 'D':
                for(int row = 0; row < BOARD_SIZE; row++) {
                    if(isRowMovable(row)) {
                        moveRight(row);
                        mergeRight(row);
                    }
                }
                addTile();
                break;
            case 'W':
                for(int col = 0; col < BOARD_SIZE; col++) {
                    if(isColMovable(col)) {
                        moveUp(col);
                        mergeUp(col);
                    }
                }
                addTile();
                break;
            case 'S':
                for(int col = 0; col < BOARD_SIZE; col++) {
                    if(isColMovable(col)) {
                        moveDown(col);
                        mergeDown(col);
                    }
                }
                addTile();
                break;
        }
    }

    /**
     * Moves all non-zero numbers in a given row to the left.
     * @param row to be rearranged
     */
    public void moveLeft(int row) {
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

    /**
     * Moves all non-zero numbers in a given row to the right.
     * @param row to be rearranged
     */
    public void moveRight(int row) {
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

    /**
     * Moves up all non-zero numbers in a given column.
     * @param col to be rearranged
     */
    public void moveUp(int col) {
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

    /**
     * Moves down all non-zero numbers in a given column.
     * @param col to be rearranged
     */
    public void moveDown(int col) {
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


    public boolean isGameOver() {
        for(int i = 0; i < BOARD_SIZE; i++) {
            if(isRowMovable(i) || isColMovable(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isRowMovable(int row) {
        if(hasDupInRow(row)) {
            return true;
        }

        for(int col = 0; col < BOARD_SIZE; col++) {
            if(grid[row][col] == 0) {
                return true;
            }
        }

        return false;
    }

    private boolean isColMovable(int col) {
        if(hasDupInCol(col)) {
            return true;
        }

        for(int row = 0; row < BOARD_SIZE; row++) {
            if(grid[row][col] == 0) {
                return true;
            }
        }

        return false;
    }

    /**
     * Checks whether there is a non-zero number in the row.
     * @param row to be checked.
     * @return true if there is a non-zero number, false if not.
     */
    private boolean isNumInRow(int row) {
        for(int i = 0; i < BOARD_SIZE; i++) {
            if(grid[row][i] != 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks whether there is a non-zero number in the column.
     * @param col to be checked
     * @return true if there is a non-zero number, false if not.
     */
    private boolean isNumInCol(int col) {
        for(int i = 0; i < BOARD_SIZE; i++) {
            if(grid[i][col] != 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Merges two same adjacent numbers in the given row to the left.
     * @param row where numbers to be merged
     */
    private void mergeLeft(int row) {
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
     * Merges two same adjacent numbers in the given row to the right.
     * @param row where numbers to be merged
     */
    private void mergeRight(int row) {
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
     * Merges two same adjacent numbers in the given column upwards.
     * @param col where numbers to be merged
     */
    private void mergeUp(int col) {
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
     * Merges two same adjacent numbers in the given column downwards.
     * @param col where numbers to be merged
     */
    private void mergeDown(int col) {
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
     * Checks if there are same adjacent numbers in the given row.
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
     * Checks if there are same adjacent numbers in the given column.
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
     * A getter for the grid on the board.
     * @return the grid
     */
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
                result.append(grid[row][col]).append("\t");
            }
            result.append("\n");
        }
        result.setLength(result.length() - 1);
        return result.toString();
    }
}
