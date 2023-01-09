package com.grapfx.guisup;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class AboutScene extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("About.fxml"));
        Image icon = new Image("Files-Png-icon.png");
        stage.getIcons().add(icon);
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Java");
        stage.setScene(scene);
        stage.show();
    }

    public void Start(){
        launch();
    }}
