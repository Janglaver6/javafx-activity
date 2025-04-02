package aclcbukidnon.com.javafxactivity.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CounterController {

    @FXML
    private Button incrementButton;

    @FXML
    private Button decrementButton;

    @FXML
    private Label counterLabel;

    private int counter = 0;

    @FXML
    private void handleIncrement() {
        counter++;
        updateCounterLabel();
    }

    @FXML
    private void handleDecrement() {
        counter--;
        updateCounterLabel();
    }

    private void updateCounterLabel() {
        counterLabel.setText(String.valueOf(counter));
    }
}
