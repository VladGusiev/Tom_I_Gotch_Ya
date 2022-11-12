package classses.game;

import classses.characters.Player;
import classses.characters.Tom;

public class EasyGame extends GameLoop {

    public EasyGame(Tom tom, Player player) {
        super(tom, player);
        this.TomHPDecrementAmount = 25;
        this.TomHPIncrementAmount = 25;

        this.PlayerMoneyIncrementAmount = 25;
        this.PlayerMoneyDecrementAmount = 25;

        this.PointsCorrectIncrementAmount = 25;
    }
}
