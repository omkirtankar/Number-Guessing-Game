import java.util.Scanner;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        GuessGame game = new GuessGame();
        int totalScore = 0;

        for (int round = 1; round <= 3; round++) {
            System.out.println("\nROUND " + round);

            System.out.print("Enter lower limit: ");
            int lowerLimit = inp.nextInt();

            System.out.print("Enter upper limit: ");
            int upperLimit = inp.nextInt();

            if (lowerLimit >= upperLimit) {
                System.out.println("Invalid range! Upper limit must be greater than lower limit.");
                round--; // Repeat round if input is incorrect
                continue;
            }

            game = new GuessGame(); // Reset points per round

            for (int attempt = 1; attempt <= 3; attempt++) {
                System.out.println("\nAttempt " + attempt);
                game.playRound(lowerLimit, upperLimit);
            }

            int roundScore = game.getPoints();
            totalScore += roundScore;
            System.out.println("Score for ROUND " + round + " = " + roundScore);
        }

        System.out.println("\nFinal Score: " + totalScore);
        if (totalScore > 3) {
            System.out.println("Great job! You're a good guesser!");
        } else {
            System.out.println("Better luck next time!");
        }

        inp.close();
    }
}
