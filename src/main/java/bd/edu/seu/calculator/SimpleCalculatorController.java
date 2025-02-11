package bd.edu.seu.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SimpleCalculatorController {
    @FXML
    private TextField display;
    private String firstNumber = "";
    private String secondNumber = "";
    private String currentOperator = "";
    private double results = 0.0;

    private void displayNumbers(String number) {
        if (currentOperator.isEmpty())
            firstNumber += number;
        else
            secondNumber += number;
        display.setText(currentOperator.isEmpty() ? firstNumber : secondNumber);
    }

    private void handleOperator(String operator) {
        if (currentOperator.isEmpty()) {
            currentOperator = operator;
        } else {
            calculation();
            currentOperator = operator;
        }
    }

    public void button7Action(ActionEvent actionEvent) {
        displayNumbers("7");
    }

    public void button8Action(ActionEvent actionEvent) {
        displayNumbers("8");
    }

    public void button9Action(ActionEvent actionEvent) {
        displayNumbers("9");
    }

    public void button4Action(ActionEvent actionEvent) {
        displayNumbers("4");
    }

    public void button5Action(ActionEvent actionEvent) {
        displayNumbers("5");
    }

    public void button6Action(ActionEvent actionEvent) {
        displayNumbers("6");
    }

    public void button1Action(ActionEvent actionEvent) {
        displayNumbers("1");
    }

    public void button2Action(ActionEvent actionEvent) {
        displayNumbers("2");
    }

    public void button3Action(ActionEvent actionEvent) {
        displayNumbers("3");
    }

    public void button0Action(ActionEvent actionEvent) {
        displayNumbers("0");
    }

    public void buttonDivAction(ActionEvent actionEvent) {
        handleOperator("/");
    }

    public void buttonMulAction(ActionEvent actionEvent) {
        handleOperator("x");
    }

    public void buttonMinusAction(ActionEvent actionEvent) {
        handleOperator("-");
    }

    public void buttonPlusAction(ActionEvent actionEvent) {
        handleOperator("+");
    }

    public void buttonResultAction(ActionEvent actionEvent) {
        calculation();
    }

    private void calculation() {
        if (firstNumber.isEmpty() || secondNumber.isEmpty()) {
            System.out.println("Error: Missing numbers for calculation");
            return;
        }

        try {
            double firstNumb = Double.parseDouble(this.firstNumber);
            double secondNumb = Double.parseDouble(this.secondNumber);

            switch (currentOperator) {
                case "+" -> {
                    results = firstNumb + secondNumb;
                    display.setText(String.valueOf(results));
                }
                case "-" -> {
                    results = firstNumb - secondNumb;
                    display.setText(String.valueOf(results));
                }
                case "x" -> {
                    results = firstNumb * secondNumb;
                    display.setText(String.valueOf(results));
                }
                case "/" -> {
                    if (secondNumb != 0) {
                        results = firstNumb / secondNumb;
                        display.setText(String.valueOf(results));
                    } else {
                        display.setText("Error");
                        results = 0.0;
                    }
                }
                default -> {
                    System.out.println("Error: Invalid operator");
                }
            }
        } catch (NumberFormatException e) {
            display.setText("Error");
        }

        firstNumber = String.valueOf(results);
        secondNumber = "";
        currentOperator = "";
    }

    public void buttonBackAction(ActionEvent actionEvent) {
        if (!secondNumber.isEmpty()) {
            secondNumber = secondNumber.substring(0, secondNumber.length() - 1);
            display.setText(secondNumber);
        } else if (!currentOperator.isEmpty()) {
            currentOperator = "";
            display.setText(firstNumber);
        } else if (!firstNumber.isEmpty()) {
            firstNumber = firstNumber.substring(0, firstNumber.length() - 1);
            display.setText(firstNumber);
        }
    }

    public void buttonClearAction(ActionEvent actionEvent) {
        firstNumber = "";
        secondNumber = "";
        currentOperator = "";
        results = 0.0;
        display.setText("0");
    }

    public void buttonOpenBracketAction(ActionEvent actionEvent) {
        if (currentOperator.isEmpty()) {
            firstNumber += "(";
            display.setText(firstNumber);
        } else {
            secondNumber += "(";
            display.setText(secondNumber);
        }
    }

    public void buttonCloseBracketAction(ActionEvent actionEvent) {
        if (currentOperator.isEmpty()) {
            firstNumber += ")";
            display.setText(firstNumber);
        } else {
            secondNumber += ")";
            display.setText(secondNumber);
        }
    }

    public void buttonXSquareAction(ActionEvent actionEvent) {
        if (firstNumber.isEmpty()) {
            return;
        }

        double num = Double.parseDouble(firstNumber);
        results = Math.pow(num, 2);
        display.setText(String.valueOf(results));
        firstNumber = String.valueOf(results);
        secondNumber = "";
    }

    public void buttonXCubeAction(ActionEvent actionEvent) {
        if (firstNumber.isEmpty()) {
            return;
        }

        double num = Double.parseDouble(firstNumber);
        results = Math.pow(num, 3);
        display.setText(String.valueOf(results));
        firstNumber = String.valueOf(results);
        secondNumber = "";
    }

    public void buttonPointAction(ActionEvent actionEvent) {
        if (currentOperator.isEmpty() && !firstNumber.contains(".")) {
            firstNumber += ".";
            display.setText(firstNumber);
        } else if (!secondNumber.contains(".")) {
            secondNumber += ".";
            display.setText(secondNumber);
        }
    }

    public void buttonPrecentAction(ActionEvent actionEvent) {
        double num = Double.parseDouble(firstNumber);
        results = num / 100;
        display.setText(String.valueOf(results));
        firstNumber = String.valueOf(results);
        secondNumber = "";
    }
}
