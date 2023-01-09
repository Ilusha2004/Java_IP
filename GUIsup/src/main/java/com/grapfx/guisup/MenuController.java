package com.grapfx.guisup;

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

    public void About(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "This is application was made by KoVLya");
        alert.showAndWait();

        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("About.fxml"));
            stage.setTitle("Java");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        AboutScene scene = new AboutScene();
        scene.Start();
    }

    public void NewFile(ActionEvent event) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("MainTitle.fxml"));
            stage.setTitle("Java_IP");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void SaveAs(ActionEvent event) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("SaveAs.fxml"));
            stage.setTitle("Java_IP");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void Delete(ActionEvent event) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("FTWExtension.fxml"));
            stage.setTitle("Java_IP");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void Web(ActionEvent event) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("WebSup.fxml"));
            stage.setTitle("Java_IP");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
