package com.example.probabilitysim;

import java.util.HashMap;
public class Spinner {

    public static void main(String[] args){
        Spinner spinnerOne = new Spinner();
        spinnerOne.addSection("orange");
        spinnerOne.addSection("orange");
        spinnerOne.addSection("red");
        spinnerOne.addSection("green");
        spinnerOne.addSection("purple");
        spinnerOne.addSection("yellow");
        spinnerOne.addSection("blue");
        spinnerOne.removeSection("orange");
        System.out.println(spinnerOne.spin());
        System.out.println(spinnerOne.theoreticalProb("green", 1));


    }

    int numOfSection = 0;
    HashMap<String, Integer> sections = new HashMap<>();

    public String spin(){
        int numSpun = (int) (Math.random() * numOfSection) + 1;
        int counterVariable = 0;
        for(String s : sections.keySet()){
            counterVariable += sections.get(s);
            if (counterVariable >= numSpun) return s;
        }
        return null;
    }

    public void addSection(String color) {
        if (sections.containsKey(color)) {
            numOfSection++;
            sections.put(color, sections.get(color) + 1);

        } else {
            numOfSection++;
            sections.put(color, 1);
        }
        //Add the color to your map with its corresponding percentage
        //Update the other colors' percentages (because you have more sections technically)
    }
    public void removeSection(String color) {
        if (sections.containsKey(color)) {
            numOfSection -= sections.get(color);
            sections.remove(color);
            //Add the color to your map with its corresponding percentage
            //Update the other colors' percentages (because you have more sections technically)
        }else{
            throw new IllegalArgumentException("Color not found.");
        }
    }



    public boolean hasSection(String color) {
        return sections.containsKey(color);
    }


    public double theoreticalProb(String color, int numOfOccurrences) {
        //based on percentage of coverage of the color, return likelihood of landing on that color x times
        //formula is going to be *percentage*^numOfOccurrences
        return Math.pow((double) sections.get(color)/numOfSection, numOfOccurrences);
    }
}
