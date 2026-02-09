package sorting;

/*
    Goal of this class:
    This class sorts an array of book prices in ascending order using the
    Merge Sort algorithm. The array is recursively divided into smaller
    halves until single-element arrays are obtained. These sorted halves
    are then merged by comparing elements to produce a fully sorted
    array, demonstrating a stable and efficient divide-and-conquer
    sorting technique.
*/

public class BookPrices {

    // Sorts the array using merge sort
    static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    // Merges two sorted subarrays into one sorted array
    static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }

        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        while (i < n1) {
            arr[k++] = leftArr[i++];
        }

        while (j < n2) {
            arr[k++] = rightArr[j++];
        }
    }

    // Entry point of the program
    public static void main(String[] args) {
        int[] prices = {399, 249, 599, 199, 349, 499};

        mergeSort(prices, 0, prices.length - 1);

        for (int price : prices) {
            System.out.print(price + " ");
        }
    }
}
