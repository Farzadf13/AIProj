package com.farz.board;

import com.farz.utils.*;

/**
 * Created by farzadfallahi on 11/18/15.
 */

public class Board {
    public BoardSquareState[][] boardSquareStates;

    public Board() {
        boardSquareStates = new BoardSquareState[3][3];
        for (int i=0; i<3; i++)
            for (int j=0; j<3; j++)
                boardSquareStates[i][j] = BoardSquareState.EMPTY;
    }

    private BoardSquareState getBoardState(Move pos) {
        return this.boardSquareStates[pos.x][pos.y];
    }

    public boolean doMove(Move pos, Turn turn) {
        if (!isValidMove(pos, turn))
            return false;

        this.putMove(pos, turn);
        return true;
    }

    public void putMove(Move pos, Turn turn) {
        this.boardSquareStates[pos.x][pos.y] = Utils.turnToBoardSquareState(turn);
    }

    public boolean isValidMove(Move pos, Turn turn) {
        if (this.boardSquareStates[pos.x][pos.y] != BoardSquareState.EMPTY)
            return false;
        return true;
    }

    public void printToConsole() {
        for (int i=0; i<3; i++) {
            System.out.println("+-+-+-+");
            for (int j = 0; j < 3; j++) {
                System.out.print("|");
                System.out.print(Utils.boardSquareStateToString(this.boardSquareStates[i][j]));
            }
            System.out.println("|");
        }
        System.out.println("+-+-+-+");
    }
}
