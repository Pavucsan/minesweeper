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


    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (!gameEnd) {
            gridBoard.printGridBoard(false);

            System.out.println("Select a square to reveal (e.g. A1): D4");
            String input = scanner.next().toUpperCase();

            if (input.length() < 2) continue;

            int row, col;
            row = input.charAt(0) - 'A';
            col = Integer.parseInt(String.valueOf(input.charAt(1))) - 1;
            if ((row >= 0 && row < size) && (col >= 0 && col < size)) {
                gameEnd = gridBoard.revealCell(row, col);
                revealedCount++;

                if (gameEnd) {
                    System.out.println("Oh no, you detonated a mine! Game over.");
                    gridBoard.printGridBoard(true);
                    return;
                }
                if (gridBoard.isMatchWin(revealedCount)) {
                    System.out.println("Congratulations, you have won the game!");
                    gridBoard.printGridBoard(true);
                    return;
                }
            }

        }
    }

}
