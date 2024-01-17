package com.example.probabilitysim;

public class UnfairDice  {
    private double prob;
    private int faces;
    private int faceProb;
    public UnfairDice(int f, double thisProb, int faceProb){
        this.prob = thisProb;
        this.faces = f;
        this.faceProb = faceProb;
    }
    public double getProb() {
        return prob;
    }
    public void setProb(double tempProb) {
        this.prob = tempProb;
    }
    public int getFaces() {return faces;}

    public void setFaces(int f) {this.faces = f;}
    public int getFaceProb() {return faceProb;}
    public void setFaceProb(int tp) {this.faceProb = tp;}
    @Override
    public String toString() {
        return ("A " + getFaces() + " sided die of an unfair probability of " + getProb());
    }

}
