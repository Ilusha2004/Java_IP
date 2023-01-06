module com.grapfx.guisup {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.grapfx.guisup to javafx.fxml;
    exports com.grapfx.guisup;
}