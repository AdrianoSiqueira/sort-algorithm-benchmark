package com.github.adrianosiqueira.sortalgorithmbenchmark.gui.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public abstract class AbstractController {

    protected URL fxml;
    protected URL stylesheet;

    protected Pane               root;
    protected ResourceBundle     resources;
    protected AbstractController controller;


    public AbstractController(URL fxml) {
        this.fxml = fxml;
    }

    public AbstractController(URL fxml, URL stylesheet) {
        this.fxml       = fxml;
        this.stylesheet = stylesheet;
    }


    public Pane getRoot() {
        return root;
    }

    public <T extends Pane> void loadFxml(Class<T> rootType) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(fxml);
        loader.setController(controller);
        loader.setResources(resources);

        try {
            root = rootType.cast(loader.load());

            Optional.ofNullable(stylesheet)
                    .map(URL::toString)
                    .ifPresent(root.getStylesheets()::add);

            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setResources(ResourceBundle resources) {
        this.resources = resources;
    }

    protected abstract void init();
}
