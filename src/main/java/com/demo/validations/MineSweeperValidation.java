package com.demo.validations;

import java.util.Scanner;

public class MineSweeperValidation {

    public static int getValidGridSize(Scanner scanner) {
        int gridSize = 0;
        while (true) {
            System.out.print("Enter the size of the grid (minimum 2): ");
            if (scanner.hasNextInt()) {
                gridSize = scanner.nextInt();
                if (gridSize >= 2) {
                    return gridSize;
                } else {
                    System.out.println("Invalid input! Grid size must be at least 2.");
                }
            } else {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.next();
            }
        }
    }
    public static int getValidMineCount(Scanner scanner, int maxMines) {
        int mines = 0;
        while (true) {
            System.out.print("Enter the number of mines (between 1 and " + maxMines + "): ");
            if (scanner.hasNextInt()) {
                mines = scanner.nextInt();
                if (mines >= 1 && mines <= maxMines) {
                    return mines;
                } else {
                    System.out.println("Invalid input! Number of mines must be between 1 and " + maxMines + ".");
                }
            } else {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.next();
            }
        }
    }
}
