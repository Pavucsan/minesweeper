package com.demo;

import com.demo.service.GamePlay;
import com.demo.validations.MineSweeperValidation;

import java.util.Scanner;

public class MineSweeperApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {

            System.out.println("Welcome to Minesweeper!");
            System.out.println("Enter the size of the grid (e.g. 4 for a 4x4 grid):");
            int gridSize = MineSweeperValidation.getValidGridSize(scanner);
            System.out.println("Enter the number of mines to place on the grid (maximum is 35% of the total squares):");
            int maximumMines = (int) (0.35 * gridSize * gridSize);
            int mines;

            do {
                mines = MineSweeperValidation.getValidMineCount(scanner, maximumMines);
                if (mines > maximumMines) {
                    System.out.println("Mines Exceed! enter upto " + maximumMines + ":");
                }
            } while (mines > maximumMines);

            GamePlay gamePlay = new GamePlay(gridSize, mines);
            gamePlay.play();

            System.out.print("Play again? (Y/N): ");
        } while (scanner.next().equalsIgnoreCase("Y"));
    }
}