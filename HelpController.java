package com.example.probabilitysim;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.util.ArrayList;

public class HelpController {
    @FXML
    private ListView things;
    @FXML
    private TextArea field;
    private ObservableList list;
    @FXML
    private Button backButton;

    public void initialize(){
        ObservableList<String> a = FXCollections.observableArrayList(
                "Dice", "Marble", "Cards", "Spinner", "Lottery", "Math Tools", "Helpful Websites");
        things.setItems(a);
        list = a;
    }
    public void onClick(){
        int i = things.getSelectionModel().getSelectedIndex();
        if(list.get(i).equals("Dice")) {
            field.setText("There is a unfair button. Press it if you wish to add in an unfair die otherwise, only a fair die will be made\n" +
                    "There is only a comparison for multi dice roll, none for single. (if wish to do so, put a fair die into multi dice roll)\n" +
                    "Main view: there are three tables, top left to view all of your fair die that have been created, top right to view all of your unfair die that have been created, bottom is to view all of the die that have been selected.\n" +
                    "There is a text on top saying which die has been selected if any. This will be the only die that will be inserted into the single roll page\n" +
                    "There is a clear selected die if one needed to refresh \n" +
                    "Inside of the multi dice roll, there is a button that will take all of the dice selected and graph the rolls made.\n");
        } else if (list.get(i).equals("Marble")){
            field.setText("Allows you to pick a number of red, blue, and green marbles and"+System.getProperty("line.separator")+
                          "see the probability percentage of picking one.");
        } else if (list.get(i).equals("Cards")){
            field.setText("Outputs the probability of getting a certain card given the size of the deck and how many cards of each in the deck \n" +
                    "There is a visual representation of the cards if you click on the view current deck. Here you can see all your cards in a shuffled order and the probability of getting the card you landed on. \n");
        } else if (list.get(i).equals("Spinner")){
            field.setText("How to play: \n" +
                    "Choose a color from the drop box, and press add to add a color\n" +
                    "Choose a color in the drop box and press remove to remove a color\n" +
                    "Press add more than once to add more of one color to the spinner\n" +
                    "Press spin to spin: the chosen color will apereaded highlighted in white.\n");
        } else if (list.get(i).equals("Lottery")){
            field.setText("How to play:\n" +
                    "You must only select 6 numbers between 1 and 40.\n" +
                    "No two numbers can be the same.\n" +
                    "If all six numbers match those of the winning card and if the numbers are the same as those in the winning card, you win.\n" +
                    "\n");
        } else if (list.get(i).equals("Math Tools")){
            field.setText("f");
        } else if (list.get(i).equals("Helpful Websites")){
            field.setText("Here are some websites in case you need help with the overall"+System.getProperty("line.separator")+
                          "concepts of probability:");
        }
    }
    public void backClick() throws IOException {
        HelloApplication.switchToHelloView();
    }
}
