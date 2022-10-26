package com.github.adrianosiqueira.sortalgorithmbenchmark.gui.window;

import com.github.adrianosiqueira.sortalgorithmbenchmark.gui.controller.AbstractController;
import com.github.adrianosiqueira.sortalgorithmbenchmark.gui.screen.AppUIController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ResourceBundle;

public class AppWindow extends Application {

    @Override
    public void start(Stage stage) {
        ResourceBundle resources = ResourceBundle.getBundle("com/github/adrianosiqueira/sortalgorithmbenchmark/language/Language");

        Pane root = loadScreen(new AppUIController(), resources);

        stage.setTitle(resources.getString("Sort.Algorithm.Benchmark"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    private Pane loadScreen(AbstractController controller, ResourceBundle resources) {
        controller.setResources(resources);
        controller.loadFxml(GridPane.class);

        return controller.getRoot();
    }
}
