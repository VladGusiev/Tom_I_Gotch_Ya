package classses;

import classses.situations.Situation;
import classses.situations.Solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GameLoop {
    boolean isRunning;
    int difficulty;

    Scanner userAnswer = new Scanner(System.in);

    Situation situations = new Situation();
    Solution solutions = new Solution();

    public GameLoop(boolean isRunning, int difficulty) {
        this.isRunning = isRunning;
        this.difficulty = difficulty;
        this.Game();
    }

    private void Game() {
        String userSituation, userSolution;
        //Collecting all Solutions during turn
        List<String> inGameSolutions = new ArrayList<>();

        //generating random index for situations
        int randomSituationIndex = (int)(Math.random()*(this.situations.getListSize()));

        //saving string of chosen situation for future check
        userSituation = this.situations.getListElement(randomSituationIndex);

        //creating pull of solutions
        inGameSolutions.add(this.solutions.getListElement(randomSituationIndex)); // to get correct solution to the situation
        for (int i = 0; i < 2; i++) {
            int randomSolutionIndex = (int)(Math.random()*(this.solutions.getListSize()));
            inGameSolutions.add(this.solutions.getListElement(randomSolutionIndex)); //
        }

        //randomise order of solutions
        Collections.shuffle(inGameSolutions);

        System.out.println(userSituation);
        for (int i = 0; i < 3; i++) {
            System.out.println(i+1 + " " + inGameSolutions.get(i));
        }
        System.out.println("For submitting the answer for situation press the number corresponding the solution.");
        int solutionIndex = userAnswer.nextInt();


        userSolution = inGameSolutions.get(solutionIndex-1);


        System.out.println(userSituation);
        System.out.println(userSolution);

        //printing result
        System.out.println(this.situations.solutionCheck(userSituation, userSolution));
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}
