package sorting;

/*
    Goal of this class:
    This class sorts product prices in ascending order using the Quick
    Sort algorithm. A pivot element is selected to partition the array
    such that elements smaller than the pivot are placed on the left
    and larger elements on the right. The process is applied recursively
    to efficiently sort the entire array.
*/

public class SortProduct {

    // Sorts the array using quick sort
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Partitions the array and returns the pivot index
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Entry point of the program
    public static void main(String[] args) {
        int[] prices = {2999, 1599, 4999, 2499, 899, 3499};

        quickSort(prices, 0, prices.length - 1);

        for (int price : prices) {
            System.out.print(price + " ");
        }
    }
}

