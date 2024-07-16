
import java.util.Random;
import java.util.Scanner;

public class PigRoll {
    int players;
    int turns;

    public PigRoll(int players, int turns) {
        this.players = players;
        this.turns = turns;
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int sum1 = 0, sum2 = 0;
        
        if (players == 2) {
            System.out.println("Enter total number of points to win:");
            int points = scanner.nextInt();

            while (sum1 < points && sum2 < points) {
                System.out.println("Player 1's turn. Enter number of turns:");
                int turns1 = scanner.nextInt();
                sum1 = takeTurns(rand, turns1, sum1, "Player 1");

                if (sum1 >= points) break;

                System.out.println("Player 2's turn. Enter number of turns:");
                int turns2 = scanner.nextInt();
                sum2 = takeTurns(rand, turns2, sum2, "Player 2");
            }

            if (sum1 >= points) {
                System.out.println("Player 1 won with " + sum1 + " points!");
            } else {
                System.out.println("Player 2 won with " + sum2 + " points!");
            }
        } else {
            System.out.println("Invalid number of players");
        }

        scanner.close();
    }

    private int takeTurns(Random rand, int turns, int sum, String player) {
        for (int i = 0; i < turns; i++) {
            int roll = rand.nextInt(6) + 1; 
            System.out.println(player + " rolled: " + roll);
            if (roll == 1) {
                sum = 0;
            } else {
                sum += roll;
            }
        }
        System.out.println(player + "'s total points: " + sum);
        return sum;
    }

    public static void main(String[] args) {
        PigRoll game = new PigRoll(2, 0); 
        game.startGame();
    }
}
