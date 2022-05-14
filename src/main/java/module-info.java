module com.example.thefinalbattle {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.thefinalbattle to javafx.fxml;
    exports com.example.thefinalbattle;
}