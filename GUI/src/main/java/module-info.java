module com.graphfx.gui {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires json.simple;
    requires java.compiler;
    requires java.xml;
//    requires javafx.scene.web;


    opens com.graphfx.gui to javafx.fxml;
    exports com.graphfx.gui;
}