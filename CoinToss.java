package com.example.probabilitysim;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.io.IOException;

public class CoinToss {

// coin toss:
// coin object
// toss method - use math.random to determine the numbers of flips it makes before it stops.
// - print out whether the user flipped heads or tails
//heads instance variable
//tails instance variable
//scene builder
//- toss button
    @FXML
    private Button tossButton;
    @FXML
    private Text answer;
    public double actualprob(int numOfFlips){
        int heads=0;
        for(int i = 0; i< numOfFlips; i ++){
            Coin coin = new Coin();
            coin.toss();
            if(coin.getIsHeads()){
                heads ++;
            }
        }
        return (double)heads/numOfFlips;
    }
    public void backButton() throws IOException {
        MainProbabilityApp.switchToHelloView();
    }


public Coin coin = new Coin();

public void tossButton() {
        answer.setText(coin.toss());

    // can implement this after we have a button.
//    testing hfaifhdaso
}



}
class Coin{
    private boolean isHeads;

    public void setIsHeads( boolean isHeads){
        this.isHeads = isHeads;
    }
    public boolean getIsHeads(){
        return this.isHeads;
    }

    public Coin(){
        isHeads = true;
    }

    public String toss(){
        int max = 15;
        int min = 5;
        int range = max-min+1;
        int flipNum = (int)(Math.random() * range) + min;
        if(flipNum % 2 == 0){
            return "Heads";
        }else{
            return "Tails";
        }


    }

}

//class Probability{
//
//    private int numOfFlips;
//    private int outCome = 10;
//
//    public void setNumOfFlips(int numOfFlips){
//        this.numOfFlips = numOfFlips;
//    }
//    public int getNumOfFlips(){
//        return numOfFlips;
//    }
//    public double probFlip(Coin coin){
//        this.getNumOfFlips();
//
//        if(outCome/numOfFlips;){
//
//        }
//    }
//
//
//}