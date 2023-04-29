package com.aab.arkansasassetbuilders;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloScreenLauncher extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloScreenLauncher.class.getResource("HelloScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Screen screen = Screen.getPrimary();
//        Rectangle2D bounds = screen.getVisualBounds();
//
//        stage.setX(bounds.getMinX());
//        stage.setY(bounds.getMinY());
//        stage.setWidth(bounds.getWidth());
//        stage.setHeight(bounds.getHeight());
        stage.setTitle("VITAmin");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.setFullScreen(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}