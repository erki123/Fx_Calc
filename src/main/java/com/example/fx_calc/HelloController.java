package com.example.fx_calc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class HelloController {

    @FXML
    private TextField ansField;

    @FXML
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnAdd, btnDiv, btnMul, btnSub, btnC, btnEquals;

    @FXML
    Text savedNumbers;
    String firstNumber = "";

    String currentNumber = "";

    String calculationType;

    @FXML
    void doClear (ActionEvent event) {
        currentNumber = "";
        ansField.setText("");
        savedNumbers.setText("");
    }


    @FXML
    void do0(ActionEvent event) {
            addNumber("0");

    }

    @FXML
    void do1(ActionEvent event) {
        addNumber("1");
    }

    @FXML
    void do2(ActionEvent event) {addNumber("2");}

    @FXML
    void do3(ActionEvent event) {
        addNumber("3");
    }

    @FXML
    void do4(ActionEvent event) {
        addNumber("4");
    }

    @FXML
    void do5(ActionEvent event) {
        addNumber("5");
    }

    @FXML
    void do6(ActionEvent event) {
        addNumber("6");
    }

    @FXML
    void do7(ActionEvent event) {
        addNumber("7");
    }

    @FXML
    void do8(ActionEvent event) {
        addNumber("8");
    }

    @FXML
    void do9(ActionEvent event) {
        addNumber("9");
    }

    @FXML
    void doAdd(ActionEvent event) {

        calculationSetup("+");
    }

    @FXML
    void doDiv(ActionEvent event) {
        calculationSetup("/");
    }

    /*@FXML
    void doEquals(ActionEvent event) {

    }*/

    @FXML
    void doMul(ActionEvent event) {
        calculationSetup("*");
    }

    @FXML
    void doSub(ActionEvent event) {
        calculationSetup("-");
    }

    /*@FXML
    void doClear(ActionEvent event) {
        AnsField.clear();
    }*/

    @FXML
    void doAnsField (ActionEvent event) {
        String number = ((Button)event.getSource()).getText();
        ansField.setText(ansField.getText() + number);
    }

    public void calculationSetup(String calculationType){
        this.calculationType = calculationType;
        firstNumber = currentNumber;
        currentNumber = "";
        savedNumbers.setText(firstNumber + " " + calculationType);
    }

    @FXML
    void doEquals (ActionEvent event) {
        int firstNumberInt = Integer.parseInt(firstNumber);
        int secondNumberInt = Integer.parseInt(currentNumber);

        switch (calculationType) {
            case "+" -> {
                int calculatedNumber = firstNumberInt + secondNumberInt;
                savedNumbers.setText(firstNumber + " + " + currentNumber + " = " + calculatedNumber);
                ansField.setText(String.valueOf(calculatedNumber));
            }
            case "-" -> {
                int calculatedNumber = firstNumberInt - secondNumberInt;
                savedNumbers.setText(firstNumber + " - " + currentNumber + " = " + calculatedNumber);
                ansField.setText(String.valueOf(calculatedNumber));
            }
            case "/" -> {
                double calculatedNumber = firstNumberInt / (double)secondNumberInt;
                savedNumbers.setText(firstNumber + " / " + currentNumber + " = " + calculatedNumber);
                ansField.setText(String.valueOf(calculatedNumber));
            }
            case "*" -> {
                int calculatedNumber = firstNumberInt * secondNumberInt;
                savedNumbers.setText(firstNumber + " * " + currentNumber + " = " + calculatedNumber);
                ansField.setText(String.valueOf(calculatedNumber));
            }
        }
    }
    public void updateTextField(){
        ansField.setText(currentNumber);
    }

    public void addNumber(String number){
        currentNumber += number;
        updateTextField();
    }


}