// Create, shuffle, and distribute cards

import java.util.Scanner;

public class RandomCards {

    static String[] initializeDeck() {
        String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
        String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", 
                           "Jack", "Queen", "King", "Ace" };

        String[] deck = new String[suits.length * ranks.length];
        int index = 0;

        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }
        return deck;
    }

    static void shuffleDeck(String[] deck) {
        int n = deck.length;
        for (int i = 0; i < n; i++) {
            int randomIndex = i + (int) (Math.random() * (n - i));
            String temp = deck[i];
            deck[i] = deck[randomIndex];
            deck[randomIndex] = temp;
        }
    }

    static String[][] distributeDeck(String[] deck, int players, int nCards) {
        if (players * nCards > deck.length) return null;

        String[][] hands = new String[players][nCards];
        int index = 0;

        for (int i = 0; i < nCards; i++) {
            for (int j = 0; j < players; j++) {
                hands[j][i] = deck[index++];
            }
        }
        return hands;
    }

    static void printHands(String[][] hands) {
        for (int i = 0; i < hands.length; i++) {
            System.out.println("Player " + (i + 1) + ":");
            for (String card : hands[i]) {
                System.out.println("\t" + card);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] deck = initializeDeck();
        shuffleDeck(deck);

        System.out.print("Enter number of players: ");
        int players = sc.nextInt();
        System.out.print("Enter number of cards per player: ");
        int nCards = sc.nextInt();

        String[][] hands = distributeDeck(deck, players, nCards);
        if (hands != null) {
            printHands(hands);
        } else {
            System.out.println("Cannot distribute " + nCards + " cards to " + players + " players.");
        }

        sc.close();
    }
}
