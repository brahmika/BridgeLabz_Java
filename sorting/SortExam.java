package sorting;

/*
    Goal of this class:
    This class sorts students’ exam scores in ascending order using the
    Selection Sort algorithm. The method works by repeatedly selecting
    the minimum element from the unsorted portion of the array and
    swapping it with the first unsorted element, gradually building
    a sorted section from left to right.
*/

public class SortExam {

    // Sorts the array using selection sort
    static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Entry point of the program
    public static void main(String[] args) {
        int[] scores = {78, 92, 85, 67, 88, 74};

        selectionSort(scores);

        for (int score : scores) {
            System.out.print(score + " ");
        }
    }
}
