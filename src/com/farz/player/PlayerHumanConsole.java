package com.farz.player;

import com.farz.board.BoardSquareState;
import com.farz.utils.*;
import java.util.Scanner;

/**
 * Created by farzadfallahi on 11/19/15.
 */
public class PlayerHumanConsole extends AbstractPlayer {

    public PlayerHumanConsole(Turn player_turn) {
        super(player_turn);
    }

    @Override
    public Move prepMove() {
        System.out.println("This is the current board:");
        this.mainBoard.printToConsole();
        System.out.println("It is " + Utils.turnToString(this.playerTurn) + "'s Turn");

        Scanner reader = new Scanner(System.in);

        int inp = -1;
        while (inp < 0 || inp > 8) {
            System.out.println("Enter your move as a number in [0, 8]:");
            inp = reader.nextInt();
        }

        return new Move(inp/3, inp%3);
    }
}
