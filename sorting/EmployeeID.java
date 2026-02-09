package sorting;

/*
    Goal of this class:
    This class sorts employee IDs stored in an unsorted array using the
    Insertion Sort algorithm. The array is conceptually divided into a
    sorted and an unsorted region. Elements from the unsorted region are
    picked one by one and inserted into their appropriate positions
    within the sorted region, resulting in a fully sorted array.
*/

public class EmployeeID {

    // Sorts the array using insertion sort
    static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    // Entry point of the program
    public static void main(String[] args) {
        int[] employeeIds = {104, 101, 109, 102, 106};

        insertionSort(employeeIds);

        for (int id : employeeIds) {
            System.out.print(id + " ");
        }
    }
}
