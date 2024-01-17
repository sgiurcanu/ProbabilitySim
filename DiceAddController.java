package com.example.probabilitysim;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.LinkedList;

public class DiceAddController {
    @FXML
    private TextField faces;
    @FXML
    private TextField probability;
    @FXML
    private TextField faceOfProbability;
    @FXML
    private Button makeNew;
    @FXML
    private Button goBack;
    private boolean P;
    public void setToggleButton(boolean p) {
        this.P = p;
    }
    @FXML
    void makeTouch() throws IOException {
        if (this.P == false) {
            if (Double.parseDouble(faces.getText()) > 1) {
                FairDice tempDie = new FairDice(Integer.parseInt(faces.getText()));
                MainProbabilityApp.addFairDiceToList(tempDie);
            }else if (Integer.parseInt(faces.getText()) <= 0){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Unable to set Faces");
                alert.setContentText("Cannot set Faces; Setting this face value is stupid!");

                alert.showAndWait();
            }else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Unable to set Probability");
                alert.setContentText("Cannot set probability; Setting this probability is stupid!");

                alert.showAndWait();
            }
        }else {
            if (Double.parseDouble(probability.getText()) < 1 && Double.parseDouble(probability.getText()) > 0) {
                UnfairDice tempDie = new UnfairDice(Integer.parseInt(faces.getText()), Double.parseDouble(probability.getText()), Integer.parseInt(faceOfProbability.getText()));
                MainProbabilityApp.addUnfairDiceToList(tempDie);
            }else if (Integer.parseInt(faces.getText()) <= 0){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Unable to set Faces");
                alert.setContentText("Cannot set Faces; Setting this face value is stupid!");

                alert.showAndWait();
            }else if (Integer.parseInt(faceOfProbability.getText()) <= 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Unable to set this face value as unfair probability");
                alert.setContentText("Cannot set Faces; Setting this face value is stupid!");

                alert.showAndWait();
            }else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Unable to set Probability");
                alert.setContentText("Cannot set probability; Setting this probability is stupid!");

                alert.showAndWait();
            }
        }
    }
    @FXML
    public void backTouch() throws IOException {MainProbabilityApp.switchToDiceView();}
}
