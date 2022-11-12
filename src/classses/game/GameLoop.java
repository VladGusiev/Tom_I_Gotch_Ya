package classses.game;

import classses.characters.Player;
import classses.characters.Tom;
import classses.situations.Situation;
import classses.situations.Solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static classses.game.GameState.isGameRunning;

public class GameLoop {
    Tom tom;
    Player player;
    Scanner userAnswer = new Scanner(System.in);
    Situation situations = new Situation();
    Solution solutions = new Solution();

    int TomHPDecrementAmount = 1;
    int TomHPIncrementAmount = 1;

    int PlayerMoneyIncrementAmount = 1;
    int PlayerMoneyDecrementAmount = 1;
    int PointsCorrectIncrementAmount = 1;


    protected GameLoop(Tom tom, Player player) {
        this.tom = tom;
        this.player = player;
    }

    protected void Game() {
        String userSituation;
        String userSolution;

        //Collecting all Solutions during turn
        List<String> inGameSolutions = new ArrayList<>();

        //preparingSituations
        //generating random index for situations
        int randomSituationIndex = (int)(Math.random()*(this.situations.getListSize()));
        //saving string of chosen situation for future check
        userSituation = this.situations.getListElement(randomSituationIndex);

        preparingSolutions(inGameSolutions, randomSituationIndex);


        printingInformation(this.tom, this.player);
        printingResults(userSituation, inGameSolutions);


        answerProcessing(userSituation, inGameSolutions);
        System.out.println("\n-----------------------------------");
    }

    protected void answerProcessing(String userSituation, List<String> inGameSolutions) {
        String userSolution;
        int solutionIndex = userAnswer.nextInt();
        userSolution = inGameSolutions.get(solutionIndex-1);
        if(this.situations.solutionCheck(userSituation, userSolution) == 1) {
            this.tom.incrementHealth(this.TomHPIncrementAmount);
            this.player.incrementMoney();
            Player.points += PointsCorrectIncrementAmount;
            this.player.decrementMoney(PlayerMoneyDecrementAmount);
        } else {
            this.tom.decrementHealth(this.TomHPDecrementAmount);
            this.player.incrementPoints();
            this.player.decrementMoney(PlayerMoneyDecrementAmount);
        }
        if(this.tom.getHealth() < 0 ) isGameRunning = false;
    }

    protected void printingInformation(Tom tom, Player player) {
        System.out.println("Points: " + Player.points);
        System.out.println("Tom health is: " + tom.getHealth() + "                  " + "Player money: " + player.getMoney());
    }

    protected void preparingSolutions(List<String> inGameSolutions, int randomSituationIndex) {
        //creating pull of solutions
        inGameSolutions.add(this.solutions.getListElement(randomSituationIndex)); // to get correct solution to the situation
        while (inGameSolutions.size() < 3) {
            int randomSolutionIndex = (int)(Math.random()*(this.solutions.getListSize()));
            if(inGameSolutions.contains(this.solutions.getListElement(randomSolutionIndex))) continue;
            inGameSolutions.add(this.solutions.getListElement(randomSolutionIndex));
        }
        //randomise order of solutions
        Collections.shuffle(inGameSolutions);
    }

    protected void printingResults(String userSituation, List<String> inGameSolutions) {
        //pringting Situation!
        System.out.println(userSituation);
        //printing solutions
        for (int i = 0; i < 3; i++) {
            System.out.println(i+1 + " " + inGameSolutions.get(i));
        }
        System.out.println("For submitting the answer for situation press the number corresponding the solution.");
    }
}
