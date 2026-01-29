// User vs computer game, show stats and winning percentage

import java.util.Scanner;

public class RockPaperScissors {

    static String getComputerChoice() {
        int choice = (int) (Math.random() * 3); // 0,1,2
        switch (choice) {
            case 0: return "rock";
            case 1: return "paper";
            default: return "scissors";
        }
    }

    static String findWinner(String user, String computer) {
        if (user.equals(computer)) {
            return "Draw";
        } else if ((user.equals("rock") && computer.equals("scissors")) ||
                   (user.equals("paper") && computer.equals("rock")) ||
                   (user.equals("scissors") && computer.equals("paper"))) {
            return "Player";
        } else {
            return "Computer";
        }
    }

    static String[][] calculateStats(String[] winners) {
        int playerWins = 0, computerWins = 0, draws = 0, total = winners.length;

        for (String w : winners) {
            if (w.equals("Player")) playerWins++;
            else if (w.equals("Computer")) computerWins++;
            else draws++;
        }

        double playerPercent = (playerWins * 100.0) / total;
        double computerPercent = (computerWins * 100.0) / total;

        String[][] stats = new String[4][2];
        stats[0][0] = "Player Wins"; stats[0][1] = String.valueOf(playerWins);
        stats[1][0] = "Computer Wins"; stats[1][1] = String.valueOf(computerWins);
        stats[2][0] = "Draws"; stats[2][1] = String.valueOf(draws);
        stats[3][0] = "Winning %"; stats[3][1] = "Player: " + String.format("%.2f", playerPercent) +
                                               "%, Computer: " + String.format("%.2f", computerPercent) + "%";

        return stats;
    }

    static void displayResults(String[] userChoices, String[] computerChoices, String[] winners, String[][] stats) {
        System.out.println("Game\tPlayer\tComputer\tWinner");
        for (int i = 0; i < userChoices.length; i++) {
            System.out.println((i+1) + "\t" + userChoices[i] + "\t" + computerChoices[i] + "\t\t" + winners[i]);
        }
        System.out.println("\nStats:");
        for (int i = 0; i < stats.length; i++) {
            System.out.println(stats[i][0] + "\t" + stats[i][1]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of games: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] userChoices = new String[n];
        String[] computerChoices = new String[n];
        String[] winners = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter choice for game " + (i+1) + " (rock/paper/scissors): ");
            String user = sc.nextLine().toLowerCase();
            String computer = getComputerChoice();

            String winner = findWinner(user, computer);

            userChoices[i] = user;
            computerChoices[i] = computer;
            winners[i] = winner;
        }

        String[][] stats = calculateStats(winners);
        displayResults(userChoices, computerChoices, winners, stats);

        sc.close();
    }
}
