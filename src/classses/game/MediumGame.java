package classses.game;

import classses.characters.Player;
import classses.characters.Tom;

import java.util.Collections;
import java.util.List;

//TODO update, that solutions and situations will be harder in this mode.

public class MediumGame extends GameLoop{

    protected MediumGame(Tom tom, Player player) {
        super(tom, player);
        this.TomHPDecrementAmount = 35;
        this.TomHPIncrementAmount = 20;

        this.PlayerMoneyIncrementAmount = 25;
        this.PlayerMoneyDecrementAmount = 20;

        this.PointsCorrectIncrementAmount = 25;
      }

    //changed number of possible solutions to 4
    @Override
    protected void preparingSolutions(List<String> inGameSolutions, int randomSituationIndex) {
        //creating pull of solutions
        inGameSolutions.add(this.solutions.getListElement(randomSituationIndex)); // to get correct solution to the situation
        while (inGameSolutions.size() < 4) {
            int randomSolutionIndex = (int)(Math.random()*(this.solutions.getListSize()));
            if(inGameSolutions.contains(this.solutions.getListElement(randomSolutionIndex))) continue;
            inGameSolutions.add(this.solutions.getListElement(randomSolutionIndex));
        }
        //randomise order of solutions
        Collections.shuffle(inGameSolutions);
    }

    @Override
    protected void printingResults(String userSituation, List<String> inGameSolutions) {
        //pringting Situation!
        System.out.println(userSituation);
        //printing solutions
        for (int i = 0; i < 4; i++) {
            System.out.println(i+1 + " " + inGameSolutions.get(i));
        }
        System.out.println("For submitting the answer for situation press the number corresponding the solution.");
    }
}
