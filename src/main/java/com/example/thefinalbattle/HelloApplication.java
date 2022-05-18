package com.example.thefinalbattle;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //making a vbox that contains the entire menu
        VBox menu = new VBox();
        //making a scene for the main menu
        Scene mainmenu = new Scene(menu);
        final int MIN_WIDTH = 1080;
        stage.setMinWidth(MIN_WIDTH);
        stage.setMinHeight(720);

        String css = getClass().getResource("/style.css").toExternalForm();
        mainmenu.getStylesheets().add(css);
        menu.getStyleClass().add("menu");
        stage.setTitle("Test");
        Label title = new Label("The Final Battle");
        title.setMinWidth(MIN_WIDTH);

        title.setAlignment(Pos.BASELINE_CENTER);
        title.setTextFill(Color.RED);
        title.getStyleClass().add("title");
        menu.getChildren().add(title);





       //making Gameplay scene
        Scene Gameplay = new Scene(fxmlLoader.load());
        // end
        //Settings scene
        VBox settings = new VBox();

        Scene Settings = new Scene(settings);
        Settings.getStylesheets().add(css);
        Label title2 = new Label("The Final Battle");
        title2.setMinWidth(MIN_WIDTH);
        title2.setAlignment(Pos.BASELINE_CENTER);
        title2.setTextFill(Color.RED);
        title2.getStyleClass().add("title");
        settings.getChildren().add(title2);
        settings.getStyleClass().add("menu");
        Label subtitle = new Label("Settings");
        subtitle.setId("settings");
        subtitle.setMinWidth(MIN_WIDTH);
        subtitle.setAlignment(Pos.BASELINE_CENTER);
        subtitle.setTextFill(Color.RED);
        settings.getChildren().add(subtitle);
        settings.setMinWidth(MIN_WIDTH);
        settings.setMinHeight(720);
        HBox back = new HBox();
        back.setAlignment(Pos.BASELINE_CENTER);
        Button backButton = new Button("Back");
        backButton.getStyleClass().add("menuButtons");
        backButton.setTextFill(Color.RED);
        backButton.setOnAction(actionEvent -> {
            stage.setScene(mainmenu);
        });
        back.getChildren().add(backButton);
        settings.getChildren().add(back);
        // end of settings

        //making the hbox that contains the start button
        HBox start = new HBox();
        start.setAlignment(Pos.BASELINE_CENTER);
        //making the start button
        Button startButton = new Button("Start");
        startButton.getStyleClass().add("menuButtons");
        startButton.setTextFill(Color.RED);
        startButton.setOnAction(actionEvent -> {

            stage.setScene(Gameplay);
        });

        HBox setting = new HBox();
        setting.setAlignment(Pos.BASELINE_CENTER);
        Button settingButton = new Button("Settings");
        settingButton.getStyleClass().add("menuButtons");
        settingButton.setTextFill(Color.RED);
        settingButton.setOnAction(actionEvent -> {
            stage.setScene(Settings);
        });

        HBox quit = new HBox();
        quit.setAlignment(Pos.BASELINE_CENTER);
        Button quitButton = new Button("Quit");
        quitButton.getStyleClass().add("menuButtons");
        quitButton.setTextFill(Color.RED);
        quitButton.setOnAction(actionEvent -> {
            Platform.exit();
            System.exit(0);
        });
        start.getChildren().add(startButton);
        setting.getChildren().add(settingButton);
        quit.getChildren().add(quitButton);
        menu.getChildren().add(start);
        menu.getChildren().add(setting);
        menu.getChildren().add(quit);
        stage.setScene(mainmenu);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }


}