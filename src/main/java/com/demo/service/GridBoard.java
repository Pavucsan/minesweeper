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
        numbersCalculate();
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
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                int nr = row + dr;
                int nc = col + dc;
                if (nr >= 0 && nr < gridSize && nc >= 0 && nc < gridSize && grid[nr][nc].isMine()) {
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


    public boolean revealCell(int row, int col) {
        if (row < 0 || row >= gridSize || col < 0 || col >= gridSize || grid[row][col].isRevealed()) {
            return false;
        }
        grid[row][col].setRevealed(true);

        if (grid[row][col].getAdjacentMines() == 0) {
            for (int rowOffset = -1; rowOffset <= 1; rowOffset++) {
                for (int colOffset = -1; colOffset <= 1; colOffset++) {
                    if (rowOffset != 0 || colOffset != 0) {
                        revealCell(row + rowOffset, col + colOffset);
                    }
                }
            }
        }
        return false;
    }

    public boolean isMatchWin(int reveledCount) {
        return reveledCount == (gridSize * gridSize - mines);
    }

    public void printGridBoard(boolean revealMines) {
        System.out.println("  ");
        for (int i = 0; i < gridSize; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();

        for (int row = 0; row < gridSize; row++) {
            System.out.print((char) ('A' + row) + " ");
            for (int col = 0; col < gridSize; col++) {
                if (revealMines && grid[row][col].isMine()) {
                    System.out.print("* ");
                } else {
                    System.out.print(grid[row][col] + " ");
                }
            }
            System.out.println();
        }
    }
}
