package com.example.probabilitysim;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class MarbleController {
 private List<Marble> marbles;
 @FXML
 private Text prob;
 @FXML
 private Button newButton;
 @FXML
 private Button done;

 public MarbleController() {
     marbles = new ArrayList<>();
 }
 public void initialize(){

 }

 public void addMarble(String color, int total) {
     Marble marble = new Marble(color,total);
     marbles.add(marble);
 }
 public double calculatesProb(String color) {
     int totalMarbles = 0;
     int colorMarbles = 0;

     for(Marble marble : marbles) {
         totalMarbles += marble.getTotal();
         if (marble.getColor().equalsIgnoreCase(color)) {
             colorMarbles += marble.getTotal();
         }
     }
     if (totalMarbles == 0) {
         return 0.0;
     } else {
         return (double) colorMarbles / totalMarbles;
     }
 }

public void main() {
    MarbleController controller = new MarbleController();
    Scanner scanner = new Scanner(System.in);
    /*
    System.out.println("Enter you total number of marbles: ");
    int totalMarbles = scanner.nextInt();
            scanner.nextLine();
    System.out.println("Enter the number of each color marbles:");

    System.out.print("Red: ");
    int redMarbles = scanner.nextInt();
    scanner.nextLine();
    controller.addMarble("red", redMarbles);

    System.out.print("Blue: ");
    int blueMarbles = scanner.nextInt();
    scanner.nextLine();
    controller.addMarble("blue", blueMarbles);

    System.out.print("Green: ");
    int greenMarbles = scanner.nextInt();
    scanner.nextLine();
    controller.addMarble("green", greenMarbles);

    System.out.print("Enter the color of the marble to calculate the probability: ");
    String marbleColor = scanner.nextLine();

    double probability = controller.calculatesProb(marbleColor);
    System.out.println("The probability of picking a " + marbleColor + " marble is: " + probability);

     */
    System.out.println("Do you want to play a fair or unfair game?");
    TextInputDialog dialog = new TextInputDialog("");
    dialog.setTitle("Marble Setup");
    dialog.setHeaderText("Please Enter the Number of Marbles");
    dialog.setContentText("Red:");
    Optional<String> result = dialog.showAndWait();
    if (result.isPresent()) {
        controller.addMarble("red", Integer.decode(result.get()));
    }
    dialog.setTitle("Marble Setup");
    dialog.setHeaderText("Please Enter the Number of Marbles");
    dialog.setContentText("Blue:");
    Optional<String> result2 = dialog.showAndWait();
    if (result.isPresent()) {
        controller.addMarble("blue", Integer.decode(result2.get()));
    }
    dialog.setTitle("Marble Setup");
    dialog.setHeaderText("Please Enter the Number of Marbles");
    dialog.setContentText("Green:");
    Optional<String> result3 = dialog.showAndWait();
    if (result.isPresent()) {
        controller.addMarble("green", Integer.decode(result3.get()));
    }
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Marble Setup");
    alert.setHeaderText("Enter the color of the marble to calculate the probability");
    alert.setContentText("Choose your option.");

    ButtonType buttonTypeOne = new ButtonType("Red");
    ButtonType buttonTypeTwo = new ButtonType("Blue");
    ButtonType buttonTypeThree = new ButtonType("Green");
    ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

    alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeThree, buttonTypeCancel);

    Optional<ButtonType> result5 = alert.showAndWait();
    Double probability = 0.0;
    if (result5.get() == buttonTypeOne){
        probability=controller.calculatesProb("red");
    } else if (result5.get() == buttonTypeTwo) {
        probability=controller.calculatesProb("blue");
    } else if (result5.get() == buttonTypeThree) {
        probability=controller.calculatesProb("green");
    } else {
        // ... user chose CANCEL or closed the dialog
    }
    prob.setText(Double.toString(probability));
}
    @FXML
    public void backClick() throws IOException {
        MainProbabilityApp.switchToHelloView();
    }
}



