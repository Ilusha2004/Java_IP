package com.grapfx.guisup;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class StageController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private static Scenes scenes = new Scenes();


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
        System.out.println(scenes.getClass().getAnnotations());
        try {
            scenes.Increase();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

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

    //------------------------------------------------------------------------------------------------------------------
    @FXML
    CheckBox boxFir;
    @FXML
    CheckBox boxSec;
    @FXML
    Label label_1;

    public void change(ActionEvent event) {
        if(boxFir.isSelected() && boxSec.isSelected()) {
            label_1.setText("encrypt and compress");
            System.out.println("encrypt and compress");
        }
        else if(boxFir.isSelected()){
            label_1.setText("encrypt");
            System.out.println("encrypt");
        }
        else if(boxSec.isSelected()) {
            label_1.setText("compress");
            System.out.println("compress");
        }
    }

}
