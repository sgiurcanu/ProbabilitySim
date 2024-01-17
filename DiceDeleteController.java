package com.example.probabilitysim;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class DiceDeleteController {
    @FXML
    private Button yes;
    @FXML
    private Button no;
    private FairDice tempFD;
    private UnfairDice tempUFD;

    @FXML
    public void yesTouch() throws IOException {
        if (tempFD == null) {
            int i = DiceController.unfairDiceList.indexOf(tempUFD);
            DiceController.unfairDiceList.remove(i);
            int a = DiceController.selectedUnfairDiceList.indexOf(tempUFD);
            DiceController.selectedUnfairDiceList.remove(a);
            MainProbabilityApp.switchToDiceView();
        }else {
            int b = DiceController.fairDiceList.indexOf(tempFD);
            DiceController.fairDiceList.remove(b);
            int c = DiceController.selectedFairDiceList.indexOf(tempFD);
            DiceController.selectedFairDiceList.remove(c);
            MainProbabilityApp.switchToDiceView();
        }
    }
    @FXML
    public void noTouch() throws IOException {
        MainProbabilityApp.switchToDiceView();
    }
    public void getSelectedFairDie(FairDice d) {
        tempFD = d;
    }
    public void getSelectedUnfairDie(UnfairDice d) {
        tempUFD = d;

    }

}
