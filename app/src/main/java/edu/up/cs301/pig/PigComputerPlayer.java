package edu.up.cs301.pig;

import java.util.Random;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.util.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {

    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        // TODO  You will implement this method
        if(info instanceof PigGameState) {
            PigGameState State = (PigGameState) info;
            if (((PigGameState) info).getTurn() != this.playerNum) {
                return;
            }

            Random rn = new Random();
            int randomNum = rn.nextInt(2);
            if (randomNum == 0) {
                PigRollAction NewRollAction = new PigRollAction(this);
                this.game.sendAction(NewRollAction);
            } else if (randomNum == 1) {
                PigHoldAction NewHoldAction = new PigHoldAction(this);
                this.game.sendAction(NewHoldAction);
            }

        }

    }//receiveInfo

}
