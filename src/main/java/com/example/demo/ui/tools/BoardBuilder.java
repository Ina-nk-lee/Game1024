package com.example.demo.ui.tools;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * This class builds a 4x4 game board for the 1024 game application.
 * Since it is a utility class, it doesn't include a constructor.
 */

public class BoardBuilder {
    private static Stage primaryStage;
    private static GridPane grid;
    private static Scene scene;

    /**
     * This method build a stage where the 1024 game to be played.
     *
     * @param stage is a stage to display.
     */
    public static void buildStage(Stage stage) {
        primaryStage = stage;

        buildPane();
        scene = new Scene(grid, 300, 300);

        primaryStage.setTitle("1024 Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void buildPane() {
        grid = new GridPane();
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                Label label = new Label("Row " + row + ", Col " + col);
                grid.add(label, col, row); // Add the label at (row, col)
            }
        }
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));
        grid.setGridLinesVisible(true);
    }
}
