package com.example.probabilitysim;

import java.util.Scanner;

public class BullseyeController {
    private Bullseye game;

    public BullseyeController(Bullseye game) {
        this.game = game;
    }

    public double calculateWinningProbability(int skillLevel) {
        int wins = 0;

        for (int i = 0; i < 50; i++) {
            int currentScore = 0;
            int roundNumber = 0;

            while (currentScore < game.getTargetScore() && roundNumber<5) {
                int score = game.throwDart(skillLevel);
                currentScore += score;
                roundNumber++;
            }

            if (currentScore >= game.getTargetScore()) {
                wins++;
                currentScore = 0;
                roundNumber = 0;
            } else {
                currentScore = 0;
                roundNumber = 0;
            }
        }

        return (double) wins / 50;
    }

    public static void main(String[] args) {
        System.out.print("Do you want to play a fair or unfair game where your odds in winning is lower? ");
        Scanner input = new Scanner(System.in);
        int targetScore = 40;
        Bullseye game = new Bullseye(targetScore);
        BullseyeController controller = new BullseyeController(game);

        System.out.print("What is your skill level? (Enter a whole number from 1-10) : ");
        int skillLevel = input.nextInt();
        System.out.println();

        double winningProbability = controller.calculateWinningProbability(skillLevel);
        System.out.println("Simulator win rate after 50 games: " + winningProbability*100 + '%');
    }

}
