package com.demo.service;

import com.demo.model.Cell;

import java.util.Random;

public class GridBoard {
    private final int gridSize;
    private final int mines;
    private final Cell[][] grid;
    private boolean[][] mineLocation;

    public GridBoard(int gridSize, int mines) {
        this.gridSize = gridSize;
        this.mines = mines;
        this.grid = new Cell[gridSize][gridSize];
        initGridBoard();
        putMines();

    }

    private void initGridBoard() {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                grid[i][j] = new Cell();
            }
        }
    }

    private void putMines() {
        Random random = new Random();
        int placed = 0;
        mineLocation = new boolean[gridSize][gridSize];

        while (placed < mines) {
            int row = random.nextInt(gridSize);
            int column = random.nextInt(gridSize);

            // if mine already not placed in the place the mine there
            if (!mineLocation[row][column]) {
                mineLocation[row][column] = true;
                grid[row][column].setMine(true);
                placed++;
            }
        }
    }

    private int countAdjacentMines(int row, int col) {
        int mineCount = 0;
        for (int rowOffset = -1; rowOffset <= 1; rowOffset++) {
            for (int colOffset = -1; colOffset <= 1; colOffset++) {
                int nrow = row + rowOffset;
                int ncol = col + colOffset;
                if ((nrow >= 0 && nrow < gridSize) && (ncol >= 0 && ncol < gridSize) && grid[nrow][ncol].isMine()) {
                    mineCount++;
                }
            }
        }
        return mineCount;
    }

    private void numbersCalculate() {
        // i - row, j - column
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (!grid[i][j].isMine()) {
                    grid[i][j].setAdjacentMines(countAdjacentMines(i, j));
                }
            }
        }
    }

    public void printGridBoard(boolean revealMines) {
        System.out.println("  ");
        for (int i = 0; i < gridSize; i++) {
            System.out.println((i + 1) + " ");
        }
        System.out.println();

        for (int row = 0; row < gridSize; row++) {
            System.out.println(('A' + row) + " ");
            for (int col = 0; col < gridSize; col++) {
                if (revealMines && grid[row][col].isMine()) {
                    System.out.println("* ");
                } else {
                    System.out.println(grid[row][col] + " ");
                }
            }
            System.out.println();
        }
    }
}
