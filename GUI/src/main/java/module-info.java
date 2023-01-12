module com.graphfx.gui {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires json.simple;
    requires java.compiler;


    opens com.graphfx.gui to javafx.fxml;
    exports com.graphfx.gui;
}