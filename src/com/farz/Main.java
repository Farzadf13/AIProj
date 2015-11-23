package com.farz;


import com.farz.board.*;
import com.farz.judge.Judge;
import com.farz.player.*;
import com.farz.utils.*;

public class Main {
    public static void main(String[] args) {
        Judge judge = new Judge();
        judge.startGame();
    }
}
