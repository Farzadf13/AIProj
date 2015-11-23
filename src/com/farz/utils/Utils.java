package com.farz.utils;

import com.farz.board.BoardSquareState;

/**
 * Created by farzadfallahi on 11/19/15.
 */
public class Utils {
    public static BoardSquareState turnToBoardSquareState(Turn turn) {
        switch (turn) {
            case X: return BoardSquareState.X;
            case O: return BoardSquareState.O;
            default: return BoardSquareState.EMPTY;
        }
    }

    public static Turn boardSquareStateToTurn(BoardSquareState boardSquareState) {
        switch (boardSquareState) {
            case X: return Turn.X;
            case O: return Turn.O;
            default: return null;
        }
    }

    public static String boardSquareStateToString(BoardSquareState boardSquareState) {
        switch (boardSquareState) {
            case X: return "X";
            case O: return "O";
            default: return " ";
        }
    }

    public static String turnToString(Turn turn) {
        switch (turn) {
            case X: return "X";
            case O: return "O";
            default: return "?";
        }
    }
}
