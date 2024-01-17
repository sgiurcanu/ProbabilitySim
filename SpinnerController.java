package com.example.probabilitysim;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;

import java.io.IOException;

public class SpinnerController {

    @FXML
    Button spin;
    @FXML
    PieChart colorWheel;
    @FXML
    Spinner spinner = new Spinner();
    @FXML
    Button addSection;
    @FXML
    Button removeSection;
    @FXML
    ComboBox sectionList;
    @FXML
    Label probability;
    @FXML
    Label output;
    @FXML
    Button calculate;
    @FXML
    Slider slider;

    @FXML
    Button backButton;

    public void probCalc(){
        String color = sectionList.getValue().toString();
        int numOfOccurences = (int)slider.getValue();
        output.setText(spinner.theoreticalProb(color, numOfOccurences) +"");
    }
    public void initialize(){
        String[] colors = {"yellow", "green", "blue", "red", "orange", "indigo", "violet"};
        sectionList.setItems( FXCollections.observableArrayList(colors));
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        setColor();


    }

    public void onClickHandler(ActionEvent e){
        if (e.getSource()== removeSection) {
            setColor();
            String section = sectionList.getValue().toString();
            for (int i = 0; i < colorWheel.getData().size(); i++) {
                if (colorWheel.getData().get(i).getName().equals(section)){
                    colorWheel.getData().remove(colorWheel.getData().get(i));
                    spinner.removeSection(section);
                }
            }
//            colorWheel.getData().remove(sectionList.getItems().remove(new PieChart.Data(section, spinner.sections.get(section))));
//            spinner.removeSection(section);
        }
        else if (e.getSource()== addSection) {
            String section = sectionList.getValue().toString();
            if (spinner.hasSection(section)) {
                for (PieChart.Data pieSection:
                        colorWheel.getData()) {
                    if (pieSection.getName().equals(section)){
                        pieSection.setPieValue(pieSection.getPieValue()+1);
                        spinner.addSection(section);
                    }
                }
            } else {
                spinner.addSection(section);
                colorWheel.getData().add(new PieChart.Data(section, spinner.sections.get(section)));
            }
            setColor();
        }else if (e.getSource()== spin) {
            setColor();
            String spunSection = spinner.spin();
            for (PieChart.Data data : colorWheel.getData()) {
                if (data.getName().equals(spunSection)) {
                    System.out.println(data.getNode().getStyle());
                    data.getNode().setStyle("-fx-pie-color: white");
                    System.out.println(data.getNode().getStyle());
                }
            }
        }
//        setColor();
    }
    //    public void listPick(ActionEvent e) {
//        sectionList.getValue();
//    }
    public void setColor() {
        for (PieChart.Data data : colorWheel.getData()) {
            data.getNode().setStyle("-fx-pie-color: " + data.getName());
        }
    }
    public void backButtonClick() throws IOException {
        HelloApplication.switchToHelloView();
    }
}
//
