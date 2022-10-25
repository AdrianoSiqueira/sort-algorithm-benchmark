package com.github.adrianosiqueira.sortalgorithmbenchmark.main;

import com.github.adrianosiqueira.sortalgorithmbenchmark.control.AppUIController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ResourceBundle;

@Deprecated
public class Main extends Application {

    @Override
    public void start(Stage stage)
    throws IOException {
        ResourceBundle bundle = ResourceBundle.getBundle("language/Language");
        FXMLLoader     loader = new FXMLLoader(getClass().getResource("/gui/AppUI.fxml"), bundle);

        Parent root = loader.load();
        root.getStylesheets().add("/gui/AppUI.css");

        AppUIController controller = loader.getController();
        controller.init();

        stage.setTitle(bundle.getString("Sort.Algorithm.Benchmark"));
        stage.setScene(new Scene(root));
        stage.show();
    }
}
