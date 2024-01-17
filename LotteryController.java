package com.example.probabilitysim;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class LotteryController {

    @FXML
    TextField numOne;
    @FXML
    TextField numTwo;
    @FXML
    TextField numThree;
    @FXML
    TextField numFour;
    @FXML
    TextField numFive;
    @FXML
    TextField numSix;
    @FXML
    Button submit;

    Lottery ticket;
    
    @FXML
    Label win;
    @FXML
    Label probability;
    @FXML
    Label output;
    @FXML
    Button calculate;
    @FXML
    Slider slider;


    public void probCalc(){
        int numOfNum = (int)slider.getValue();
        output.setText(Lottery.theoreticalProb(numOfNum) +"");
    }

    public void onClickHandler(ActionEvent e) {
        if (e.getSource()== submit) {
            ticket = new Lottery(Integer.parseInt(numOne.getText()),
                    Integer.parseInt(numTwo.getText()),
                    Integer.parseInt(numThree.getText()),
                    Integer.parseInt(numFour.getText()),
                    Integer.parseInt(numFive.getText()),
                    Integer.parseInt(numSix.getText()));
            if(ticket.winPlay()) win.setText("You Won!");
            else win.setText("You Lost!");
        }
    }

}
