package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

/**
 * Created by mcmanamo18 on 2/24/2016.
 */
public class PigGameState extends GameState{
    private int turn=0;
    private int player0Score=0;
    private int player1Score=0;
    private int runningTotal=0;
    private int dieValue=1;

    public PigGameState() {
    }

    public PigGameState(PigGameState state) {
        this.turn = state.getTurn();
        this.player0Score = state.getPlayer0Score();
        this.player1Score = state.getPlayer1Score();
        this.runningTotal = state.getRunningTotal();
        this.dieValue = state.getDieValue();
    }

    public int getTurn() {

        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public int getPlayer0Score() {
        return player0Score;
    }

    public void setPlayer0Score(int player0Score) {
        this.player0Score = player0Score;
    }

    public int getPlayer1Score() {
        return player1Score;
    }

    public void setPlayer1Score(int player1Score) {
        this.player1Score = player1Score;
    }

    public int getRunningTotal() {
        return runningTotal;
    }

    public void setRunningTotal(int runningTotal) {
        this.runningTotal = runningTotal;
    }

    public int getDieValue() {
        return dieValue;
    }

    public void setDieValue(int dieValue) {
        this.dieValue = dieValue;
    }
}
