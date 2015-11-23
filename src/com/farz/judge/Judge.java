package com.farz.judge;

import com.farz.board.Board;
import com.farz.board.BoardSquareState;
import com.farz.player.AbstractPlayer;
import com.farz.player.PlayerAIDumb;
import com.farz.player.PlayerHumanConsole;
import com.farz.utils.Move;
import com.farz.utils.Turn;
import com.farz.utils.Utils;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by farzadfallahi on 11/19/15.
 */

public class Judge {

    private AbstractPlayer[] players;
    private Board board;

    public Judge() {
        this.board = new Board();
        this.players = new AbstractPlayer[Turn.COUNT.ordinal()];

        players[0] = new PlayerHumanConsole(Turn.X);
        players[1] = new PlayerAIDumb(Turn.O);
    }

    public void startGame() {
        int playerCount = Turn.COUNT.ordinal();
        int player = 0;

        Move move;
        Turn turn;

        while (!this.isGameDone(board)) {
            move = players[player].prepMove();
            turn = Turn.values()[player];

            if (!board.doMove(move, turn))
                continue;

            for (int i=0; i<playerCount; i++)
                players[i].updateBoard(move, turn);

            player = (player + 1) % playerCount;
        }
        Turn winner = getWinner(board);
        System.out.println("Winner is " + Utils.turnToString(winner) + "!!");
        board.printToConsole();
    }

    public boolean isGameDone(Board board) {
        Turn winner = this.getWinner(board);
        if (winner == null)
            return false;
        return true;
    }

    public Turn getWinner(Board board) {
        boolean all_same;

        // horizontal lines:
        for (int i=0; i<3; i++) {
            all_same = (board.boardSquareStates[i][0] != BoardSquareState.EMPTY);
            for (int j = 0; j<2; j++)
                all_same &= (board.boardSquareStates[i][j] == board.boardSquareStates[i][j+1]);
            if (all_same)
                return Utils.boardSquareStateToTurn(board.boardSquareStates[i][0]);
        }

        // vertical lines:
        for (int i=0; i<3; i++) {
            all_same = (board.boardSquareStates[i][0] != BoardSquareState.EMPTY);
            for (int j = 0; j<2; j++)
                all_same &= (board.boardSquareStates[i][j] == board.boardSquareStates[i][j+1]);
            if (all_same)
                return Utils.boardSquareStateToTurn(board.boardSquareStates[i][0]);
        }

        all_same = (board.boardSquareStates[0][0] != BoardSquareState.EMPTY);
        for (int i = 0; i<2; i++)
            all_same &= (board.boardSquareStates[i][i] == board.boardSquareStates[i+1][i+1]);
        if (all_same)
            return Utils.boardSquareStateToTurn(board.boardSquareStates[0][0]);

        all_same = (board.boardSquareStates[0][2] != BoardSquareState.EMPTY);
        for (int i = 0; i<2; i++)
            all_same &= (board.boardSquareStates[i][2-i] == board.boardSquareStates[i+1][1-i]);
        if (all_same)
            return Utils.boardSquareStateToTurn(board.boardSquareStates[0][2]);

        return null;
    }
}
