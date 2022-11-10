package classses;
import java.util.Scanner;

public class GameState {

    public boolean isGameRunning; //uses to control if game still in progress
    char startGameInput; //used to track if player exiting main menu
    int difficultyInput; //used to track difficulty chosen by user
    Scanner userInput = new Scanner(System.in);

    public GameState() {
        //by default game start in main menu
        this.isGameRunning = false;

        System.out.println("Wellcome to game: Tom ,I Gotch Ya");
        System.out.println("In this game you will take care of your cat named Tom by solving his problems.");

        this.mainMenu();
    }

    protected void mainMenu() {

        //information for player, that he is in main menu
        System.out.println("--------------------------------------------");
        System.out.println("You are currently in Main Menu!");
        System.out.println("To start game, press 'S'!");

        //Taking user inputs

        startGameInput = userInput.next().charAt(0);

        //waiting for player to press S to start game (Takes only uppercase S), otherwise repeats
        while (startGameInput != 'S') {
            System.out.println("Wrong input, press S to start game: ");
            startGameInput = userInput.next().charAt(0);
        }
        //Choosing difficulty
        this.chooseDifficulty();
    }

    public void chooseDifficulty() {
        System.out.println("Choose dificulty: \n'1' -> Easy\n'2' -> Medium\n'3' -> Hard");
        difficultyInput = userInput.nextInt();
        if (difficultyInput == 1) {
            System.out.println("Easy");
            this.isGameRunning = true;
        } else if (difficultyInput == 2) {
            System.out.println("Medium");
            this.isGameRunning = true;
        } else if (difficultyInput == 3) {
            System.out.println("Hard");
            this.isGameRunning = true;
        } else chooseDifficulty();

        GameLoop gameStart = new GameLoop(this.isGameRunning, 1);
    }

    //encapsulation
    public boolean isGameRunning() {
        return isGameRunning;
    }

    public void setGameRunning(boolean gameRunning) {
        isGameRunning = gameRunning;
    }
}
