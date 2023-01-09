package com.grapfx.guisup;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class StageController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private final Scenes scenes = new Scenes();

    @FXML
    Button closeButton;
    @FXML
    TextField textField;
    @FXML
    Label label;

    public void Switch(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(scenes.getAllPath().get(scenes.getCounter())));
        root = loader.load(getClass().getResource(scenes.getAllPath().get(scenes.getCounter())));
        this.stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        System.out.println(scenes.getCounter());
        this.stage.setScene(scene);
        this.stage.show();

    }

    public void MainThemeController(ActionEvent event) throws IOException {
        scenes.Increase();
        Switch(event);
    }

    public void PrevScene(ActionEvent event) throws IOException {
        scenes.Decrease();
        Switch(event);
    }

    public void Close() {
        System.out.println("closing");
        stage = (Stage) closeButton.getScene().getWindow();
        this.stage.close();
    }

    public void NewPath(ActionEvent event) throws IOException {
        String path = textField.getText();
        label.setText("Path : " + path);
    }

}
