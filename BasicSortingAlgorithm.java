// Basic Sorting Algorithms

public class BasicSortingAlgorithm {
    public static void main(String[] args) {

    }

    /*
     * Bubble sort
     * Selection sort
     * Insertion sort
     * Counting sort (missing)
     */

    /*
     * Bubble sort
     * time : O(n^2)
     * space: O(1)
     */
    public static void bubbleSort(int array[]) {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // swap
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    private static void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /*
     * Selection sort
     * time : O(n^2)
     * space: O(1)
     */
    public static void selectionSort(int array[]) {
        for (int i = 0; i < array.length - 1; i++) {
            int smallest = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[smallest] > array[j]) {
                    smallest = j;
                }
            }
            // swap
            int temp = array[smallest];
            array[smallest] = array[i];
            array[i] = temp;
        }
    }

    /*
     * Insertion sort
     * time : O(n^2)
     * space: O(1)
     */
    public static void insertionSort(int array[]) {
        int length = array.length;
        for (int i = 1; i < length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && current < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
    }
}
