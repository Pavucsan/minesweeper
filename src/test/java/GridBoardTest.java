import com.demo.service.GridBoard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GridBoardTest {
    private GridBoard board;
    private final int size = 5;
    private final int mines = 5;

    @BeforeEach
    void setUp() {
        board = new GridBoard(size, mines);
    }

    @Test
    void testGridBoardInitialization() {
        assertNotNull(board);
    }
    
    @Test
    void testMinePlacement() {
        int mineCount = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board.revealCell(i, j)) {
                    mineCount++;
                }
            }
        }
        assertEquals(mines, mineCount, "Mine count should match the expected number");
    }

}
