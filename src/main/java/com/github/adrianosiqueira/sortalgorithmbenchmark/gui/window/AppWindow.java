package com.github.adrianosiqueira.sortalgorithmbenchmark.gui.window;

import com.github.adrianosiqueira.sortalgorithmbenchmark.control.AppUIController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ResourceBundle;

public class AppWindow extends Application {

    @Override
    public void start(Stage stage)
    throws Exception {
        ResourceBundle bundle = ResourceBundle.getBundle("com/github/adrianosiqueira/sortalgorithmbenchmark/language/Language");
        FXMLLoader     loader = new FXMLLoader(getClass().getResource("/com/github/adrianosiqueira/sortalgorithmbenchmark/gui/screen/AppUI.fxml"), bundle);

        Parent root = loader.load();
        root.getStylesheets().add("/com/github/adrianosiqueira/sortalgorithmbenchmark/gui/screen/AppUI.css");

        AppUIController controller = loader.getController();
        controller.init();

        stage.setTitle(bundle.getString("Sort.Algorithm.Benchmark"));
        stage.setScene(new Scene(root));
        stage.show();
    }
}
