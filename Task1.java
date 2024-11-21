import java.util.Scanner;
import java.util.Random;

public class Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int roundsPlayed = 0;
        int roundsWon = 0;
        boolean playAgain;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            roundsPlayed++;
            int generatedNumber = random.nextInt(100) + 1; // Generate a number between 1 and 100
            int attemptsLeft = 5; // Maximum attempts allowed
            boolean numberGuessed = false;

            System.out.println("\nRound " + roundsPlayed + ":");
            System.out.println("I have generated a number between 1 and 100. Can you guess it?");
            System.out.println("You have " + attemptsLeft + " attempts.");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attemptsLeft--;

                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! You guessed the correct number!");
                    numberGuessed = true;
                    roundsWon++;
                    break;
                } else if (userGuess > generatedNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Too low! Try again.");
                }

                if (attemptsLeft > 0) {
                    System.out.println("Attempts left: " + attemptsLeft);
                } else {
                    System.out.println("Out of attempts! The correct number was " + generatedNumber);
                }
            }

            System.out.println("Round " + roundsPlayed + " ended.");
            if (numberGuessed) {
                System.out.println("You won this round!");
            } else {
                System.out.println("Better luck next time!");
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("\nGame Over!");
        System.out.println("Rounds Played: " + roundsPlayed);
        System.out.println("Rounds Won: " + roundsWon);
        System.out.println("Thank you for playing!");

        scanner.close();
    }
}
