package com.example.probabilitysim;

import static java.lang.Math.*;

public class MathTools {
    public static double binomialPDF(int numFlips, int numSucFlips, double probabilitySuc){
        int c = factorials(numFlips)/(factorials((numFlips - numSucFlips))*factorials(numSucFlips));
        double probOfSuc = pow(probabilitySuc, numSucFlips);
        double probOfFail = pow((1-probabilitySuc), (numFlips-numSucFlips));
        return c*probOfSuc*probOfFail;
    }
    public static double hyperGeoPDF(int sucInPop, int numOfObserved, int numSize, int numDraw) {
        int top = combinatorics(sucInPop, numOfObserved)*combinatorics((numSize-sucInPop), (numDraw-numOfObserved));
        int bottom = combinatorics(numSize, numDraw);
        return top/bottom;
    }
    public static double hyperGeoMean(int sucInPop, int numOfObserved, int numSize){return (numOfObserved*numSize)/sucInPop;}
    public static double hyperGeoVarSquared(int sucInPop, int numOfObserved, int numSize){
        double first = (sucInPop-numOfObserved)/(sucInPop-1);
        double sec = numSize/sucInPop;
        double third = (sucInPop-numOfObserved)/sucInPop;
        return first*sec*third*numOfObserved;
    }
    public static double GeoPDF(int num, double p) {return Math.pow((p*(1-p)), (num-1));}
    public static double GeoMean(double p){return 1/p;}
    public static double GeoVarSquared(double p) {
        return (1-p)/(p*p);
    }
    public static double standardErrorOnePropZ(double probability, int num) {
        double top = probability*(1-probability);
        return Math.sqrt(top/num);
    }
    public static double zTest(double P, double realP, int num) {
        double top = P-realP;
        double bottom = standardErrorOnePropZ(realP, num);
        return top/bottom;
    }
    public static double standardErrorOnePropT(double num, int SD) {
        return SD/Math.sqrt(num);
    }
    public static double tTest(double mean, double realMean, double num, int SD) {
        return (realMean-mean)/standardErrorOnePropT(num, SD);
    }
    public static int combinatorics(int c, int b) {
        int top = factorials(c);
        int bottom = factorials(b)*(factorials(c-b));
        return top/bottom;
    }

    public static int factorials(int n) {
        //Olivia: fixed base case because 0! should equal one.
        int sum;
        if(n<0){
            throw new IllegalArgumentException();
        }
        if (n == 0 || n == 1) {
            return 1;
        }else {
            sum = n * factorials(n-1);
            return sum;
        }
    }
}


