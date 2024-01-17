package com.example.probabilitysim;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;

import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;

import static java.lang.Double.compare;

public class RollMultiDiceController {
    @FXML
    private Button back;
    @FXML
    private Button goToComparison;
    @FXML
    private Button roll;
    @FXML
    private TableView listOfDice;
    @FXML
    private TableView listOfRows;
    @FXML
    private TableColumn numOfFaces;
    @FXML
    private TableColumn probabilityForList;
    @FXML
    private TableColumn facesOfRolled;
    @FXML
    private TableColumn faceNumber;
    @FXML
    private TableColumn probabilityForRowed;
    @FXML
    private TextField showProbability;

    private LinkedList<UnfairDice> listOfUnfair = new LinkedList<>();

    @FXML
    public double calculate() {
        double trueProbability = 0.0;
        LinkedList<RolledDie> childTreeBranch = new LinkedList<>();
        for (int i = 0; i < listOfUnfair.size(); i++) {
            double randoFace;
            if (listOfUnfair.get(i).getFaceProb() == 0){
                randoFace = (Math.random() * (listOfUnfair.get(i).getFaces()) + 1.0);
            }else {
                randoFace = Math.random();
                int num = compare(randoFace, listOfUnfair.get(i).getProb());
                if (num == -1 || num == 0) {
                    randoFace = listOfUnfair.get(i).getFaceProb();
                }else {
                    randoFace = excludeARandoFace(i);
                }
            }
            if (trueProbability == 0.0) {
                if (listOfUnfair.get(i).getFaceProb() == 0.0) {
                    RolledDie tempDie = new RolledDie(listOfUnfair.get(i).getFaces(), (int) randoFace, listOfUnfair.get(i).getFaceProb(), listOfUnfair.get(i).getProb());
                    childTreeBranch.add(tempDie);
                    trueProbability = listOfUnfair.get(i).getProb();
                } else if (randoFace == listOfUnfair.get(i).getFaceProb()) {
                    RolledDie tempDie = new RolledDie(listOfUnfair.get(i).getFaces(), (int) randoFace, listOfUnfair.get(i).getFaceProb(), listOfUnfair.get(i).getProb());
                    childTreeBranch.add(tempDie);
                    trueProbability = listOfUnfair.get(i).getProb();
                } else {
                    RolledDie tempDie = new RolledDie(listOfUnfair.get(i).getFaces(), (int) randoFace, listOfUnfair.get(i).getFaceProb(), ((1-listOfUnfair.get(i).getProb())/(listOfUnfair.get(i).getFaces()-1)));
                    childTreeBranch.add(tempDie);
                    trueProbability = (1.0 - listOfUnfair.get(i).getProb())/(listOfUnfair.get(i).getFaces()-1.0);
                }
            }else {
                if (listOfUnfair.get(i).getFaceProb() == 0.0) {
                    RolledDie tempDie = new RolledDie(listOfUnfair.get(i).getFaces(), (int) randoFace, listOfUnfair.get(i).getFaceProb(), listOfUnfair.get(i).getProb());
                    childTreeBranch.add(tempDie);
                    trueProbability = trueProbability * listOfUnfair.get(i).getProb();
                } else if (randoFace == listOfUnfair.get(i).getFaceProb()) {
                    RolledDie tempDie = new RolledDie(listOfUnfair.get(i).getFaces(), (int) randoFace, listOfUnfair.get(i).getFaceProb(),  listOfUnfair.get(i).getProb());
                    childTreeBranch.add(tempDie);
                    trueProbability = trueProbability * listOfUnfair.get(i).getProb();
                } else {
                    RolledDie tempDie = new RolledDie(listOfUnfair.get(i).getFaces(), (int) randoFace, listOfUnfair.get(i).getFaceProb(), ((1-listOfUnfair.get(i).getProb())/(listOfUnfair.get(i).getFaces()-1)));
                    childTreeBranch.add(tempDie);
                    trueProbability =trueProbability * (1.0 - listOfUnfair.get(i).getProb())/(listOfUnfair.get(i).getFaces()-1.0);
                }
            }
        }
        listOfRows.setItems(FXCollections.observableList(childTreeBranch));
        showProbability.setText(String.valueOf(trueProbability));
        return trueProbability;
    }
    public int excludeARandoFace(int i) {
        LinkedList<Integer> sides = new LinkedList<>();
        for (int a = 1; a < listOfUnfair.get(i).getFaces()+1; a++) {
            sides.add(a);
        }
        int ind = sides.indexOf(listOfUnfair.get(i).getFaceProb());
        sides.remove(ind);
        int randoNum = (int) (Math.random()*(listOfUnfair.get(i).getFaces()-1));
        return sides.get(randoNum);
    }
    public void setDiceList(LinkedList<UnfairDice> d) {
        if (d == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("No Dice Selected");
            alert.setContentText("There is no dice to be rolled!");

            alert.showAndWait();
        }else {
            listOfUnfair = d;
            listOfDice.setItems(FXCollections.observableList(listOfUnfair));
        }
    }
    @FXML
    public void goToComparisonMode() throws IOException {
        MainProbabilityApp.switchToTwoDiceComparisonView(listOfUnfair);
    }
    @FXML
    public void goBack() throws IOException {
        MainProbabilityApp.switchToDiceView();
    }
    public void initialize() {
        numOfFaces.setCellValueFactory(new PropertyValueFactory<>("faces"));
        probabilityForList.setCellValueFactory(new PropertyValueFactory<>("prob"));
        facesOfRolled.setCellValueFactory(new PropertyValueFactory<>("numOfFace"));
        faceNumber.setCellValueFactory(new PropertyValueFactory<>("howManyFaces"));
        probabilityForRowed.setCellValueFactory(new PropertyValueFactory<>("probability"));
    }
}
