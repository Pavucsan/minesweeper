import com.demo.MineSweeperApp;
import com.demo.validations.MineSweeperValidation;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MiniSweeperValidationTest {
    /*
    * 1. Normal Input works
    * 2. Invalid and valid input -> -1,0,2
    * 3. pass text and test
    *
    * */
    @Test
    void testValidGridSize() {
        String input = "4\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        int gridSize = MineSweeperValidation.getValidGridSize(scanner);
        assertEquals(4, gridSize);
    }

    @Test
    void testInvalidGridSizeThenValid() {
        String input = "-1\n0\n2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        int gridSize = MineSweeperValidation.getValidGridSize(scanner);
        assertEquals(2, gridSize);
    }

    @Test
    void testNonNumericGridSizeThenValid() {
        String input = "abc\n3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        int gridSize = MineSweeperValidation.getValidGridSize(scanner);
        assertEquals(3, gridSize);
    }

    @Test
    void testValidMineCount() {
        String input = "5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        int mines = MineSweeperValidation.getValidMineCount(scanner, 10);
        assertEquals(5, mines);
    }

    @Test
    void testInvalidMineCountThenValid() {
        String input = "-2\n0\n8\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        int mines = MineSweeperValidation.getValidMineCount(scanner, 10);
        assertEquals(8, mines);
    }

    @Test
    void testMineCountExceedingMax() {
        String input = "20\n7\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        int mines = MineSweeperValidation.getValidMineCount(scanner, 10);
        assertEquals(7, mines);
    }


}
