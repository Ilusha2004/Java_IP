package com.graphfx.gui;


import cross_cutting.EnumTypes.Extensions;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChooseFileScene extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println(Extensions.TXT);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("File.fxml"));
//        Image icon = new Image("Files-Png-icon.png");
//        stage.getIcons().add(icon);
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Java");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(ChooseFileScene.class);
    }
}
