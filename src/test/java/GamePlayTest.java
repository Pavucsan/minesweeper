import com.demo.service.GamePlay;
import com.demo.service.GridBoard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GamePlayTest {
    private GamePlay gamePlay;
    private final int size = 4;
    private final int mines = 2;

    @BeforeEach
    void setUp() {
        gamePlay = new GamePlay(size, mines);
    }

    /*
    1. testGameStartsWithNoRevealedCells
    2. testRevealNonMineCell
    3. testRevealMineEndsGame
    4. testWinningCondition
    5. testInvalidRevealAttempt
    6. testRevealEmptyRegion
     */

    @Test
    void testGameStartsWithNoRevealedCells() {
        GridBoard board = gamePlay.getBoard();
        int revealedCount = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (board.getCell(row, col).isRevealed()) {
                    revealedCount++;
                }
            }
        }
        assertEquals(0, revealedCount, "No cells should be revealed at the start of the game.");
    }

    @Test
    void testRevealNonMineCell() {
        GridBoard board = gamePlay.getBoard();
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (!board.getCell(row, col).isMine()) {
                    boolean isMineHit = board.revealCell(row, col);
                    assertFalse(isMineHit, "Revealing a non-mine cell should not result in a game over.");
                    assertTrue(board.getCell(row, col).isRevealed(), "Cell should be marked as revealed.");
                    return;
                }
            }
        }
    }

    @Test
    void testRevealMineEndsGame() {
        GridBoard board = gamePlay.getBoard();
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (board.getCell(row, col).isMine()) {
                    boolean isMineHit = board.revealCell(row, col);
                    assertTrue(isMineHit, "Revealing a mine should end the game.");
                    return;
                }
            }
        }
    }

    @Test
    void testWinningCondition() {
        GridBoard board = gamePlay.getBoard();
        //int safeCells = size * size - mines;
        int revealedCount = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (!board.getCell(row, col).isMine()) {
                    board.revealCell(row, col);
                    revealedCount++;
                }
            }
        }
        assertTrue(gamePlay.getBoard().isMatchWin(revealedCount), "Game should be won when all non-mine cells are revealed.");
    }

    @Test
    void testInvalidRevealAttempt() {
        GridBoard board = gamePlay.getBoard();
        board.revealCell(1, 1);
        boolean result = board.revealCell(1, 1);
        assertFalse(result, "Revealing an already revealed cell should return false.");
    }


    @Test
    void testRevealEmptyRegion() {
        GridBoard board = gamePlay.getBoard();
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (!board.getCell(row, col).isMine() && board.getCell(row, col).getAdjacentMines() == 0) {
                    board.revealCell(row, col);
                    assertTrue(board.getCell(row, col).isRevealed(), "Empty cell should be revealed.");
                    return;
                }
            }
        }
    }
}
