package classses.characters;

public class Player {
    private int money;
    public static int points = 0;

    public Player(int money) {
        this.money = money;
    }

    //encapsulation
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public final void resetMoney() {
        this.money = 100;
    }

    //overload
    //used when answering correct to questions (amount depends on situation difficulty)
    public void incrementMoney(int money) {
        this.money += money;
    }

    //used when answering wrong to any question
    public void incrementMoney() {
        this.money += 20;
    }
    public void decrementMoney(int amount) {this.money -= amount;}

    public void incrementPoints() { points += 10; }
    public static void resetPoints() {
        points = 0;
    }
}
