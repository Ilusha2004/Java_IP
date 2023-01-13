package com.graphfx.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class SavaAsController implements Initializable {

    @FXML
    ChoiceBox<String> box;
    @FXML
    Button ok;

    List<String> extensions = Arrays.asList("zip", "jar", "rar");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        box.getItems().addAll(extensions);
    }

    public void SavingFile(ActionEvent event) {
        System.out.println(box.getValue());
        Stage stage = (Stage) ok.getScene().getWindow();
        stage.close();
    }
}
