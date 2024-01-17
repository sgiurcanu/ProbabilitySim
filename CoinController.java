//package com.example.probabilitysim;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.chart.PieChart;
//import javafx.scene.control.Button;
//import javafx.scene.control.TextField;
//import javafx.scene.shape.Circle;
//
//public class CoinController {
//
//    @FXML
//    Button flip;
//    @FXML
//    Circle frontCoin;
//    @FXML
//    Circle backCoin;
//    @FXML
//    TextField heads;
//    @FXML
//    TextField tails;
//
//
//    public void setColor() {
//        for (PieChart.Data data : colorWheel.getData()) {
//            data.getNode().setStyle("-fx-pie-color: " + data.getName());
//        }
//    }
//
//    public void onClickHandler(ActionEvent e) {
//        if (e.getSource() == flip) {
//            setColor();
//            String spunSection = Coin.flip();
//            for (PieChart.Data data : colorWheel.getData()) {
//                if (data.getName().equals(spunSection)) {
//                    System.out.println(data.getNode().getStyle());
//                    data.getNode().setStyle("-fx-pie-color: white");
//                    System.out.println(data.getNode().getStyle());
//                }
//
//
//            }
//        }
//    }
//}