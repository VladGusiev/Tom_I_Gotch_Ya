package classses.game;
import classses.characters.Player;
import classses.characters.Tom;
import classses.game.GameLoop;

import java.util.Scanner;

public class GameState {

    public static boolean isGameRunning; //uses to control if game still in progress
    char startGameInput; //used to track if player exiting main menu
    public static int difficultyInput; //used to track difficulty chosen by user
    Scanner userInput = new Scanner(System.in);


    //composition tom and player are dependent on this class
    Tom tom = new Tom(100);// default value;
    Player player = new Player(100); // dafault value

    public GameState() {
        //by default game start in main menu
        isGameRunning = false;

        System.out.println("Wellcome to game: Tom ,I Gotch Ya");
        System.out.println("In this game you will take care of your cat named Tom by solving his problems.");

        this.mainMenu();
    }

    protected void mainMenu() {

        //information for player, that he is in main menu
        System.out.println("--------------------------------------------");
        System.out.println("You are currently in Main Menu!");
        System.out.println("To start game, press 'S/s'!");
        System.out.println("If you want to exit, press 'E/e'");

        //Taking user inputs

        startGameInput = userInput.next().charAt(0);

        //waiting for player to press S to start game (Takes only uppercase S), otherwise repeats
        while (startGameInput != 'S' && startGameInput != 's') {
            if(startGameInput == 'E' || startGameInput == 'e') System.exit(1);
            System.out.println("Wrong input, press S to start game: ");
            startGameInput = userInput.next().charAt(0);
        }
        //Choosing difficulty
        this.chooseDifficulty();
    }

    public void chooseDifficulty() {
        System.out.println("Choose difficulty: \n'1' -> Easy\n'2' -> Medium\n'3' -> Hard");
        difficultyInput = userInput.nextInt();
        if (difficultyInput == 1) {
            this.tom.resetHealth();
            this.player.resetMoney();
            Player.resetPoints();
            System.out.println("You choose difficulty: Easy");
            isGameRunning = true;
            while (this.tom.getHealth() > 0 && isGameRunning) {
                new EasyGame(this.tom, this.player).Game();
            }
            this.mainMenu();
        } else if (difficultyInput == 2) {
            this.tom.setHealth(100);
            this.player.setMoney(100);
            Player.points = 0;
            System.out.println("You choose difficulty:Medium");
            isGameRunning = true;
            while (tom.getHealth() > 0 && isGameRunning) {
                new MediumGame(tom, player).Game(); //combination
            }
            this.mainMenu();
        } else if (difficultyInput == 3) {
            System.out.println("You choose difficulty:Hard");
            isGameRunning = true;
        } else chooseDifficulty();
    }
}
