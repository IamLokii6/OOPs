package Board_game_2336;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MemoryMatchingGame {
    private static final int GRID_SIZE = 4;
    private static final char[] CARD_VALUES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    private char[][] grid;
    private boolean[][] revealed;
    private int pairsFound;

    public MemoryMatchingGame() {
        grid = new char[GRID_SIZE][GRID_SIZE];
        revealed = new boolean[GRID_SIZE][GRID_SIZE];
        pairsFound = 0;
    }

    public void initializeGame() {
        fillGrid();
        shuffleGrid();
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        while (pairsFound < GRID_SIZE * GRID_SIZE / 2) {
            displayGrid();
            int[] firstCard = getCardChoice("Enter the row and column of the first card: ", scanner);
            int[] secondCard = getCardChoice("Enter the row and column of the second card: ", scanner);

            if (isValidChoice(firstCard) && isValidChoice(secondCard)) {
                if (grid[firstCard[0]][firstCard[1]] == grid[secondCard[0]][secondCard[1]]) {
                    System.out.println("You found a match!");
                    revealed[firstCard[0]][firstCard[1]] = true;
                    revealed[secondCard[0]][secondCard[1]] = true;
                    pairsFound++;
                } else {
                    System.out.println("No match. Try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter valid row and column values.");
            }
        }

        System.out.println("Congratulations! You've found all the pairs!");
        scanner.close();
    }

    private void fillGrid() {
        int cardCount = GRID_SIZE * GRID_SIZE / 2;
        Random random = new Random();

        for (int i = 0; i < cardCount; i++) {
            char cardValue = CARD_VALUES[i];
            for (int j = 0; j < 2; j++) {
                int row, col;
                do {
                    row = random.nextInt(GRID_SIZE);
                    col = random.nextInt(GRID_SIZE);
                } while (grid[row][col] != 0);

                grid[row][col] = cardValue;
            }
        }
    }

    private void shuffleGrid() {
        Random random = new Random();
        for (char[] row : grid) {
            for (int i = row.length - 1; i > 0; i--) {
                int j = random.nextInt(i + 1);
                char temp = row[i];
                row[i] = row[j];
                row[j] = temp;
            }
        }
    }

    private void displayGrid() {
        System.out.println("Memory Matching Game:");
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (revealed[i][j]) {
                    System.out.print(grid[i][j] + " ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }

    private int[] getCardChoice(String message, Scanner scanner) {
        System.out.print(message);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        return new int[]{row, col};
    }

    private boolean isValidChoice(int[] choice) {
        int row = choice[0];
        int col = choice[1];
        return row >= 0 && row < GRID_SIZE && col >= 0 && col < GRID_SIZE && !revealed[row][col];
    }

    public static void main(String[] args) {
        MemoryMatchingGame game = new MemoryMatchingGame();
        game.initializeGame();
        game.playGame();
    }
}
