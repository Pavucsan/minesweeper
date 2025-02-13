import com.demo.service.GamePlay;
import org.junit.jupiter.api.BeforeEach;

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


}
