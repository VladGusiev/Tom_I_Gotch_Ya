package classses.situations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    int difficulty;
    List<String> solutions = new ArrayList<>();

    public Solution() {
        this.solutions.add("Wash him");
        this.solutions.add("Take Tom to the doctor");
        this.solutions.add("Play with him");
        this.solutions.add("Wash him");
        this.solutions.add("Spend some time with him");
        this.solutions.add("Put him some food");
        this.solutions.add("Pay more attention to check if he is all-right");
        this.solutions.add("Leave him alone");
        this.solutions.add("Buy him a new toy");
        this.solutions.add("Give him some medicine");
        this.solutions.add("Go to work");
        this.solutions.add("Ignore him");
    }


    public int getListSize() {
        return this.solutions.size();
    }

    public String getListElement(int index) {
        return this.solutions.get(index);
    }

    //encapsulation
    public List<String> getSituations() {
        return solutions;
    }

    public void setSolutions(List<String> solutions) {
        this.solutions = solutions;
    }
}
