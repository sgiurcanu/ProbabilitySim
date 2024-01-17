package com.example.probabilitysim;
import java.util.Random;

public class Bullseye {
    protected int targetScore;
    protected int actualScore;


    public Bullseye(int targetScore) {
        this.targetScore = targetScore;
        this.actualScore = 0; // Adjust the points based on your game rules
        // this.missedPoints = 4;
    }

    public int getTargetScore() {
        return this.targetScore;
    }

    public int getActualScore() {
        return this.actualScore;
    }

    public int throwDart(int skillLevel) {
        if(skillLevel>=1 && skillLevel<10){
            Random random = new Random();
            int score = random.nextInt(10 - skillLevel);
            actualScore += (score + skillLevel);
            return score + skillLevel;
        } else if(skillLevel<1) {
            skillLevel=1;
            Random random = new Random();
            int score = random.nextInt(10 - skillLevel);
            actualScore += (score + skillLevel);
            return score + skillLevel;
        } else if(skillLevel>=10) {
            skillLevel=10;
            actualScore += (skillLevel);
            return skillLevel;
        }
        return -1;
    }
}

