package com.example.probabilitysim;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import static java.util.Collections.shuffle;

public class DeckOfChoice {
    private ArrayList<Card> deck;
    static int numOfEachType;
    private int indexInDeck = 0;
    @FXML
    ImageView backOfDeck;
    @FXML
    ImageView activeCard;
    @FXML
    Button nextCard;
    @FXML
    Button cardView;
    @FXML
    Button shuffleDeck;
    @FXML
    Button calcProb;
    @FXML
    private Text percentage;

    public void initialize() throws FileNotFoundException {
        createDeck(numOfEachType);
        shuffle(deck);
        backOfDeck.setImage(new Image(new FileInputStream("src/main/java/com/example/probabilitysim/cards/backcard.png")));

    }
    @FXML
    public void CardViewClick() throws IOException {
        MainProbabilityApp.switchToCardView();
    }

    @FXML
    public void ShuffleClick() throws FileNotFoundException {
        nextCard();
        shuffleDeck();
    }
    @FXML
    public void probClick() {
        calcProb(numOfEachType);

   }

    private void shuffleDeck() {
        shuffle(deck);
    }

    public void nextCard() throws FileNotFoundException {
        activeCard.setImage(getCard());
    }

    public Image getCard() throws FileNotFoundException {
        if (indexInDeck >= deck.size()) {
            indexInDeck = 0;
        }
        Card card = deck.get(indexInDeck++);
        return new Image(new FileInputStream("src/main/java/com/example/probabilitysim/cards/"+card.rank+"_of_"+card.suit+".png"));
    }

  @FXML
    public double calcProb(int numberOfEachType) {
       double probability = (double) numberOfEachType *((double) 1/ deck.size());
      percentage.setText(Double.toString(probability * 100) + "%");
        return probability;
    }


    public DeckOfChoice() {
        deck = new ArrayList<>();
    }

    public void createDeck(int numberOfEachType) {
        deck.clear();

        String[] ranks = {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};
        String[] suits = {"hearts", "diamonds", "clubs", "spades"};

        for (int i = 0; i < numberOfEachType; i++) {
            for (String rank : ranks) {
                for (String suit : suits) {
                    Card card = new Card(rank, suit);
                    deck.add(card);
                }
            }
        }
    }

    //public static void shuffle(ArrayList<Card> deck) {
   //     Collections.shuffle(deck);

  //  }
    public void printDeck() {
        System.out.println("Deck: " + deck);
    }

    public static void main(String[] args) {
        DeckOfChoice deckOfChoice = new DeckOfChoice();

        System.out.print("Enter the number of each type of card: ");
        int numberOfEachType = Integer.parseInt(getInput());

        deckOfChoice.createDeck(numberOfEachType);
        deckOfChoice.printDeck();
        int totalCards = deckOfChoice.deck.size();
        System.out.println("Total number of cards in the deck: " + totalCards);
    }

    private static String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static class Card {
        private String rank;
        private String suit;

        public Card(String rank, String suit) {
            this.rank = rank;
            this.suit = suit;
        }

        @Override
        public String toString() {
            return rank + " of " + suit;
        }
    }
}