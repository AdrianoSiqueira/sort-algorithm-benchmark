package com.github.adrianosiqueira.sortalgorithmbenchmark.gui.screen;

import com.github.adrianosiqueira.sortalgorithmbenchmark.algorithms.SortAlgorithm;
import com.github.adrianosiqueira.sortalgorithmbenchmark.control.BenchmarkService;
import com.github.adrianosiqueira.sortalgorithmbenchmark.gui.controller.AbstractController;
import com.github.adrianosiqueira.sortalgorithmbenchmark.model.Result;
import com.github.adrianosiqueira.sortalgorithmbenchmark.model.SortOrder;
import com.github.adrianosiqueira.sortalgorithmbenchmark.util.ArrayFactory;
import com.github.adrianosiqueira.sortalgorithmbenchmark.util.IntegerStringConverter;
import com.github.adrianosiqueira.sortalgorithmbenchmark.util.SpinnerAmountValueFactory;
import com.github.adrianosiqueira.sortalgorithmbenchmark.util.TextFormatterChangeValidator;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.ToggleGroup;

import java.util.List;

public class AppUIController extends AbstractController {

    @FXML private Spinner<Integer> spinnerAmount;

    @FXML private RadioButton radioAscending;
    @FXML private RadioButton radioDescending;

    @FXML private ToggleGroup groupOrder;

    @FXML private MenuItem itemLetter;
    @FXML private MenuItem itemNumber;
    @FXML private MenuItem itemBoth;

    @FXML private Label       labelMessage;
    @FXML private ProgressBar progressBar;

    @FXML private TableView<Result>           table;
    @FXML private TableColumn<Result, String> columnAlgorithm;
    @FXML private TableColumn<Result, String> columnTime;


    public AppUIController() {
        super(
                AppUIController.class.getResource("AppUI.fxml"),
                AppUIController.class.getResource("AppUI.css")
        );
        super.controller = this;
    }


    @Override
    protected void init() {
        configureMenuButton();
        configureProgressBar();
        configureRadioOrder();
        configureSpinnerAmount();
        configureTable();
    }

    private void configureMenuButton() {
        itemBoth.setOnAction(new ItemBothAction());
        itemLetter.setOnAction(new ItemLetterAction());
        itemNumber.setOnAction(new ItemNumberAction());
    }

    private void configureProgressBar() {
        // Binds the bar length with 90% of progressBar's length
        progressBar.widthProperty()
                   .addListener((observable, oldValue, newValue) ->
                                        progressBar.setStyle("-fx-indeterminate-bar-length: " +
                                                             (newValue.intValue() * 0.9) +
                                                             ";"));
    }

    private void configureRadioOrder() {
        radioAscending.setUserData(SortOrder.ASCENDING);
        radioDescending.setUserData(SortOrder.DESCENDING);
    }

    private void configureSpinnerAmount() {
        TextField editor = spinnerAmount.getEditor();
        editor.setAlignment(Pos.CENTER);
        editor.setTextFormatter(new TextFormatter<>(
                new IntegerStringConverter(),
                spinnerAmount.getValue(),
                new TextFormatterChangeValidator()
        ));

        spinnerAmount.setValueFactory(new SpinnerAmountValueFactory());
        spinnerAmount.getValueFactory().setValue(10);
    }

    private void configureTable() {
        columnAlgorithm.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getAlgorithm()));
        columnAlgorithm.setSortable(true);
        columnAlgorithm.setSortType(TableColumn.SortType.ASCENDING);

        columnTime.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getCompletionTime().toString()));
    }

    @SuppressWarnings("unchecked")
    private <T> void run(T[] array, List<SortAlgorithm<T>> algorithms) {
        SortOrder order = (SortOrder) groupOrder.getSelectedToggle().getUserData();

        BenchmarkService<T> service = new BenchmarkService<T>(algorithms, array, order.getComparator());
        service.setOnScheduled(event -> table.getItems().clear());
        service.setOnSucceeded(event -> {
            table.getItems().clear();
            table.getItems().addAll(service.getValue());

            labelMessage.textProperty().unbind();
            labelMessage.setText("");

            progressBar.progressProperty().unbind();
            progressBar.setProgress(-1);
        });

        labelMessage.textProperty().bind(service.messageProperty());
        progressBar.progressProperty().bind(service.progressProperty());

        service.start();
    }

    private class ItemBothAction implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            String[]                    array      = ArrayFactory.getAlphanumericShuffled(spinnerAmount.getValue());
            List<SortAlgorithm<String>> algorithms = SortAlgorithm.getAlgorithms();

            run(array, algorithms);
        }
    }

    private class ItemLetterAction implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            String[]                    array      = ArrayFactory.getAlphabeticShuffled(spinnerAmount.getValue());
            List<SortAlgorithm<String>> algorithms = SortAlgorithm.getAlgorithms();

            run(array, algorithms);
        }
    }

    private class ItemNumberAction implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            Integer[]                    array      = ArrayFactory.getNumericShuffled(spinnerAmount.getValue());
            List<SortAlgorithm<Integer>> algorithms = SortAlgorithm.getAlgorithms();

            run(array, algorithms);
        }
    }
}
