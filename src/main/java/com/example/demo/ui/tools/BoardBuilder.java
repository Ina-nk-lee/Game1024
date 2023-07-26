package com.example.demo.ui.tools;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * This class builds a 4x4 game board for the 1024 game application.
 * Since it is a utility class, it doesn't include a constructor.
 */

public class BoardBuilder {
    private static Stage primaryStage;
    private static GridPane board;
    private static Scene scene;
    private final static int BOARD_SIZE = 4;

    /**
     * This method build a stage where the 1024 game to be played.
     *
     * @param stage is a stage to display.
     */
    public static void buildStage(Stage stage) {
        primaryStage = stage;
        buildBoard();
        scene = new Scene(board, 235, 235);

        primaryStage.setTitle("1024 Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Builds a board consisted with 4x4 grid.
     */
    public static void buildBoard() {
        board = new GridPane();
        board.setBackground(Background.fill(Color.rgb(40, 40, 40)));
        board.setPadding(new Insets(10));
        board.setHgap(5);
        board.setVgap(5);

        double tileSize = 50;
        for(int row = 0; row < BOARD_SIZE; row++) {
            for(int col = 0; col < BOARD_SIZE; col++) {
                Rectangle tile = new Rectangle(tileSize, tileSize, tileSize, tileSize);
                tile.setFill(Color.rgb(70, 70, 70));
                board.add(tile, row, col);
            }
        }
    }
}
