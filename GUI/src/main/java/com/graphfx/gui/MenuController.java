package com.graphfx.gui;

import cross_cutting.HelpfulThings.FilePath;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.util.List;
import java.util.ResourceBundle;

import static com.graphfx.gui.StageController.getObservableList;


public class MenuController implements Initializable {

    private static String path;

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

        if(tempFile == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Choose file for saving");
            alert.showAndWait();
        }


        if (tempFile != null) {
            FilePath path = new FilePath(tempFile);
            System.out.println(path.getExtension());
            System.out.println(path.getPath());
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(path.getExtension().toUpperCase() +
                    " files (*." + path.getExtension() + ")", "*." + path.getExtension());

            fileChooser.getExtensionFilters().add(extFilter);

            saveAsItem.setOnAction(event1 -> {

                tempFile = null;

                File file = fileChooser.showSaveDialog(primaryStage);
                File tempFile = new File(path.getPath());

                System.out.println(file.getPath());

                try {
                    Files.copy(tempFile.toPath(), file.toPath());
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }

            });
        }
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

    @FXML
    private ListView<String> ListOfFiles;
    @FXML
    private TextArea textField;
    private static String tempFile;

    ObservableList<String> temp = getObservableList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ListOfFiles.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                tempFile = ListOfFiles.getSelectionModel().getSelectedItem();

                System.out.println(tempFile);

                StringBuffer buffer = new StringBuffer();

                try(FileInputStream fin = new FileInputStream(tempFile)) {
                    int i=-1;

                    while((i = fin.read()) != -1){
                        buffer.append((char)i);
                    }

                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                textField.setText(buffer.toString());

            }

        });
    }

    public void Refresh(ActionEvent event) {
        ListOfFiles.getItems().clear();
        for(var files : getObservableList()) {
            ListOfFiles.getItems().add(files);
        }
    }


}
