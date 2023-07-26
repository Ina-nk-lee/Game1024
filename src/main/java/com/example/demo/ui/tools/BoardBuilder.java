package com.example.demo.ui.tools;

import com.example.demo.model.Board;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Scanner;

/**
 * This class builds a 4x4 game board for the 1024 game application.
 * Since it is a utility class, it doesn't include a constructor.
 */

public class BoardBuilder {
    private static Stage primaryStage;
    private static GridPane root;
    private static Scene scene;
    private static Board board;
    private final static int BOARD_SIZE = 4;

    /**
     * This method build a stage where the 1024 game to be played.
     *
     * @param stage is a stage to display.
     */
    public static void buildStage(Stage stage) {
        primaryStage = stage;
        buildBoard();
        scene = new Scene(root, 235, 235);

        primaryStage.setTitle("1024 Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Builds a board consisted with 4x4 grid.
     */
    private static void buildBoard() {
        root = new GridPane();
        root.setBackground(Background.fill(Color.rgb(40, 40, 40)));
        root.setPadding(new Insets(10));
        root.setHgap(5);
        root.setVgap(5);

        for(int row = 0; row < BOARD_SIZE; row++) {
            for(int col = 0; col < BOARD_SIZE; col++) {
                StackPane tile = new StackPane();
                tile.setBackground(Background.fill(Color.rgb(70, 70, 70)));
                root.add(tile, col, row);
                tile.prefWidthProperty().bind(root.widthProperty().divide(BOARD_SIZE));
                tile.prefHeightProperty().bind(root.heightProperty().divide(BOARD_SIZE));
            }
        }

        board = new Board();
        addTile();
        addTile();
    }

    private static void startGame() {
        Scanner scan = new Scanner(System.in);
        char command;

        addTile();
        addTile();

        while(!board.isGameOver()) {
            // System.out.println(board);
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

    private static void addTile() {
        board.addTile();
        int[][] grid = board.getGrid();
        for(int row = 0; row < BOARD_SIZE; row++) {
            for(int col = 0; col < BOARD_SIZE; col++) {
                if(grid[row][col] != 0) {
                    StackPane newTile = (StackPane) getTile(row, col);
                    String numString = Integer.toString(grid[row][col]);
                    Text num = new Text(numString);
                    num.setFont(Font.font(20));
                    newTile.getChildren().addAll(num);
                    newTile.setBackground(Background.fill(Color.OLDLACE));
                }
            }
        }
    }

    private static void push(char dir) {
        board.push(dir);
    }

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
