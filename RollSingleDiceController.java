package com.example.probabilitysim;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.LinkedList;

import static java.lang.Double.compare;

public class RollSingleDiceController {
    @FXML
    private Button roll;
    @FXML
    private Button back;
    @FXML
    private TextField probability;
    @FXML
    private TextField thatOneDie;
    @FXML
    private TableView storedRolls;
    @FXML
    private TableColumn numFace;
    @FXML
    private TableColumn rolledProbability;
    private UnfairDice UD;
    private int tempFaces;
    private LinkedList<RolledDie> rolledDieList = new LinkedList<>();

    @FXML
    private void backToListView() throws IOException {
        MainProbabilityApp.switchToDiceView();
    }
    @FXML
    private double calculate() {
        if(UD != null) {
            double tempProb = this.UD.getProb();
            this.tempFaces = this.UD.getFaces();
            double randoFace;
            if (UD.getFaceProb() == 0){
                randoFace = (Math.random() * (UD.getFaces()) + 1.0);
            }else {
                randoFace = Math.random();
                int num = compare(randoFace, UD.getProb());
                if (num == -1 || num == 0) {
                    randoFace = UD.getFaceProb();
                }else {
                    randoFace = excludeARandoFace();
                }
            }
            if (this.UD.getFaceProb() == 0) {
                probability.setText(String.valueOf(tempProb));
                RolledDie tempDie = new RolledDie(tempFaces, (int) randoFace, UD.getFaceProb(), tempProb);
                rolledDieList.add(tempDie);
                storedRolls.setItems(FXCollections.observableList(rolledDieList));
                return tempProb;
            } else if (randoFace == this.UD.getFaceProb()) {
                probability.setText(String.valueOf(tempProb));
                RolledDie tempDie = new RolledDie(tempFaces, (int) randoFace, UD.getFaceProb(), tempProb);
                rolledDieList.add(tempDie);
                storedRolls.setItems(FXCollections.observableList(rolledDieList));
                return tempProb;
            } else {
                probability.setText(String.valueOf((1 - tempProb)/(tempFaces-1)));
                RolledDie tempDie = new RolledDie(tempFaces, (int) randoFace, UD.getFaceProb(), tempProb);
                rolledDieList.add(tempDie);
                storedRolls.setItems(FXCollections.observableList(rolledDieList));
                return 1 - tempProb;
            }
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("No Dice Selected");
            alert.setContentText("There is no dice to be rolled!");

            alert.showAndWait();
            return -1;
        }
    }
    public void setDie(UnfairDice d) {
        thatOneDie.setText(String.valueOf(d));
        this.UD = d;
    }
    public int excludeARandoFace() {
        LinkedList<Integer> sides = new LinkedList<>();
        for (int a = 1; a < UD.getFaces()+1; a++) {
            sides.add(a);
        }
        int ind = sides.indexOf(UD.getFaceProb());
        sides.remove(ind);
        int randoNum = (int) (Math.random()*(UD.getFaces()-1));
        return sides.get(randoNum);
    }

    public void initialize() {
        numFace.setCellValueFactory(new PropertyValueFactory<>("numOfFace"));
        rolledProbability.setCellValueFactory(new PropertyValueFactory<>("probability"));
    }
}
