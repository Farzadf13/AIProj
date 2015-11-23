package com.farz.player;

import com.farz.board.BoardSquareState;
import com.farz.utils.Move;
import com.farz.utils.Turn;
import com.farz.utils.Utils;

/**
 * Created by farzadfallahi on 11/20/15.
 */
public class PlayerAIDumb extends AbstractPlayer{
    public PlayerAIDumb(Turn player_turn) {
        super(player_turn);
    }

    @Override
    public Move prepMove() {
//            System.out.println("This is the current board:");
//            this.mainBoard.printToConsole();
//            System.out.println("It is " + Utils.turnToString(this.playerTurn) + "'s Turn");
        int i, j;
        for (i=0; i<3; i++)
            for (j=0; j<3; j++)
                if (mainBoard.boardSquareStates[i][j] == BoardSquareState.EMPTY)
                    return new Move(i, j);

        return null;
    }
}
