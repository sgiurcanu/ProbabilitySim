package com.example.probabilitysim;

public class FairDice {
    private int faces;
    private double prob;
    public FairDice(int f) {
        this.faces = f;
        this.prob = (1.0/faces);
    }
    public int getFaces() {return faces;}
    public void setFaces(int f) {this.faces = f;}
    public void setProb(double p) {this.prob = p;}
    public double getProb() {return prob;}
    public String toString() {
        return ("A " + getFaces() + " sided die of a fair probability of " + ((double) 1/faces));
    }
}
