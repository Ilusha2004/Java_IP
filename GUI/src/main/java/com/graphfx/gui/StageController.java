package com.graphfx.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class StageController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private static Scenes scenes = new Scenes();

    //------------------------------------------------------------------------------------------------------------------
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

    //------------------------------------------------------------------------------------------------------------------

    @FXML
    private RadioButton button_0, button_1, button_2, button_3, button_4, button_5;

    public void ChangeExtensions(ActionEvent event) {
        if(button_0.isSelected()) {
            System.out.println("zip");
        }
        else if(button_1.isSelected()) {
            System.out.println("rar");
        }
        else if(button_2.isSelected()) {
            System.out.println("jar");
        }
        else if(button_3.isSelected()) {
            System.out.println("json");
        }
        else if(button_4.isSelected()) {
            System.out.println("xml");
        }
        else if(button_5.isSelected()) {
            System.out.println("txt");
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    //WTF Section

    @FXML
    Label label_2;

    String extensions[] = { "zip", "rar", "jar", "json", "xml", "txt" };


    public void FTW(ActionEvent event) {
        Random random = new Random();
        int pos = random.nextInt(extensions.length);
        label_2.setText(extensions[pos]);
    }

    //------------------------------------------------------------------------------------------------------------------



}
