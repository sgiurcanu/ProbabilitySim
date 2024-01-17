package com.example.probabilitysim;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;


public class MainProbabilityApp extends Application {
    private static Stage stage;
    private static Scene scene;
    @Override
    public void start(Stage stage) throws IOException {
        MainProbabilityApp.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(MainProbabilityApp.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        this.scene = scene;
        stage.setScene(scene);
        stage.show();
    }
    public static void switchToMarbleView() throws IOException{
        FXMLLoader loader = new FXMLLoader(MainProbabilityApp.class.getResource("marble-view.fxml"));
        Parent root = loader.load();
        Scene myScene = new Scene(root);
        stage.setScene(myScene);
    }
    public static void switchToCoinView() throws IOException{
        FXMLLoader loader = new FXMLLoader(MainProbabilityApp.class.getResource("coin-view.fxml"));
        Parent root = loader.load();
        Scene myScene = new Scene(root);
        stage.setScene(myScene);
    }
    public static void switchToCardView() throws IOException{
        FXMLLoader loader = new FXMLLoader(MainProbabilityApp.class.getResource("card-view.fxml"));
        Parent root = loader.load();
        Scene myScene = new Scene(root);
        stage.setScene(myScene);
    }
    public static void switchToDiceView() throws IOException{
        FXMLLoader loader = new FXMLLoader(MainProbabilityApp.class.getResource("Dice-List-View.fxml"));
        Parent root = loader.load();
        Scene myScene = new Scene(root);
        stage.setScene(myScene);
    }
    public static void switchToDiceAddView(boolean p) throws IOException{
        FXMLLoader loader = new FXMLLoader(MainProbabilityApp.class.getResource("Dice-Add.fxml"));
        Parent root = loader.load();
        DiceAddController dAController = loader.getController();
        dAController.setToggleButton(p);
        Scene myScene = new Scene(root);
        stage.setScene(myScene);
    }
    public static void addFairDiceToList(FairDice d) throws IOException{
        FXMLLoader loader = new FXMLLoader(MainProbabilityApp.class.getResource("Dice-List-View.fxml"));
        Parent root = loader.load();
        Scene myScene = new Scene(root);
        stage.setScene(myScene);
        DiceController dController = loader.getController();
        dController.tableFairAddRefresh(d);
    }
    public static void addUnfairDiceToList(UnfairDice d) throws IOException{
        FXMLLoader loader = new FXMLLoader(MainProbabilityApp.class.getResource("Dice-List-View.fxml"));
        Parent root = loader.load();
        Scene myScene = new Scene(root);
        stage.setScene(myScene);
        DiceController dController = loader.getController();
        dController.tableUnfairAddRefresh(d);
    }
    public static void switchToDiceDeleteViewFair(FairDice d) throws IOException{
        FXMLLoader loader = new FXMLLoader(MainProbabilityApp.class.getResource("Dice-Delete.fxml"));
        Parent root = loader.load();
        Scene myScene = new Scene(root);
        stage.setScene(myScene);
        DiceDeleteController ddController = loader.getController();
        ddController.getSelectedFairDie(d);
    }
    public static void switchToDiceDeleteViewUnfair(UnfairDice d) throws IOException{
        FXMLLoader loader = new FXMLLoader(MainProbabilityApp.class.getResource("Dice-Delete.fxml"));
        Parent root = loader.load();
        Scene myScene = new Scene(root);
        stage.setScene(myScene);
        DiceDeleteController ddController = loader.getController();
        ddController.getSelectedUnfairDie(d);
    }
    public static void switchToDiceRollMultiView(LinkedList<UnfairDice> d) throws IOException{
        FXMLLoader loader = new FXMLLoader(MainProbabilityApp.class.getResource("Dice-RollMulti.fxml"));
        Parent root = loader.load();
        Scene myScene = new Scene(root);
        stage.setScene(myScene);
        RollMultiDiceController RMDController = loader.getController();

        RMDController.setDiceList(d);
    }
    public static void switchToDiceRollOnceView(UnfairDice p) throws IOException{
        FXMLLoader loader = new FXMLLoader(MainProbabilityApp.class.getResource("Dice-RollOnce.fxml"));
        Parent root = loader.load();
        Scene myScene = new Scene(root);
        stage.setScene(myScene);
        RollSingleDiceController RSDController = loader.getController();
        RSDController.setDie(p);
    }
    public static void switchToTwoDiceComparisonView(LinkedList<UnfairDice> d) throws IOException{
        FXMLLoader loader = new FXMLLoader(MainProbabilityApp.class.getResource("TwoDiceComparison.fxml"));
        Parent root = loader.load();
        Scene myScene = new Scene(root);
        stage.setScene(myScene);
        DiceComparisonController DCController = loader.getController();
        DCController.setList(d);
    }
    public static void switchToSpinnerView() throws IOException{
        FXMLLoader loader = new FXMLLoader(MainProbabilityApp.class.getResource("Spinner.fxml"));
        Parent root = loader.load();
        Scene myScene = new Scene(root);
        stage.setScene(myScene);
    }
    public static void switchToDeckView(int num) throws IOException{
       DeckOfChoice.numOfEachType = num;
        FXMLLoader loader = new FXMLLoader(MainProbabilityApp.class.getResource("deck-view.fxml"));
        Parent root = loader.load();
        Scene myScene = new Scene(root);
        stage.setScene(myScene);
    }


    public static void switchToHelloView() throws IOException{
        stage.setScene(scene);
    }

    public static void main(String[] args) {
        launch();
    }
}