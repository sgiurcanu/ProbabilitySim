package com.example.probabilitysim;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.IOException.*;


public class HelloApplication extends Application {
    private static Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("ProbabilitySimulator");
        stage.setScene(scene);
        stage.show();
    }
    public static void switchToLotteryView() throws IOException{
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Lottery.fxml"));
        Parent root = loader.load();
        Scene myScene = new Scene(root);
        stage.setScene(myScene);
    }
    public static void switchToHelpView() throws IOException{
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("help-view.fxml"));
        Parent root = loader.load();
        Scene myScene = new Scene(root);
        stage.setScene(myScene);
    }
    public static void switchToCoinView() throws IOException{
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("coin-view.fxml"));
        Parent root = loader.load();
        Scene myScene = new Scene(root);
        stage.setScene(myScene);
    }
    public static void switchToMarbleView() throws IOException{
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("marble-view.fxml"));
        Parent root = loader.load();
        Scene myScene = new Scene(root);
        stage.setScene(myScene);
    }
    public static void switchToCardView() throws IOException{
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("card-view.fxml"));
        Parent root = loader.load();
        Scene myScene = new Scene(root);
        stage.setScene(myScene);
    }
    public static void switchToDiceView() throws IOException{
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("dice-view.fxml"));
        Parent root = loader.load();
        Scene myScene = new Scene(root);
        stage.setScene(myScene);
    }
    public static void switchToSpinnerView() throws IOException{
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Spinner.fxml"));
        Parent root = loader.load();
        Scene myScene = new Scene(root);
        stage.setScene(myScene);
    }

    public static void switchToHelloView() throws IOException{
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Parent root = loader.load();
        Scene myScene = new Scene(root);
        stage.setScene(myScene);
    }

    public static void main(String[] args) {
        launch();
    }
}