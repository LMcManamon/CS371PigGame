package edu.up.cs301.pig;

import edu.up.cs301.game.Game;
import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

import java.util.Random;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {

    /**
     * This ctor creates a new game state
     */
    private PigGameState CurGameState;
    public PigLocalGame() {
        //TODO  You will implement this constructor
         CurGameState = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        if(CurGameState.getTurn() == playerIdx){
            return true;
        }
        return false;
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        //TODO  You will implement this method
        if(action instanceof PigHoldAction)
        {
            if (CurGameState.getTurn() == 0){
                CurGameState.setPlayer0Score(CurGameState.getPlayer0Score() + CurGameState.getRunningTotal());
            }
            else if(CurGameState.getTurn() == 1){
                CurGameState.setPlayer1Score(CurGameState.getPlayer1Score() + CurGameState.getRunningTotal());
            }
            CurGameState.setRunningTotal(0);
            if(this.playerNames.length == 2){
                if(CurGameState.getTurn() == 0){
                    CurGameState.setTurn(1);
                }
                if(CurGameState.getTurn() == 1){
                    CurGameState.setTurn(0);
                }
            }
            return true;

        }
        else if(action instanceof PigRollAction){
            Random rn = new Random();
            int randomNum = rn.nextInt(6) + 1;
            CurGameState.setDieValue(randomNum);
            if(randomNum == 1){
                CurGameState.setRunningTotal(0);
                if(this.playerNames.length > 1) {
                    if (CurGameState.getTurn() == 0) {
                        CurGameState.setTurn(1);
                    }
                    if (CurGameState.getTurn() == 1) {
                        CurGameState.setTurn(0);
                    }
                }
                return true;
            }
            CurGameState.setRunningTotal(CurGameState.getRunningTotal() + randomNum);
            return true;
        }
        return false;
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        //TODO  You will implement this method
        PigGameState NewGameState;
        NewGameState = new PigGameState(CurGameState);
        p.sendInfo(NewGameState);
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        //TODO  You will implement this method
        if(CurGameState.getPlayer0Score() > 49){
            return this.playerNames[0] + " wins with " + CurGameState.getPlayer0Score() + " points.";
        }
        if(CurGameState.getPlayer1Score() > 49){
            return this.playerNames[1] + " wins with " + CurGameState.getPlayer1Score() + " points.";
        }
        return null;
    }

}// class PigLocalGame
