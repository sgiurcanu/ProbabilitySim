package com.example.probabilitysim;

import java.util.LinkedList;
import java.util.Random;

public class Dice {
    private LinkedList<FairDice> setOfFairDice;
    private LinkedList<UnfairDice> setOfUnfairDice;
    private double prob;
    private boolean fairness;

    public void isFair(String yN) {
        if (yN.equals("yes")) {
            this.fairness = true;
        } else if (yN.equals("no")) {
            this.fairness = false;
        }
    }
    public double calculateProbOf1(int numDie, int side, int numOfSuc) {
        if (numOfSuc < numDie || numOfSuc >= 0) {
            if (fairness = true) {
                return MathTools.binomialPDF(numDie, numOfSuc, (1 / side));
            } else {
                return MathTools.binomialPDF(numDie, numOfSuc, prob);
            }
        }else {
            return -1;
        }
    }



    public double calculateProbOfMultiFair(LinkedList<FairDice> dices) {
        double prob = 0;
        for (int i = 0; i < dices.size(); i++) {
            if (i == 0) {
                FairDice tempDice = dices.get(i);
                prob = calculateProbOf1(1, tempDice.getFaces(), 1);
            }
            FairDice tempDice = dices.get(i);
            prob = prob * calculateProbOf1(1, tempDice.getFaces(), 1);
        }
        return prob;
    }

    public double calculateProbOfMultiUnfair(LinkedList<UnfairDice> UnfairDices) {
        double prob = 0;
        for (int i = 0; i < UnfairDices.size(); i++) {
            if (i == 0) {
                UnfairDice tempDice = UnfairDices.get(i);
                prob = calculateProbOf1(1, tempDice.getFaces(), 1);
            }
            UnfairDice tempDice = UnfairDices.get(i);
            prob = prob * calculateProbOf1(1, tempDice.getFaces(), 1);
        }
        return prob;
    }

    public double calculateRandoMultiFair(int numRandoDie, int numRandoDieSide) {
        LinkedList<FairDice> dices = new LinkedList<>();
        for (int i = 0; i < numRandoDie; i++) {
            FairDice tempDie = new FairDice(0);
            for (int e = 0; e < numRandoDieSide; e++) {
                int randoSide = (int) (Math.random() * numRandoDieSide);
                tempDie.setFaces(randoSide);
                dices.add(tempDie);
            }
        }
        return calculateProbOfMultiFair(dices);
    }

    public double calculateRandoMultiUnfair(int numRandoDie, int numRandoDieSide, double prob) {
        LinkedList<UnfairDice> UnfairDices = new LinkedList<>();
        for (int i = 0; i < numRandoDie; i++) {
            UnfairDice tempDie = new UnfairDice(0, (Math.random() * prob), (int) (Math.random()*(numRandoDieSide-1) +1));
            for (int e = 0; e < numRandoDieSide; e++) {
                int randoSide = (int) (Math.random() * numRandoDieSide);
                tempDie.setFaces(randoSide);
                UnfairDices.add(tempDie);
            }
        }
        return calculateProbOfMultiUnfair(UnfairDices);
    }
}
