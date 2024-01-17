package com.example.probabilitysim;

import javafx.scene.control.TreeItem;

import java.util.List;

public class RolledDie {
    private int numOfFace;
    private int unfairFace;
    private int howManyFaces;
    private double probability;

    public RolledDie(int HMF, int NOF, int unfairFace, double prob) {
        this.numOfFace = NOF;
        this.unfairFace = unfairFace;
        this.howManyFaces = HMF;
        this.probability = prob;
    }

    public void setNumOfFace(int NOF) {
        this.numOfFace = NOF;
    }
    public void setUnfairFace(int uf) {
        this.unfairFace = uf;
    }

    public int getNumOfFace() {
        return numOfFace;
    }
    public int getUnfairFace() {
        return unfairFace;
    }
    public int getHowManyFaces() {return howManyFaces;}
    public void setHowManyFaces(int HMF) {this.howManyFaces = HMF;}
    public double getProbability() {return probability;}
    public void setProbability(double prob) {this.probability = prob;}

    @Override
    public String toString() {
        return "You got " + numOfFace + " with a probability of " + probability;
    }

}
