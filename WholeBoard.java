package com.example.probabilitysim;
//new game method chnage method from the spots that have ones to zeros.
public class WholeBoard {


    public boolean threeInRow() {
//        for(int i = 0; i < bingoBoard.length; i++) {
//            for (int j = 0; j < bingoBoard[0].length; i++) {
//                if(if)
//                return true;
//            }
//        }
        if (tokens[0][0] == 1) {
            if (tokens[1][0] == 1 && tokens[2][0] == 1) return true;
            if (tokens[0][1] == 1 && tokens[0][2] == 1) return true;
            if (tokens[1][1] == 1 && tokens[2][2] == 1) return true;
        } else if (tokens[0][2] == 1) {
            if (tokens[1][2] == 1 && tokens[2][2] == 1) return true;
            if (tokens[1][1] == 1 && tokens[2][0] == 1) return true;
            if (tokens[0][1] == 1 && tokens[0][0] == 1) return true;

        } else if (tokens[2][2] == 1) {
            if (tokens[1][1] == 1 && tokens[0][0] == 1) return true;
            if (tokens[2][1] == 1 && tokens[2][0] == 1) return true;
            if (tokens[0][2] == 1 && tokens[1][2] == 1) return true;

        } else if (tokens[2][0] == 1) {
            if (tokens[1][1] == 1 && tokens[0][2] == 1) return true;
            if (tokens[1][0] == 1 && tokens[0][0] == 1) return true;
            if (tokens[2][1] == 1 && tokens[2][2] == 1) return true;

        } else if (tokens[1][0] == 1) {
            if (tokens[1][1] == 1 && tokens[1][2] == 1) return true;
            if (tokens[0][0] == 1 && tokens[2][0] == 1) return true;

        } else if (tokens[0][1] == 1) {
            if (tokens[1][1] == 1 && tokens[2][1] == 1) return true;
            if (tokens[0][0] == 1 && tokens[0][2] == 1) return true;

        }
        return false;
    }

    //    public boolean board(){
    int numCalled;

    int[][] bingoBoard = {{1, 7, 5}, {8, 3, 9}, {4, 2, 6}};
    int[][] tokens = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

    public boolean play() {
        numCalled = (int) (Math.random() * 19) + 1;
        for (int i = 0; i < bingoBoard.length; i++) {
            for (int j = 0; j < bingoBoard[0].length; i++) {
                if (numCalled == bingoBoard[i][j]) {
                    tokens[i][j] = 1;
                    threeInRow();
                    return true;
                }
            }
        }
        return false;

    }

    //theorectical probaility: how likely one is to win
    //actual probability: times won over times lost
    // make fmxl

//    public double probability(){
//        int timesWon= threeInRow()(int);
//        int timesLost = threeInRow()(int)- play()(int);
//
//        return threeInRow()(int)/play()(int);
//
//
//    }


}


