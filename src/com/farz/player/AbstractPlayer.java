package com.farz.player;

import com.farz.board.*;
import com.farz.utils.*;

/**
 * Created by farzadfallahi on 11/18/15.
 */
public abstract class AbstractPlayer {
    protected Turn playerTurn;
    protected Board mainBoard;

    public AbstractPlayer(Turn player_turn) {
        this.playerTurn = player_turn;
        this.mainBoard = new Board();
    }

    public void updateBoard(Move pos, Turn turn) {
        this.mainBoard.putMove(pos, turn);
    }

    public abstract Move prepMove();
}
