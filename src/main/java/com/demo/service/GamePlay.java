package com.demo.service;

import java.util.Scanner;

public class GamePlay {
    private final GridBoard gridBoard;
    private final int size;
    private final int mines;
    private boolean gameEnd;
    private int revealedCount;

    public GamePlay(int size, int mines) {
        this.size = size;
        this.mines = mines;
        this.gridBoard = new GridBoard(size, mines);
        this.gameEnd = false;
        this.revealedCount = 0;
    }

    /*
     1. play
        -> check game end
        -> validate input
        -> check game win
     */

}
