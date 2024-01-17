package com.example.probabilitysim;

public class SpinnerSection {
    public String name;

    public SpinnerSection(String n){
        name=n;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return name;
    }
}
