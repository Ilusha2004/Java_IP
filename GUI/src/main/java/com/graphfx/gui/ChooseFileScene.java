package com.graphfx.gui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class ChooseFileScene extends Application {

    private ObservableList<String> langs = FXCollections.observableArrayList("Java", "JavaScript", "C#", "Python");
    @FXML
    private ListView<String> ListOfFiles = new ListView<>(langs);

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("File.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Java");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(ChooseFileScene.class);
    }

}
