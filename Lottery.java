package com.example.probabilitysim;

import java.util.Scanner;


public class Lottery {
    int numOne;
    int numTwo;
    int numThree;
    int numFour;
    int numFive;
    int numSix;
    public Lottery(int numOne, int numTwo, int numThree, int numFour, int numFive, int numSix) {
        this.numOne = numOne;
        this.numTwo = numTwo;
        this.numThree = numThree;
        this.numFour = numFour;
        this.numFive = numFive;
        this.numSix = numSix;
    }


//    public static void main(String[] args) {
//
////        System.out.println(ticket);
////        System.out.println(theoreticalProb(6));
//////        System.out.println(unfairness(ticket));
//    }

    @Override
    public String toString() {
        return " " + numOne + " " + numTwo + " " + numThree + " " + numFour + " " + numFive + " " + numSix;
    }


    //COMMITTED AND PUSHED
//    public boolean play() {
//        Lottery lottery = new Lottery();
//        for (int i = 0; i < 6; i++) {
//            System.out.println("type in a number between 1 and 40");
//
//            }
//        System.out.println("type in six numbers between 1 and 40, separated by a space.");
//    Scanner keyboard = new Scanner(System.in);
//    String[] nums = keyboard.next().split(" ");
//    Lottery lottery = new Lottery(Integer.parseInt(nums[0]), Integer.parseInt(nums[1]), Integer.parseInt(nums[2]), Integer.parseInt(nums[3]), Integer.parseInt(nums[4]), Integer.parseInt(nums[5]));

//        if (winPlay(lottery) == true) {
//            System.out.println("You won!");
//            return true;
//        } else {
//            System.out.println("You Lost.");
//            return false;
//        }
//    }

    // need to make one unfairness have fewer spaces

    public boolean winPlay() {
        Lottery correctTicket = new Lottery(6, 3, 17, 2, 4, 23);
        return this.equals(correctTicket);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Lottery) {
            if (numOne == ((Lottery) obj).numOne &&
                    numTwo == ((Lottery) obj).numTwo &&
                    numThree == ((Lottery) obj).numThree &&
                    numFour == ((Lottery) obj).numFour &&
                    numFive == ((Lottery) obj).numFive &&
                    numSix == ((Lottery) obj).numSix) {
                return true;
            }
        } return false;
    }
    //unfairness where one spot is always wrong, or one spot is always right.
    //unfairness where there is either one less spot or one more spot than usual.

    public boolean unFairness(Lottery ticket) {
        if (ticket instanceof Lottery) {
            if (numOne == ticket.numOne &&
                    numTwo == ticket.numTwo &&
                    numThree == ticket.numThree &&
                    numFour == ticket.numFour &&
                    numFive == ticket.numFive) {
                return true;
            }

        }
        return false;
    }


    public static double theoreticalProb(int numOfNums) {
        return (double) MathTools.factorials(numOfNums - 6) / (double) MathTools.factorials(numOfNums);
    }

    //check this method may not work
    public static double unfairProb(int numOfNums) {
        return (double) MathTools.factorials(numOfNums - 5) / (double) MathTools.factorials(numOfNums);
    }

//        public Lottery( int numOne, int numTwo, int numThree, int numFour, int numFive, int numSix){
//            this.numOne = numOne;
//            this.numTwo = numTwo;
//            this.numThree = numThree;
//            this.numFour = numFour;
//            this.numFive = numFive;
//            this.numSix = numSix;
//
//
//        }

//        public boolean actualProb ( double numOfPlays){
//            {
//                double NumOfWins = 0;
//                for (int i = 0; i < NumOfWins; i++) {
//                    Lottery.toss();
//                    if (Lottery.getIsHeads()) {
//                        NumOfWins++;
//                    }
//                }
//                return NumOfWins / numOfPlays;
//            }
//        }
//        int ticket;


}





