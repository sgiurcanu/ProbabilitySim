package com.example.probabilitysim;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

public class CardController {
    @FXML
    protected Button newButton;
    @FXML
    protected Text percentage;
    @FXML
    protected Button backButton;
    @FXML
    protected Button currentDeckView;


    public ArrayList<Card> deck = new ArrayList<Card>();

//    public boolean compare(int[] deck, int[] cards) {
//        for(int i = 0; i < deck.length; i++) {
//            for(int j = 0; j<cards.length; j++) {
//                if(deck[i] != cards[j]){
//                    continue;
//                } else if (deck[i] == cards[j]){
//                    if(i == deck.length-1) {
//                        return true;
//                    }
//                    break;
//                }
//            }
//            return false;
//        }
// }

    public static double chooseColor(int c) {
        if (c > 26 || c < 0) {
            return 0;
        }
        double prob = 1;
        for (int i = 0; i < c; i++) {
            prob *= ((26.0 - i) / (52.0 - i));
        }
        prob = Math.round(prob * 100000.0) / 100000.0;
        return prob;
    }

    public static double chooseSuit(int c) {
        if (c > 26 || c < 0) {
            return 0;
        }
        double prob = 1;
        for (int i = 0; i < c; i++) {
            prob *= ((13.0 - i) / (52.0 - i));
        }
        prob = Math.round(prob * 100000.0) / 100000.0;
        return prob;
    }

    public static double chooseRank(int c) {
        if (c > 26 || c < 0) {
            return 0;
        }
        double prob = 1;
        for (int i = 0; i < c; i++) {
            prob *= ((4.0 - i) / (52.0 - i));
        }
        prob = Math.round(prob * 100000.0) / 100000.0;
        return prob;

    }

    public void newClick() {
/*
        System.out.println("Please choose from the following options\n" +
                "1) Choose cards of the same color\n" +
                "2) Choose cards of the same suit\n" +
                "3) Choose cards of the same rank");
    Scanner kb = new Scanner(System.in);
        int user = Integer.parseInt(kb.nextLine());
        switch (user) {
            case 1:
                System.out.print("How many consecutive cards would you like to pull? :");
                System.out.println(chooseColor(Integer.parseInt(kb.nextLine())));
                break;
            case 2:
                System.out.print("How many consecutive cards would you like to pull? :");
                System.out.println(chooseSuit(Integer.parseInt(kb.nextLine())));
                break;
            case 3:
                System.out.print("How many consecutive cards would you like to pull? :");
                System.out.println(chooseRank(Integer.parseInt(kb.nextLine())));
                break;
            default:
                System.out.println("Not a valid option");

*/
        double num = 0.0;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("SetUp");
        alert.setHeaderText("Please Choose from the following options");
        alert.setContentText("Choose your option.");

        ButtonType buttonTypeOne = new ButtonType("Choose cards of the same color");
        ButtonType buttonTypeTwo = new ButtonType("Choose cards of the same suit");
        ButtonType buttonTypeThree = new ButtonType("Choose cards of the same rank");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        ButtonType buttonViewCurrent = new ButtonType("View Current Deck");

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeThree, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne) {
            // ... user chose "One"
            TextInputDialog dialog = new TextInputDialog("?");
            dialog.setTitle("SetUp");
            dialog.setHeaderText("How many consecutive cards would you like to pull?");
            dialog.setContentText("Please enter the number:");
            Optional<String> r = dialog.showAndWait();
            if (result.isPresent()) {
                num = chooseColor(Integer.parseInt(r.get()));
            }
        } else if (result.get() == buttonTypeTwo) {
            // ... user chose "Two"
            TextInputDialog dialog = new TextInputDialog("?");
            dialog.setTitle("SetUp");
            dialog.setHeaderText("How many consecutive cards would you like to pull?");
            dialog.setContentText("Please enter the number:");
            Optional<String> r = dialog.showAndWait();
            if (result.isPresent()) {
                num = chooseSuit(Integer.decode(r.get()));
            }
        } else if (result.get() == buttonTypeThree) {
            // ... user chose "Three"
            TextInputDialog dialog = new TextInputDialog("?");
            dialog.setTitle("SetUp");
            dialog.setHeaderText("How many consecutive cards would you like to pull?");
            dialog.setContentText("Please enter the number:");
            Optional<String> r = dialog.showAndWait();
            if (result.isPresent()) {
                num = chooseRank(Integer.decode(r.get()));
            }
        } else {
            // ... user chose CANCEL or closed the dialog
        }
       percentage.setText(Double.toString(num * 100) + "%");
        if (result.get() == buttonViewCurrent) {

        }


    }

    @FXML
    public void backClick() throws IOException {
        MainProbabilityApp.switchToHelloView();
    }

    @FXML
    public void deckViewClick() throws IOException {
        TextInputDialog dialog = new TextInputDialog("?");
        dialog.setTitle("SetUp");
        dialog.setHeaderText("Please provide the number of each type of card you would like: ");
        dialog.setContentText("Please enter the number:");
        Optional<String> r = dialog.showAndWait();

        int num = Integer.parseInt(r.get());
        MainProbabilityApp.switchToDeckView(num);
    }

}


