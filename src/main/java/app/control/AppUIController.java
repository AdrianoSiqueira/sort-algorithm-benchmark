package app.control;

import app.algorithms.SortAlgorithm;
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
import javafx.scene.control.TextFormatter;
import javafx.scene.control.ToggleGroup;
import app.model.SortOrder;
import app.model.Test;
import app.util.ArrayFactory;
import app.util.SpinnerAmountValueFactory;
import app.util.StringIntegerConverter;
import app.util.TextFormatterChangeValidator;

import java.util.List;

public class AppUIController {

    @FXML private Spinner<Integer> spinnerAmount;

    @FXML private RadioButton radioAscending;
    @FXML private RadioButton radioDescending;

    @FXML private ToggleGroup groupOrder;

    @FXML private MenuItem itemLetter;
    @FXML private MenuItem itemNumber;
    @FXML private MenuItem itemBoth;

    @FXML private Label       labelMessage;
    @FXML private ProgressBar progressBar;

    @FXML private TableView<Test>           table;
    @FXML private TableColumn<Test, String> columnAlgorithm;
    @FXML private TableColumn<Test, String> columnTime;

    public void init() {
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
        spinnerAmount.getEditor().setAlignment(Pos.CENTER);
        spinnerAmount.getEditor().setTextFormatter(new TextFormatter<>(new StringIntegerConverter(),
                                                                       spinnerAmount.getValue(),
                                                                       new TextFormatterChangeValidator()));
        spinnerAmount.setValueFactory(new SpinnerAmountValueFactory());
        spinnerAmount.getValueFactory().setValue(10);
    }

    private void configureTable() {
        columnAlgorithm.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getAlgorithm()));
        columnAlgorithm.setSortable(true);
        columnAlgorithm.setSortType(TableColumn.SortType.ASCENDING);

        columnTime.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getTime().toString()));
    }

    @SuppressWarnings("unchecked")
    private <T> void run(T[] array, List<SortAlgorithm<T>> sortAlgorithms) {
        SortOrder order = (SortOrder) groupOrder.getSelectedToggle().getUserData();

        BenchmarkService<T> service = new BenchmarkService<T>(sortAlgorithms, array, order.comparator);
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
            String[]                    array          = ArrayFactory.getLetterNumberShuffled(spinnerAmount.getValue());
            List<SortAlgorithm<String>> sortAlgorithms = SortAlgorithm.getSortableList();

            run(array, sortAlgorithms);
        }
    }

    private class ItemLetterAction implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            String[]                    array          = ArrayFactory.getLetterShuffled(spinnerAmount.getValue());
            List<SortAlgorithm<String>> sortAlgorithms = SortAlgorithm.getSortableList();

            run(array, sortAlgorithms);
        }
    }

    private class ItemNumberAction implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            Integer[]                    array          = ArrayFactory.getIntegerShuffled(spinnerAmount.getValue());
            List<SortAlgorithm<Integer>> sortAlgorithms = SortAlgorithm.getSortableList();

            run(array, sortAlgorithms);
        }
    }
}
