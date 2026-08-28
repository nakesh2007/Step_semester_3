import java.util.*;

public class RockPaperScissors {

    static String playRound(String playerMove, String computerMove) {

        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};

        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.print("Enter number of rounds: ");
        int n = sc.nextInt();

        String[] playerMoves = new String[n];
        String[] computerMoves = new String[n];
        String[] results = new String[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nRound " + (i + 1));
            System.out.print("Enter Rock, Paper or Scissors: ");

            playerMoves[i] = sc.next();

            // Convert first letter to uppercase
            playerMoves[i] =
                    playerMoves[i].substring(0, 1).toUpperCase()
                    + playerMoves[i].substring(1).toLowerCase();

            computerMoves[i] = moves[random.nextInt(3)];

            results[i] = playRound(playerMoves[i], computerMoves[i]);

            System.out.println("Player: " + playerMoves[i]);
            System.out.println("Computer: " + computerMoves[i]);
            System.out.println("Result: " + results[i]);

            if (results[i].equals("Player Wins"))
                wins++;
            else if (results[i].equals("Computer Wins"))
                losses++;
            else
                draws++;
        }

        System.out.println("\n--------- FINAL SUMMARY ---------");
        System.out.println("Round\tPlayer\t\tComputer\tResult");

        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + "\t" + playerMoves[i]
                    + "\t\t" + computerMoves[i]
                    + "\t\t" + results[i]);
        }

        double winPercentage = (wins * 100.0) / n;

        System.out.println("\nWins   : " + wins);
        System.out.println("Losses : " + losses);
        System.out.println("Draws  : " + draws);
        System.out.println("Win %  : " + winPercentage + "%");
    }
}