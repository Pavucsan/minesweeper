package com.demo;

import com.demo.service.GamePlay;

import java.util.Scanner;

public class MineSweeperApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Minesweeper!");
        System.out.println("Enter the size of the grid (e.g. 4 for a 4x4 grid):");
        int gridSize = scanner.nextInt();
        System.out.println("Enter the number of mines to place on the grid (maximum is 35% of the total squares):");
        int maximumMines = (int) (0.35 * gridSize * gridSize);
        int mines;

        do {
            mines = scanner.nextInt();
            if (mines > maximumMines) {
                System.out.println("Mines Exceed! enter upto " + maximumMines + ":");
            }
        } while (mines > maximumMines);

        GamePlay gamePlay = new GamePlay(gridSize, mines);
        gamePlay.play();
    }
}