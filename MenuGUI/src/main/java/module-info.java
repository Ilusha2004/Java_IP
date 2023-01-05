module com.graphics_interf.menugui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.graphics_interf.menugui to javafx.fxml;
    exports com.graphics_interf.menugui;
}