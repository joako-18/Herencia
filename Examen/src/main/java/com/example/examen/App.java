package com.example.examen;

import com.example.examen.controller.InicioController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;
public class App extends Application {
    private static Stage stageRoot;
    @Override
    public void start(Stage stage) throws IOException {
        stageRoot = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("inicio-view.fxml"));
        Parent root = fxmlLoader.load();
        InicioController controller = fxmlLoader.getController();
        controller.initialize(stageRoot);

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/com/example/examen/Style.css").toExternalForm());
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}