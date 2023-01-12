package com.graphfx.gui;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class WebSupportForRestAPI implements Initializable {

    @FXML
    private WebView view;
    @FXML
    private TextField textField;

    private WebEngine engine;
    private WebHistory history;
    private String mainpage = "www.google.com";
    private double coef = 1.0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        engine = view.getEngine();
        textField.setText(mainpage);
        System.out.println(textField.getText());
        Load();
    }

    @FXML
    private void Load() {
        engine.load("https://" + textField.getText().toString());
    }

    public void ZoomOut(ActionEvent event) {
        view.setZoom(coef-=0.1);
    }

    public void ZoomIn(ActionEvent event) {
        view.setZoom(coef+=0.1);
    }

    public void RefreshPage(ActionEvent event) {
        engine.reload();
    }

    public void ShowHistory(ActionEvent event) {
        history = engine.getHistory();
        ObservableList<WebHistory.Entry> entries = history.getEntries();

        for(var id : entries) {
            System.out.println(id);
        }
    }

    public void PrevPage(ActionEvent event) {
        history = engine.getHistory();
        ObservableList<WebHistory.Entry> entries = history.getEntries();
        history.go(-1);
        textField.setText(entries.get(history.getCurrentIndex()).getUrl());
    }

    public void NextPage(ActionEvent event) {
        history = engine.getHistory();
        ObservableList<WebHistory.Entry> entries = history.getEntries();
        history.go(1);
        textField.setText(entries.get(history.getCurrentIndex()).getUrl());
    }

}
