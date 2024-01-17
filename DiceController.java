package com.example.probabilitysim;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class DiceController {
    @FXML
    private Text fair;
    @FXML
    private Text unfair;
    @FXML
    private ToggleButton fairOrUnfair;
    @FXML
    private TableView fairTable;
    @FXML
    private TableView unfairTable;
    @FXML
    private TableView clickedDiceTable;

    @FXML
    private Button delete;
    @FXML
    private Button rollMulti;
    @FXML
    private Button rollSingle;
    @FXML
    private Button addDie;
    @FXML
    private Button refresh;
    @FXML
    private TableColumn fairDiceFaces;
    @FXML
    private TableColumn unfairDiceFaces;
    @FXML
    private TableColumn unfairDiceProb;
    @FXML
    private TableColumn selectedDieFace;
    @FXML
    private TableColumn selectedDieProb;
    @FXML
    private TableColumn unfairFaceOfDieProb;
    @FXML
    private TextField selectedDie;
    public static LinkedList<FairDice> fairDiceList = new LinkedList<>();
    public static LinkedList<UnfairDice> unfairDiceList = new LinkedList<>();
    public static LinkedList<FairDice> selectedFairDiceList = new LinkedList<>();
    public static LinkedList<UnfairDice> selectedUnfairDiceList = new LinkedList<>();
    private FairDice tempFD;
    private UnfairDice tempUFD;

    @FXML
    public void fairDiceTouch() {
        tempFD = (FairDice) fairTable.getSelectionModel().getSelectedItem();
        if (tempFD != null) {
            int tempFace = tempFD.getFaces();
            double tempDoubleFace = tempFace;
            double y = 1;
            double tempProb = (y / tempDoubleFace);
            UnfairDice tempDie = new UnfairDice(tempFace, tempProb, 0);
            selectedDie.setText(String.valueOf(tempDie));
            selectedUnfairDiceList.add(tempDie);
            clickedDiceTable.setItems(FXCollections.observableList(selectedUnfairDiceList));
            tempUFD = null;
        }
    }
    @FXML
    public void unfairDiceTouch() {
        tempUFD = (UnfairDice) unfairTable.getSelectionModel().getSelectedItem();
        if (tempUFD != null) {
            selectedDie.setText(String.valueOf(tempUFD));
            selectedUnfairDiceList.add(tempUFD);
            clickedDiceTable.setItems(FXCollections.observableList(selectedUnfairDiceList));
            tempFD = null;
        }
    }
    @FXML
    public void refreshSelect() {
        selectedFairDiceList.clear();
        selectedUnfairDiceList.clear();
        tableSelectedAddRefresh();
    }

    public boolean isFairOrUnfair() {
        return fairOrUnfair.isSelected();
    }
    public void diceAddButton() throws IOException {MainProbabilityApp.switchToDiceAddView(isFairOrUnfair());}
    public void diceRollMultiButton() throws IOException {
        MainProbabilityApp.switchToDiceRollMultiView(selectedUnfairDiceList);
    }
    public void diceRollOnceButton() throws IOException {
        //unfair
        if (tempFD == null) {
            MainProbabilityApp.switchToDiceRollOnceView(tempUFD);
        }else if (tempUFD == null) {
            //fair
            double tempProb = tempFD.getProb();
            int tempFaces = tempFD.getFaces();
            UnfairDice tempUnfair = new UnfairDice(tempFaces, tempProb, 0);
            MainProbabilityApp.switchToDiceRollOnceView(tempUnfair);
        }
    }
    public void selectedDieTouch() {
        tempUFD = (UnfairDice) clickedDiceTable.getSelectionModel().getSelectedItem();
        System.out.println(tempUFD);
        selectedDie.setText(String.valueOf(tempUFD));
    }
    public void diceDeleteButton() throws  IOException {
        if (tempFD == null && tempUFD != null) {
            MainProbabilityApp.switchToDiceDeleteViewUnfair(tempUFD);
        } else if (tempUFD == null && tempFD != null){
            MainProbabilityApp.switchToDiceDeleteViewFair(tempFD);
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Unable to delete");
            alert.setContentText("Cannot delete, please select a die first.");

            alert.showAndWait();
        }
    }
    public void tableFairAddRefresh(FairDice d) {
        fairDiceList.add(d);
        fairTable.setItems(FXCollections.observableList(fairDiceList));
        fairTable.refresh();
    }
    public void tableUnfairAddRefresh(UnfairDice d) {
        unfairDiceList.add(d);
        unfairTable.setItems(FXCollections.observableList(unfairDiceList));
        unfairTable.refresh();
    }
    @FXML
    public void tableSelectedAddRefresh() {
        clickedDiceTable.setItems(FXCollections.observableList(selectedFairDiceList));
        clickedDiceTable.setItems(FXCollections.observableList(selectedUnfairDiceList));
        tempFD = null;
        tempUFD = null;
        clickedDiceTable.refresh();
    }
    public void initialize() {
        fairDiceFaces.setCellValueFactory(new PropertyValueFactory<>("faces"));
        unfairDiceFaces.setCellValueFactory(new PropertyValueFactory<>("faces"));
        unfairDiceProb.setCellValueFactory(new PropertyValueFactory<>("prob"));
        selectedDieFace.setCellValueFactory(new PropertyValueFactory<>("faces"));
        selectedDieProb.setCellValueFactory(new PropertyValueFactory<>("prob"));
        unfairFaceOfDieProb.setCellValueFactory(new PropertyValueFactory<>("faceProb"));

        fairTable.setItems(FXCollections.observableList(fairDiceList));
        unfairTable.setItems(FXCollections.observableList(unfairDiceList));
        clickedDiceTable.setItems(FXCollections.observableList(fairDiceList));
        clickedDiceTable.setItems(FXCollections.observableList(unfairDiceList));
        tableSelectedAddRefresh();
    }
}
