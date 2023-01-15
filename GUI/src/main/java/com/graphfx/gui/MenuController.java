package com.graphfx.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.List;


public class MenuController {

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

    private FileChannel desktop;
    @FXML
    MenuItem saveAsItem;
    public void SaveAS(ActionEvent event) {

        Stage primaryStage = new Stage();
        final FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("./src/res"));

        saveAsItem.setOnAction(event1 -> {
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(StageController.getExtension().toUpperCase() +
                    " files (*." + StageController.getExtension() + ")", "*." + StageController.getExtension());

            fileChooser.getExtensionFilters().add(extFilter);
            File file = fileChooser.showSaveDialog(primaryStage);
            if (file != null) {
                openFile(file);
                List<File> files = Arrays.asList(file);
                String temp = new String();

                for(var id : files) {
                    System.out.println(id);
                }

                File newFile = new File(files.get(0).getName());

                try {
                    newFile.createNewFile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        });

    }

    private void printLog(TextField textArea, List<File> files) {
        if (files == null || files.isEmpty()) {
            return;
        }
        for (File file : files) {
            textArea.appendText(file.getAbsolutePath() + "\n");
        }
    }

    private void openFile(File file) {
        try {
            this.desktop.open(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
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
