package com.graphfx.gui;

import cross_cutting.BuilderAriphmeticParser.ParserAndWriterBuilder;
import cross_cutting.BuilderAriphmeticParser.ParserFabric;
import cross_cutting.DecoratorFileManager.*;
import cross_cutting.EnumTypes.Actions;
import cross_cutting.EnumTypes.Extensions;
import cross_cutting.Parsers.Parser;
import cross_cutting.Parsers.Writer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class StageController {

    private static DataForFile data = new DataForFile();
    private Stage stage;
    private Scene scene;
    private Parent root;
    private static Scenes scenes = new Scenes();
    private static Stage tempStage;
    private static String extension;

    public static String getExtension() {
        return extension;
    }

    public DataForFile getData() {
        return data;
    }

    //------------------------------------------------------------------------------------------------------------------
    @FXML
    Button closeButton;

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

        if(scenes.getCounter() == scenes.getAllPath().size() - 2) {
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

    //------------------------------------------------------------------------------------------------------------------

    @FXML
    CheckBox boxFir, boxSec, boxReverse;
    @FXML
    Label label_1;

    public void change(ActionEvent event) {

        if (boxFir.isSelected() && boxSec.isSelected() && boxReverse.isSelected()) {
            label_1.setText("compress and encrypt");
            data.setActions(Actions.ARCHIVE_AND_ENCRYPT);
            System.out.println("compress and encrypt");
        }
        else if(boxFir.isSelected() && boxSec.isSelected()) {
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
        else {
            System.out.println("Actions are not detected");
        }

    }

    //------------------------------------------------------------------------------------------------------------------

    @FXML
    private RadioButton button_0, button_1, button_2;

    public void ChangeExtensions(ActionEvent event) {
        if(button_0.isSelected()) {
            System.out.println("zip");
            data.setArchiveExtension(Extensions.ZIP);
        }
        else if(button_1.isSelected()) {
            System.out.println("rar");
            data.setArchiveExtension(Extensions.RAR);
        }
        else if(button_2.isSelected()) {
            System.out.println("jar");
            data.setArchiveExtension(Extensions.JAR);
        }

    }

    //------------------------------------------------------------------------------------------------------------------

    @FXML
    private RadioButton buttonIn_0, buttonIn_1, buttonIn_2;
    @FXML
    private RadioButton buttonOut_0, buttonOut_1, buttonOut_2;

    public void ChangeInOutExtensions(ActionEvent event) {

        if (buttonIn_0.isSelected()){
            System.out.println("xml");
            data.setInExtensions(Extensions.XML);
        }
        else if (buttonIn_1.isSelected()) {
            System.out.println("json");
            data.setInExtensions(Extensions.JSON);
        }
        else if (buttonIn_2.isSelected()) {
            System.out.println("txt");
            data.setInExtensions(Extensions.TXT);
        }

        if (buttonOut_0.isSelected()){
            System.out.println("xml");
            data.setOutExtension(Extensions.XML);
        }
        else if (buttonOut_1.isSelected()) {
            System.out.println("json");
            data.setOutExtension(Extensions.JSON);
        }
        else if (buttonOut_2.isSelected()) {
            System.out.println("txt");
            data.setOutExtension(Extensions.TXT);
        }

    }

    //------------------------------------------------------------------------------------------------------------------

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

        if (data.getActions() != null) {

            try {
                CreateActionForFile createActionForFile = new CreateActionForFile(data.getPath(),
                        data.getInExtensions(),
                        data.getOutExtension(),
                        data.getActions(),
                        data.getArchiveExtension());

                createActionForFile.CreateAction();
                createActionForFile.start();

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }

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
    Button inputButton;
    @FXML
    TextField inputField;
    @FXML
    RadioButton writeButtonXMl, writeButtonTXT, writeButtonJSON;

    private FileChannel desktop;

    public void selectInputFile(ActionEvent actionEvent) {
        Stage primaryStage = new Stage();
        final FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("./src/res"));

        inputButton.setOnAction(event -> {
            inputField.clear();
            File file = fileChooser.showOpenDialog(primaryStage);
            if (file != null) {
                openFile(file);

                List<File> files = Arrays.asList(file);
                printLog(inputField, files);
                data.setPath(inputField.getText());
            }
        });

        data.setPath(inputField.getText());
        System.out.println(data.getPath());

    }

    public void WriteExtensionParser(ActionEvent event) {

        if(writeButtonJSON.isSelected()){
            System.out.println("Json");
            extension = "json";
            data.setOutExtension(Extensions.JSON);
        }
        else if(writeButtonTXT.isSelected()){
            System.out.println("txt");
            extension = "txt";
            data.setOutExtension(Extensions.TXT);
        }
        else if(writeButtonXMl.isSelected()){
            System.out.println("xml");
            extension = "xml";
            data.setOutExtension(Extensions.XML);
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

    public void IncreaseSceneAfter(ActionEvent event) throws IOException, ParserConfigurationException, SAXException {
        scenes.Increase();

        ParserFabric fabric = new ParserFabric(data.getPath(), "src/res/new." + extension);

        File file = new File("src/res/new." + extension);
        data.setPath("src/res/new." + extension);
        file.createNewFile();

        ParserAndWriterBuilder builder = new ParserAndWriterBuilder();

        fabric.Create(builder);
        Parser parser = builder.getParser();
        Writer writer = builder.getWriter();

        parser.parse();
        writer.write();

        Switch(event);
    }

    //------------------------------------------------------------------------------------------------------------------

}
