public class PracticeSorting {
    public static void main(String args[]) {
        int arr[] = { 3, 6, 2, 1, 8, 7, 4, 5, 3, 1 };

        insertionSortDecending(arr);
        BasicSortingAlgorithm.printArr(arr);

    }

    /*
     * Bubble sort - decending order
     * time : O(n^2)
     * space: O(1)
     */
    public static void bubbleSortDecending(int array[]) {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (array[j] < array[j + 1]) {
                    // swap
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /*
     * Selection sort - decending order
     * time : O(n^2)
     * space: O(1)
     */
    public static void selectionSortDecending(int array[]) {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            int biggest = i;
            for (int j = i + 1; j < length; j++) {
                if (array[biggest] < array[j]) {
                    biggest = j;
                }
            }
            // swap
            int temp = array[biggest];
            array[biggest] = array[i];
            array[i] = temp;
        }
    }

    /*
     * Insertion sort - decending order
     * time :
     * space:
     */
    public static void insertionSortDecending(int array[]) {
        int length = array.length;
        for (int i = length - 2; i >= 0; i--) {
            int current = array[i];
            int j = i + 1;
            while (j < length && current < array[j]) {
                array[j - 1] = array[j];
                j++;
            }
            array[j - 1] = current;
        }
    }
}
