package sorting;

/*
    Goal of this class:
    This class sorts students' ages using the Counting Sort technique.
    Since the age range is limited and known in advance (10 to 18),
    counting sort is used to efficiently count occurrences of each age,
    compute cumulative frequencies, and place each age into its correct
    position in the sorted output array without using comparison-based
    sorting algorithms.
*/

public class StudentAges {

    // Sorts the given ages array using counting sort
    static int[] countingSort(int[] ages) {
        int minAge = 10;
        int maxAge = 18;
        int range = maxAge - minAge + 1;

        int[] count = new int[range];
        int[] output = new int[ages.length];

        for (int age : ages) {
            count[age - minAge]++;
        }

        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        for (int i = ages.length - 1; i >= 0; i--) {
            int age = ages[i];
            output[count[age - minAge] - 1] = age;
            count[age - minAge]--;
        }

        return output;
    }

    // Entry point of the program
    public static void main(String[] args) {
        int[] ages = {15, 12, 14, 10, 18, 16, 12, 14};

        int[] sortedAges = countingSort(ages);

        for (int age : sortedAges) {
            System.out.print(age + " ");
        }
    }
}
