# Minesweeper Game - README
minesweeper game for an assignment

## Design:

### Key Classes:
1. **Cell**: Represents each individual cell on the game board.
2. **Grid Board**: Manages the entire Minesweeper board. It handles the initialization of the grid, mine placement, and the calculation of adjacent mines for non-mine cells. It also provides a method for revealing cells.
3. **Game Play**: Manages the gameplay, including the user's input, the game loop, checking for win conditions, and printing the game board.
4. **MinesweeperApp**: The main entry point of the application. It handles input validation for the grid size and number of mines, initiates the game, and processes user commands.


### Game Flow:
1. **User Input**:
    - The user is prompted to input the grid size (positive integer).
    - The user is then prompted to input the number of mines, with validation ensuring it is within the allowed range.

2. **Game Execution**:
    - The board is initialized and displayed. The user enters coordinates to reveal cells.
    - If a mine is revealed, the game ends with a "Game Over" message.
    - If all non-mine cells are revealed, the player wins.

3. **Input Validation**:
    - The application performs checks for valid inputs, such as checking for non-negative integers, range restrictions, and correct format for coordinates.

## Environment Requirements:
- **Java Development Kit (JDK)**:
    - Java 17

  **To check if Java is installed:**
    - Open your terminal/command prompt and run:
      ```bash
      java -version
      ```
## Steps to Run Test:
1. **Run Test**:
    - Go to specific dir and open the terminal, run the following command in your terminal:
      ```bash
      mvn test
      ```
      
## Steps to Compile and Run:
1. **Compile the Code**:
    - To compile the code, run the following command in your terminal:
      ```bash
      mvn clean package
      ```
    - if you want to ignore the tests and build
      ```bash
      mvn clean package -DskipTests
      ```

2. **Run the application with test**:
    - Find the MinesweeperApp.jar from the target directory:
    - run the following command in your terminal
      ```bash
      java -jar target/MinesweeperApp.jar
      ```
3. **Example Game Flow**:
```text
Welcome to Minesweeper!

Enter the size of the grid (e.g. 4 for a 4x4 grid):
4
Enter the number of mines to place on the grid (maximum is 35% of the total squares):
3

Here is your minefield:
1 2 3 4
A _ _ _ _
B _ _ _ _
C _ _ _ _
D _ _ _ _

Select a square to reveal (e.g. A1): D4
This square contains 0 adjacent mines.

Here is your updated minefield:
1 2 3 4
A _ _ 2 0
B _ _ 2 0
C _ 2 1 0
D _ 1 0 0

Select a square to reveal (e.g. A1): B1
This square contains 3 adjacent mines.

Here is your updated minefield:
1 2 3 4
A _ _ 2 0
B 3 _ 2 0
C _ 2 1 0
D _ 1 0 0

Select a square to reveal (e.g. A1): A1
This square contains 2 adjacent mines.

Here is your updated minefield:
1 2 3 4
A 2 _ 2 0
B 3 _ 2 0
C _ 2 1 0
D _ 1 0 0

Select a square to reveal (e.g. A1): D1
This square contains 1 adjacent mines.

Here is your updated minefield:
1 2 3 4
A 2 _ 2 0
B 3 _ 2 0
C _ 2 1 0
D 1 1 0 0

Congratulations, you have won the game!
Press any key to play again...
```
Failure example
```
Welcome to Minesweeper!

Enter the size of the grid (e.g. 4 for a 4x4 grid):
3
Enter the number of mines to place on the grid (maximum is 35% of the total squares):
3

Here is your minefield:
1 2 3
A _ _ _
B _ _ _
C _ _ _

Select a square to reveal (e.g. A1): C3
Oh no, you detonated a mine! Game over.
Press any key to play again...
```