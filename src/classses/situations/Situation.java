package classses.situations;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Situation {
    //represents difficulty of the queston -> 1 = Easy, 2 = Medium, 3 = Hard;
//    int difficulty;

    List<String> situations = new ArrayList<>();

    //aggregation
    Solution solutions = new Solution();


    public Situation() {
        this.situations.add("You notice that Tom is dirty:");
        this.situations.add("You hear Tom is coughing:");
        this.situations.add("You see Tom bored:");
        this.situations.add("You notice that Tom is dirty:");
        this.situations.add("While you were walking around Tom you find that he is angry:");
        this.situations.add("Tom comes to you to show you, that he hungry:");
        this.situations.add("You put a food near Tom but doesn't want to eat it, but still seems hungry:");
    }

    public String solutionCheck(String situation, String solution) {
//        System.out.println( this.situations.size());
//        System.out.println(situation);
        int solutionIndex = 0, situationIndex = 0;
        //get indexes of solution passed and situation, if indexes are the same, answer is correct (in code they are arranged accordingly)
        for(int i = 0; i < this.situations.size(); i++) {
//            System.out.println(i);
//            System.out.println(this.situations.get(i));
//            System.out.println(situation);
//            System.out.println(this.situations.get(i).equals(situation));
            if(this.situations.get(i).equals(situation)) {
//                System.out.println(this.situations.get(i));
//                System.out.println(situation);
//                System.out.println("----");
                situationIndex = i;
            }
        }
        for(int i = 0; i < this.solutions.getListSize(); i++) {
            System.out.println(i);
            if(this.solutions.getListElement(i).equals(solution)) {
                solutionIndex = i;
            }
        }
        System.out.println(solutionIndex);
        System.out.println(situationIndex);
        if(situationIndex == solutionIndex) {
            return "Correct";
        } else {
            return "Wrong";
        }
    }

    public int getListSize() {
        return this.situations.size();
    }

    public String getListElement(int index) {
        return this.situations.get(index);
    }

    public List<String> getSituations() {
        return situations;
    }

    public void setSituations(List<String> situations) {
        this.situations = situations;
    }
}
