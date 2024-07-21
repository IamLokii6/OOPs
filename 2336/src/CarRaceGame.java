import java.util.Scanner;
import java.util.Random;

public class CarRaceGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int trackLength = 20;
        int playerPosition = 0;
        int opponentPosition = 0;

        System.out.println("Welcome to the Car Race Game!");
        System.out.println("Press Enter to start...");
        scanner.nextLine();

        while (playerPosition < trackLength && opponentPosition < trackLength) {
            // Clear the console
            System.out.print("\033[H\033[2J");
            System.out.flush();

            // Move the player and opponent
            playerPosition += random.nextInt(3);
            opponentPosition += random.nextInt(3);

            // Display the track
            for (int i = 0; i < trackLength; i++) {
                if (i == playerPosition && i == opponentPosition) {
                    System.out.print("X"); // Both on the same position
                } else if (i == playerPosition) {
                    System.out.print("P"); // Player's position
                } else if (i == opponentPosition) {
                    System.out.print("O"); // Opponent's position
                } else {
                    System.out.print("-"); // Empty track
                }
            }
            System.out.println();

            try {
                Thread.sleep(500); // Pause for a moment
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (playerPosition >= trackLength && opponentPosition >= trackLength) {
            System.out.println("It's a tie!");
        } else if (playerPosition >= trackLength) {
            System.out.println("You win! Player wins the race.");
        } else {
            System.out.println("Opponent wins the race. Better luck next time!");
        }

        scanner.close();
    }
}

