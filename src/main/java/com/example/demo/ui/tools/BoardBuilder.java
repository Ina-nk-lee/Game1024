package com.example.demo.ui.tools;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * This class builds a 4x4 game board for the 1024 game application.
 * Since it is a utility class, it doesn't include a constructor.
 */

public class BoardBuilder {
    private static Stage primaryStage;
    private static Pane root;
    private static Scene scene;

    /**
     * This method build a stage where the 1024 game to be played.
     *
     * @param stage is a stage to display.
     */
    public static void buildStage(Stage stage) {
        primaryStage = stage;

        buildPane();
        scene = new Scene(root, 300, 300);

        primaryStage.setTitle("1024 Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void buildPane() {
        root = new Pane();
        root.setPadding(new Insets(10));
    }
}
