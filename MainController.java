package com.example.probabilitysim;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class MainController {
    /*
    @FXML
    private Button diceButton;
    @FXML
    private Button cardsButton;

    @FXML
    private Button coinButton;
    @FXML
    private Button spinnerButton;
    @FXML
    private Button marbleButton;

     */
    @FXML
    private Button helpButton;
    @FXML
    private MenuItem diceItem;
    @FXML
    private MenuItem cardsItem;
    @FXML
    private MenuItem coinItem;
    @FXML
    private MenuItem spinnerItem;
    @FXML
    private MenuItem marbleItem;
    @FXML
    private MenuItem lotteryItem;

    @FXML
    private MenuButton options;


    public void initialize(){

    }
    /*
    //switches to dice
    @FXML
    public void diceButtonClick() throws IOException{
        HelloApplication.switchToDiceView();
    }
    //switches to cards
    @FXML
    public void cardsButtonClick() throws IOException {
        HelloApplication.switchToCardView();
    }
    @FXML
    public void marbleButtonClick() throws IOException{
        HelloApplication.switchToMarbleView();
    }
    @FXML
    public void spinnerButtonClick() throws IOException{
        HelloApplication.switchToSpinnerView();
        */

    @FXML
    public void helpButtonClick() throws IOException{
        HelloApplication.switchToHelpView();
    }
    /*

    //switches to coins
    @FXML
    public void coinButtonClick() throws IOException{
        HelloApplication.switchToCoinView();
    }

     */
    //TO ADD NEW SECTION: CREATE MENUITEM INSTNCE VARIABLE,THEN ADD SAID MENUITEM TOTHE MENUBUTTON IN SCENEBUILDER. HEN CREATE A SWITCH TO METHOD IN HELLOAPLICATION AND ADD TO THIS METHOD.
    @FXML
    public void menuButtonClick(ActionEvent e) throws IOException {
        if (e.getSource() == diceItem) {
            MainProbabilityApp.switchToDiceView();
        }
        else if (e.getSource() == cardsItem) {
            HelloApplication.switchToCardView();
        }
        else if (e.getSource() == coinItem) {
            HelloApplication.switchToCoinView();
        }
        else if (e.getSource() == spinnerItem) {
            HelloApplication.switchToSpinnerView();
        }
        else if (e.getSource() == marbleItem) {
            HelloApplication.switchToMarbleView();
        }
        else if(e.getSource()== lotteryItem){
            HelloApplication.switchToLotteryView();
        }
    }

}
