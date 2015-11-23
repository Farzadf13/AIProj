package com.farz.utils;

/**
 * Created by farzadfallahi on 11/19/15.
 */
public class Move {
    public int x;
    public int y;

    public Move(int _x, int _y) {
        if (!isValid(_x, _y))
            return;
        this.x = _x;
        this.y = _y;
    }

    public boolean isValid() {
        return isValid(this.x, this.y);
    }

    public static boolean isValid(int _x, int _y) {
        if ( 0 > _x || 2 < _x || 0 > _y || 2 < _y )
            return false;
        return true;
    }
}
