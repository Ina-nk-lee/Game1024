package com.example.demo.ui;

import com.example.demo.ui.tools.BoardBuilder;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * The driver of the 1024 game application
 *
 * @author Ina Lee
 * @version 2023-07-22
 */

public class GUIDriver extends Application {

    /**
     * Main method that launches the game application.
     *
     * @param args isn't used.
     */
    public static void main(String[] args) {
        launch();
    }

    /**
     * JavaFX start method.
     *
     * @param stage is a stage to display.
     */
    @Override
    public void start(Stage stage) {
        BoardBuilder.buildStage(stage);
    }
}