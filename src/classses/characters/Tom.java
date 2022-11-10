package classses.characters;

public class Tom {
    int health;

    public Tom(int health) {
        this.health = health;
    }

    //encapsulation
    // Both methods used for decreasing Toms health depending on correct/incorrect answer
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
