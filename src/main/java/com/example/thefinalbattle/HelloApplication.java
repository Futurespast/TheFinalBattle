package com.example.thefinalbattle;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import com.example.thefinalbattle.*;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Group temp = new Group();
        Scene scene = new Scene(temp);

        stage.setTitle("Test");
        stage.setMinHeight(500);
        stage.setMinWidth(1000);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}