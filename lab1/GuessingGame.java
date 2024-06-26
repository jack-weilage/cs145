import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GuessingGame {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 1000;
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
            } else if (guess > answer) {
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

    private static void printResults(List<Long> guessCountPerGame) {
        long totalGames = guessCountPerGame.size();
        long totalGuesses = 0;
        // This could look pretty crazy if there aren't any values in the guess count
        // list, but this function should never be called before any games are played.
        long bestGuessCount = Integer.MAX_VALUE;

        for (int i = 0; i < totalGames; i++) {
            long guessCount = guessCountPerGame.get(i);

            bestGuessCount = Math.min(bestGuessCount, guessCount);
            totalGuesses += guessCount;
        }
        double averageGuessCount = totalGuesses / totalGames;

        System.out.println();
        System.out.println("Overall results:");
        System.out.printf("    total games      = %d\n", totalGames);
        System.out.printf("    total guesses    = %d\n", totalGuesses);
        System.out.printf("    guesses per game = %f\n", averageGuessCount);
        System.out.printf("    best game        = %d\n", bestGuessCount);
    }

    public static void main(String[] args) {
        printIntroduction();

        List<Long> guessCountPerGame = new ArrayList<Long>();

        do {
            guessCountPerGame.add(playGame());
        } while (promptForNextGame());

        printResults(guessCountPerGame);

    }
}
