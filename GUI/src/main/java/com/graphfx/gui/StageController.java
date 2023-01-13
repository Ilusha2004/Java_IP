package com.graphfx.gui;

import cross_cutting.DecoratorFileManager.CreateActionForFile;
import cross_cutting.EnumTypes.Actions;
import cross_cutting.EnumTypes.Extensions;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class StageController {

    private static DataForFile data = new DataForFile();
    private Stage stage;
    private Scene scene;
    private Parent root;
    private static Scenes scenes = new Scenes();
    private static Stage tempStage;

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

        FXMLLoader loader = new FXMLLoader(getClass().getResource(scenes.getAllPath().get(scenes.getCounter())));
        root = loader.load(getClass().getResource(scenes.getAllPath().get(scenes.getCounter())));
        this.stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        System.out.println(scenes.getCounter());
        this.stage.setScene(scene);

        if(scenes.getCounter() == 3) {
            tempStage = stage;
        }

        this.stage.show();

    }

    public void PrevScene(ActionEvent event) throws IOException {
        scenes.Decrease();
        Switch(event);
    }

    public void Close() {
        System.out.println("closing");
        stage = (Stage) closeButton.getScene().getWindow();
        this.stage.close();

        scenes.setCounter(0);
    }

    public void NewPath(ActionEvent event) throws IOException {
        String path = textField.getText();
        label.setText("Path : " + path);
        data.setPath(path);
        System.out.println(data.getPath());
    }

    //------------------------------------------------------------------------------------------------------------------

    @FXML
    CheckBox boxFir, boxSec, boxReverse;
    @FXML
    Label label_1;

    public void change(ActionEvent event) {
        if(boxFir.isSelected() && boxSec.isSelected()) {
            label_1.setText("encrypt and compress");
            data.setActions(Actions.ENCRYPT_AND_ARCHIVE);
            System.out.println("encrypt and compress");
        }
        else if(boxFir.isSelected()){
            label_1.setText("encrypt");
            data.setActions(Actions.ENCRYPT);
            System.out.println("encrypt");
        }
        else if(boxSec.isSelected()) {
            label_1.setText("compress");
            data.setActions(Actions.ARCHIVE);
            System.out.println("compress");
        }
        else if (boxFir.isSelected() && boxSec.isSelected() && boxReverse.isSelected()) {
            label_1.setText("compress and encrypt");
            data.setActions(Actions.ARCHIVE_AND_ENCRYPT);
            System.out.println("compress and encrypt");
        }

    }

    //------------------------------------------------------------------------------------------------------------------

    @FXML
    private RadioButton button_0, button_1, button_2, button_3, button_4, button_5;

    public void ChangeExtensions(ActionEvent event) {
        if(button_0.isSelected()) {
            System.out.println("zip");
            data.setInExtensions(Extensions.ZIP);
        }
        else if(button_1.isSelected()) {
            System.out.println("rar");
            data.setInExtensions(Extensions.RAR);
        }
        else if(button_2.isSelected()) {
            System.out.println("jar");
            data.setInExtensions(Extensions.JAR);
        }
        else if(button_3.isSelected()) {
            System.out.println("json");
            data.setInExtensions(Extensions.JSON);
        }
        else if(button_4.isSelected()) {
            System.out.println("xml");
            data.setInExtensions(Extensions.XML);
        }
        else if(button_5.isSelected()) {
            System.out.println("txt");
            data.setInExtensions(Extensions.TXT);
        }

    }

    //------------------------------------------------------------------------------------------------------------------
    //WTF Section

    @FXML
    Label label_2;

    @FXML
    String extensions[] = { "zip", "rar", "jar", "json", "xml", "txt" };


    public void FTW(ActionEvent event) {
        Random random = new Random();
        int pos = random.nextInt(extensions.length);
        label_2.setText(extensions[pos]);
    }

    //------------------------------------------------------------------------------------------------------------------

    @FXML
    Button buttonPrev, buttonNext;
    public void EndAction(ActionEvent event) {

        try {
            Stage newStage = new Stage();
            newStage.initModality(Modality.APPLICATION_MODAL);
            Parent root = FXMLLoader.load(getClass().getResource("WarningSave.fxml"));
            newStage.setTitle("Warning");
            newStage.setScene(new Scene(root));
            newStage.showAndWait();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    //------------------------------------------------------------------------------------------------------------------

    @FXML
    Button noButton, yesButton;

    public void EndNo(ActionEvent event) {
        stage = (Stage) noButton.getScene().getWindow();
        this.stage.close();
    }

    public void EndYes(ActionEvent event) throws Exception {
        CreateActionForFile createActionForFile = new CreateActionForFile(data.getPath(), data.getInExtensions(), data.getOutExtension(), data.getActions());
        createActionForFile.CreateAction().writeData();

        System.out.println(data.getOutExtension() + " "
                + data.getInExtensions() + " "
                + data.getPath() + " "
                + data.getActions());

        data = new DataForFile();

        stage = (Stage) yesButton.getScene().getWindow();
        stage.close();
        tempStage.close();

        scenes.Increase();
        Switch(event);

        scenes.setCounter(0);
    }

    //------------------------------------------------------------------------------------------------------------------

    @FXML
    Button inputButton, outputButton;
    @FXML
    TextField inputField, outputField;

    private FileChannel desktop;

    public void selectInputFile(ActionEvent actionEvent) {
        Stage primaryStage = new Stage();
        final FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("C:/Users/speed/OneDrive/Рабочий стол/CC/src/res"));

        inputButton.setOnAction(event -> {
            inputField.clear();
            File file = fileChooser.showOpenDialog(primaryStage);
            if (file != null) {
                openFile(file);
                List<File> files = Arrays.asList(file);
                printLog(inputField, files);
            }
        });

        data.setPath(inputField.getText());
        System.out.println(data.getPath());

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

    //------------------------------------------------------------------------------------------------------------------



}