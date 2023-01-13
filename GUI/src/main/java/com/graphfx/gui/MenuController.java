package com.graphfx.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    @FXML
    Button but;

    public void CreateScene(String FXMLPath) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource(FXMLPath));
            stage.setTitle("Java");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void About(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "This is application was made by KoVLya");
        alert.showAndWait();
        CreateScene("About.fxml");
    }

    public void NewFile(ActionEvent event) {
        CreateScene("MainTitle.fxml");
    }

    public void SaveAs(ActionEvent event) {
        CreateScene("SaveAs.fxml");
    }

    public void Delete(ActionEvent event) {
        CreateScene("FTWExtension.fxml");
    }

    public void Web(ActionEvent event) {
        CreateScene("WebSup.fxml");
    }

}
