package com.example.demo.ui.tools;

import com.example.demo.model.Board;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

/**
 * This class builds a 4x4 game board for the 1024 game application.
 * Since it is a utility class, it doesn't include a constructor.
 */

public class BoardBuilder {
    private static GridPane root;
    private static Board board;
    private static int BOARD_SIZE;
    private static int NUM_TILE;
    private static ArrayList<Tile> tiles;

    /**
     * This method build a stage where the 1024 game to be played.
     * @param stage is a stage to display.
     */
    public static void buildStage(Stage stage) {
        buildBoard();
        test();
//        startGame();

        Scene scene = new Scene(root, 235, 235);

        scene.setOnKeyPressed(Controller::onKeyPress);

        stage.setTitle("1024 Game");
        stage.setScene(scene);
        stage.show();
    }

    public static void test() {
        addTile();
        updateBoard();
        push('A');
        for(int row = 0; row < BOARD_SIZE; row++) {
            for(int col = 0; col < BOARD_SIZE; col++) {
                Tile tile = (Tile) getTile(row, col);
                tile.slideLeft();
            }
        }
    }

    /**
     * Builds a board consisted with a 4x4 tile grid.
     */
    private static void buildBoard() {
        root = new GridPane();
        root.setBackground(Background.fill(Color.rgb(40, 40, 40)));
        root.setPadding(new Insets(10));
        root.setHgap(5);
        root.setVgap(5);

        board = new Board();
        BOARD_SIZE = board.getBoardSize();
        NUM_TILE = BOARD_SIZE * BOARD_SIZE;
        tiles = new ArrayList<>(NUM_TILE);

        for(int row = 0; row < BOARD_SIZE; row++) {
            for(int col = 0; col < BOARD_SIZE; col++) {
                Tile tile = new Tile();
                root.add(tile, col, row);
                tiles.add(tile);
                tile.prefWidthProperty().bind(root.widthProperty().divide(BOARD_SIZE));
                tile.prefHeightProperty().bind(root.heightProperty().divide(BOARD_SIZE));
            }
        }
    }

    /**
     * Starts a game.
     */
    private static void startGame() {
        addTile();
        addTile();
        updateBoard();
    }

    /**
     * Updates a GUI-based board based on a CUI-based board.
     * Terminates a game if the game is over.
     */
    protected static void updateBoard() {
        int[][] grid = board.getGrid();
        for(int row = 0; row < BOARD_SIZE; row++) {
            for(int col = 0; col < BOARD_SIZE; col++) {
                Tile tile = (Tile) getTile(row, col);
                tile.updateTile(grid[row][col]);
            }
        }
        if(BoardBuilder.isGameOver()) {
            BoardBuilder.processGameOver();
        }
    }

    protected static void moveTiles(char dir) {
        switch(dir) {
            case 'A':

        }
    }

    protected static void pushLeft() {
        for(Tile i : tiles) {
            i.slideLeft();
        }
    }

    protected static void addTile() {
        if(board.hasSpaceInBoard()) {
            Random random = new Random();
            int randomNum = 0;

            while(tiles.get(randomNum).getNumber() != 0) {
                randomNum = random.nextInt(NUM_TILE);
            }

            int variant = random.nextInt(100);
            if(variant < 3) {
                tiles.get(randomNum).updateTile(2);
            } else {
                tiles.get(randomNum).updateTile(1);
            }
        }
    }

    /**
     * Processes the user input pushing the board into four directions.
     * @param dir is a direction where the board is pushed to (Left - A, Right - S, Up - W, Down - S).
     */
    protected static void push(char dir) {
        board.push(dir);
    }

    /**
     * Checks if a game is over.
     * @return true if the game is over, false if not.
     */
    protected static boolean isGameOver() {
        return board.isGameOver();
    }

    /**
     * Processes a game over.
     * Stops the current game and asks the user for another game.
     * Terminates the application if the user chooses to cancel.
     */
    protected static void processGameOver() {
        Alert restartDialog = new Alert(Alert.AlertType.CONFIRMATION);
        restartDialog.setHeaderText("Game Over");
        restartDialog.setContentText("Retry?");
        Optional<ButtonType> newGame = restartDialog.showAndWait();
        if(newGame.isPresent() && newGame.get() == ButtonType.OK) {
            board.clearBoard();
            updateBoard();
            startGame();
        } else {
            Platform.exit();
        }
    }


    /**
     * A getter for a tile on the board.
     * @param row the row where the tile is placed
     * @param col the column where the tile is placed
     * @return the tile at the given row and column.
     */
    private static Node getTile(int row, int col) {
        Node result = null;
        ObservableList<Node> tiles = root.getChildren();

        for(Node tile : tiles) {
            if(GridPane.getRowIndex(tile) == row && GridPane.getColumnIndex(tile) == col) {
                result = tile;
            }
        }

        return result;
    }
}
