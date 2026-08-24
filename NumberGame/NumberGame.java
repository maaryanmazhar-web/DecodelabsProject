import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        // Scanner object to take input from user
        Scanner sc = new Scanner(System.in);

        // Random object to generate random numbers
        Random random = new Random();

        int score = 0;          // Total score
        char playAgain;         // To check if user wants another round

        System.out.println("=================================");
        System.out.println("      WELCOME TO NUMBER GAME");
        System.out.println("=================================");

        do {

            // Generate random number between 1 and 100
            int randomNumber = random.nextInt(100) + 1;

            // Maximum attempts
            int maxAttempts = 7;

            // Count attempts
            int attempts = 0;

            // Variable to check if user guessed correctly
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            // Loop until attempts are over
            while (attempts < maxAttempts) {

                System.out.print("\nEnter your guess: ");
                int guess = sc.nextInt();

                attempts++;

                if (guess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    guessedCorrectly = true;

                    // Score calculation
                    score = score + (maxAttempts - attempts + 1);

                    break;
                }

                else if (guess < randomNumber) {
                    System.out.println("Too Low!");
                }

                else {
                    System.out.println("Too High!");
                }

                System.out.println("Attempts Left: " + (maxAttempts - attempts));
            }

            // If user could not guess
            if (!guessedCorrectly) {
                System.out.println("\nYou Lost!");
                System.out.println("The correct number was: " + randomNumber);
            }

            // Display score
            System.out.println("Current Score: " + score);

            // Ask user to play again
            System.out.print("\nDo you want to play another round? (Y/N): ");
            playAgain = sc.next().charAt(0);

        } while (playAgain == 'Y' || playAgain == 'y');

        System.out.println("\nThank you for playing!");
        System.out.println("Final Score: " + score);

        sc.close();
    }
}