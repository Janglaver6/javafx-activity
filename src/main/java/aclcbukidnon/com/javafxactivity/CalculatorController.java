package aclcbukidnon.com.javafxactivity;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;

public class CalculatorController {

    @FXML public Button btn0;
    @FXML public Button btn1;
    @FXML public Button btn2;
    @FXML public Button btn3;
    @FXML public Button btn4;
    @FXML public Button btn5;
    @FXML public Button btn6;
    @FXML public Button btn7;
    @FXML public Button btn8;
    @FXML public Button btn9;
    @FXML public Button btnAdd;
    @FXML public Button btnClear;
    @FXML public Button btnBackspace;
    @FXML public Button btnSubtract;
    @FXML public Button btnDivide;
    @FXML public Button btnMultiply;
    @FXML public Button btnDecimal;
    @FXML public Button btnEquals;
    @FXML private Label displayLabel;

    private String currentInput = "";

    @FXML
    private void handleButtonAction(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        String value = clickedButton.getText();

        switch (value) {
            case "CLEAR":
                currentInput = "";
                break;
            case "BCKSPC":
                if (!currentInput.isEmpty()) {
                    currentInput = currentInput.substring(0, currentInput.length() - 1);
                }
                break;
            case "=":
                try {
                    if (!currentInput.isEmpty()) {
                        // Prevent expression ending with an operator
                        if (currentInput.matches(".*[+\\-*/]$")) {
                            displayLabel.setText("Error");
                            currentInput = "";
                            return;
                        }

                        Object result = eval(currentInput);
                        currentInput = result.toString();
                    }
                } catch (Exception e) {
                    currentInput = "";
                    displayLabel.setText("Error");
                    return;
                }
                break;
            default:
                if (currentInput.equals("0") && !value.equals(".")) {
                    currentInput = value;
                } else {
                    currentInput += value;
                }
                break;
        }

        displayLabel.setText(currentInput.isEmpty() ? "0" : currentInput);
    }

    // Safe expression evaluator using JavaScript engine
    private Object eval(String expression) throws Exception {
        // Reject invalid characters
        if (!expression.matches("[0-9+\\-*/.]+")) {
            throw new Exception("Invalid characters");
        }

        ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
        Object result = engine.eval(expression);
        return result;
    }
}
