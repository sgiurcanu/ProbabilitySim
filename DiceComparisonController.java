package com.example.probabilitysim;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.LinkedList;

import static java.lang.Double.compare;

public class DiceComparisonController {
    @FXML
    private BarChart rows;
    @FXML
    private TableView storedDice;
    @FXML
    private TableColumn numFaces;
    @FXML
    private TableColumn probability;
    @FXML
    private Button back;
    @FXML
    private Button rowOne;
    @FXML
    private Button rowTen;
    @FXML
    private Button rowHundred;
    @FXML
    private Button clear;
    private XYChart.Series sOne = new XYChart.Series();
    private LinkedList<UnfairDice> listOfUnfair = new LinkedList<>();
    private LinkedList<LinkedList<Integer>> rolledSums = new LinkedList<>();

    private int totalSum;
    private int lowSum;
    private int count;

    public int rowOneNonSet() {
        double trueSum = 0.0;
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
            if (trueSum == 0.0) {
                trueSum = randoFace;
            }else {
                trueSum = trueSum + randoFace;
            }
        }
        return (int) trueSum;
    }
    public void setSumOfGraph() {
        for (int i = 0; i < listOfUnfair.size(); i++) {
            lowSum++;
            totalSum = totalSum + listOfUnfair.get(i).getFaces();

        }
        for (int i = lowSum; i < (totalSum+1); i++) {
            sOne.getData().add(new XYChart.Data(String.valueOf(i), 0));
        }
        rows.getData().addAll(sOne);
    }
    public void rowOnce() {
        int tempData = rowOneNonSet();
        int tempI = -1;
        int tempNum1 = 0;
        int tempNum2 = 0;
        System.out.println(tempData);
        if (rolledSums.size() == 0) {

            LinkedList<Integer> tempList = new LinkedList<>();
            tempNum1 = tempData;
            tempNum2 = 1;
            tempList.add(tempNum1);
            tempList.add(tempNum2);

            rolledSums.add(tempList);
            count = 0;
        }else {
            for (int i = 0; i < rolledSums.size(); i++) {
                if (rolledSums.get(i).get(0) == tempData) {
                    LinkedList<Integer> tempList = new LinkedList<>();
                    tempNum1 = rolledSums.get(i).get(0);
                    tempNum2 = rolledSums.get(i).get(1);
                    tempNum2++;
                    tempList.add(tempNum1);
                    tempList.add(tempNum2);

                    rolledSums.remove(i);
                    rolledSums.addFirst(tempList);

                    count = 0;
                    tempI = i;
                }else {
                    count++;
                }
                if (tempI != -1){
                    break;
                }
            }
        }
        if (count != 0) {
            LinkedList<Integer> tempList = new LinkedList<>();
            tempList.add(tempData);
            tempList.add(1);
            rolledSums.add(tempList);
            tempNum1 = tempData;
            tempNum2 = 1;

            count++;
        }

        sOne.getData().add(new XYChart.Data(String.valueOf(tempNum1), tempNum2));
        System.out.println(sOne.getData().get(1));
    }
    public void rowTen() {
        for (int i = 0; i < 10; i++) {
            rowOnce();
        }
    }
    public void rowHundred() {
        for (int i = 0; i < 100; i++) {
            rowOnce();
        }
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
    public void clear() {
        sOne.getData().clear();
        rows.getData().addAll(sOne);
    }
    public void backTouch() throws IOException {
        MainProbabilityApp.switchToDiceView();
    }
    public void setList(LinkedList<UnfairDice> UD) {
        this.listOfUnfair = UD;
        System.out.println(listOfUnfair);
        storedDice.setItems(FXCollections.observableList(listOfUnfair));
        setSumOfGraph();
    }
    public void initialize() {
        numFaces.setCellValueFactory(new PropertyValueFactory<>("faces"));
        probability.setCellValueFactory(new PropertyValueFactory<>("prob"));
    }
}
