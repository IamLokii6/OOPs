package simple_java_game_2336;

import java.util.Random;
import java.util.Scanner;

public class WordSearchPuzzle {
    private char[][] grid;
    private int gridSize;
    private String[] wordsToFind;
    private boolean[] wordsFound;
    private int wordsFoundCount;

    public WordSearchPuzzle(int gridSize, String[] wordsToFind) {
        this.gridSize = gridSize;
        this.grid = new char[gridSize][gridSize];
        this.wordsToFind = wordsToFind;
        this.wordsFound = new boolean[wordsToFind.length];
        this.wordsFoundCount = 0;
    }

    public void initializeGrid() {
        Random rand = new Random();
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                char randomLetter = (char) (rand.nextInt(26) + 'A'); 
                grid[i][j] = randomLetter;
            }
        }
    }

    public void displayGrid() {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean checkWord(String input) {
        return false; 
    }

    public boolean checkWin() {
        return wordsFoundCount == wordsToFind.length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the grid size: ");
        int gridSize = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter the words to find (comma-separated): ");
        String[] wordsToFind = scanner.nextLine().split(",");
        
        WordSearchPuzzle game = new WordSearchPuzzle(gridSize, wordsToFind);
        game.initializeGrid();

        while (!game.checkWin()) {
            game.displayGrid();
            System.out.print("Enter the word you found (e.g., A1 to A4): ");
            String input = scanner.nextLine().toUpperCase();
            
            if (game.checkWord(input)) {
                System.out.println("Word found!");
            } else {
                System.out.println("Word not found.");
            }
        }

        System.out.println("Congratulations! You found all the words!");
        scanner.close();
    }
}
