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
}
