
/*
 * This program implements a simple Voting System.
 * Votes are stored in a HashMap where the key is the candidate
 * and the value is the total number of votes.
 * A LinkedHashMap is used to maintain the order in which votes were cast.
 * A TreeMap is used to display the final results in sorted order of candidates.
 */
package collections;
import java.util.*;
public class VotingSystem {

    private Map<String, Integer> voteCount = new HashMap<>();
    private Map<String, Integer> voteOrder = new LinkedHashMap<>();

    // Casts a vote for a candidate and updates all maps
    public void castVote(String candidate) {
        voteCount.put(candidate, voteCount.getOrDefault(candidate, 0) + 1);
        voteOrder.put(candidate, voteOrder.getOrDefault(candidate, 0) + 1);
    }

    // Displays votes in the order they were inserted
    public void displayVoteOrder() {
        System.out.println("Votes in Insertion Order:");
        for (Map.Entry<String, Integer> entry : voteOrder.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // Displays final results sorted alphabetically by candidate name
    public void displaySortedResults() {
        System.out.println("\nSorted Results:");
        Map<String, Integer> sortedMap = new TreeMap<>(voteCount);

        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // Displays raw vote counts using HashMap
    public void displayRawResults() {
        System.out.println("\nRaw Vote Count (HashMap):");
        for (Map.Entry<String, Integer> entry : voteCount.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // Entry point to test the voting system
    public static void main(String[] args) {

        VotingSystem system = new VotingSystem();

        system.castVote("Alice");
        system.castVote("Bob");
        system.castVote("Alice");
        system.castVote("Carol");
        system.castVote("Bob");

        system.displayVoteOrder();
        system.displayRawResults();
        system.displaySortedResults();
    }
}
