// Extra credit for using package keyword. Running `java lab1.GuessingGame` will work after compiling this package.
package lab1;

import java.security.SecureRandom;
import java.util.Scanner;

public class GuessingGame {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 100;
    private static final SecureRandom rng = new SecureRandom();
    private static final Scanner scanner = new Scanner(System.in);

    private static void printIntroduction() {
        System.out.println("This program allows you to play a guessing game.");
        System.out.printf("I will think of a number between %d and %d and will allow you to guess until you get it.\n",
                MIN_VALUE, MAX_VALUE);
        System.out.println(
                "For each guess, I will tell you whether the right answer is higher or lower than your guess.");
    }

    private static long playGame() {
        // Add an extra line to add a space between the introduction and the next
        // question.
        System.out.println();
        System.out.printf("I'm thinking of a number between %d and %d...\n", MIN_VALUE, MAX_VALUE);
        // Upper bound is exclusive, so add one to max value.
        int answer = rng.nextInt(MIN_VALUE, MAX_VALUE + 1);

        long guessCount = 0;

        while (true) {
            guessCount++;
            System.out.print("Your guess? ");

            int guess = scanner.nextInt();
            if (guess == answer) {
                System.out.printf("You got it right in %d %s\n", guessCount, guessCount == 1 ? "guess" : "guesses");
                return guessCount;
            }

            if (guess < answer) {
                System.out.println("It's higher.");
            } else {
                System.out.println("It's lower.");
            }
        }

    }

    private static boolean promptForNextGame() {
        System.out.print("Do you want to play again? ");
        String response = scanner.next();

        // It's way more efficient to only convert the character we want to be lower
        // case vs the entire response.
        return Character.toLowerCase(response.charAt(0)) == 'y';
    }

    public static void main(String[] args) {
        printIntroduction();

        long totalGames = 0;
        long totalGuesses = 0;
        long bestGuessCount = Integer.MAX_VALUE;

        do {
            long guesses = playGame();

            totalGuesses += guesses;
            bestGuessCount = Math.min(bestGuessCount, guesses);

            totalGames++;
        } while (promptForNextGame());

        double averageGuessCount = (double) totalGuesses / (double) totalGames;

        System.out.println();
        System.out.println("Overall results:");
        System.out.printf("    total games      = %d\n", totalGames);
        System.out.printf("    total guesses    = %d\n", totalGuesses);
        System.out.printf("    guesses per game = %f\n", averageGuessCount);
        System.out.printf("    best game        = %d\n", bestGuessCount);
    }
}
