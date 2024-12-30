// Divide & Conquer

public class DivideAndConquer {
    public static void main(String args) {

    }

    /*
     * Merge Sort
     * Quick Sort
     * Sorted & Rotaed Array Search
     */

    /*
     * Merge Sort
     * time : O(n logn)
     * space : O(n)
     */
    public static void mergeSort(int array[], int si, int ei) {
        // base case
        if (si >= ei) {
            return;
        }

        // step 1: divide
        int mid = (si + ei) / 2;

        // step 2: mergeSort
        mergeSort(array, si, mid); // left side
        mergeSort(array, mid + 1, ei); // right side

        // step 3: merge
        merge(array, si, mid, ei);
    }

    private static void merge(int array[], int si, int mid, int ei) {
        int temp[] = new int[(ei - si) + 1];
        int leftArrIndex = si;
        int rightArrIndex = mid + 1;
        int tempArrayIndex = 0;

        while (leftArrIndex <= mid && rightArrIndex <= ei) {
            if (array[leftArrIndex] < array[rightArrIndex]) {
                // store leftArrIndex in temp
                temp[tempArrayIndex] = array[leftArrIndex];
                // point to next one
                leftArrIndex++;
            } else {
                // store rightArrIndex in temp
                temp[tempArrayIndex] = array[rightArrIndex];

                // point to the next one
                rightArrIndex++;
            }
            // temp index to next
            tempArrayIndex++;
        }

        while (leftArrIndex <= mid) {
            temp[tempArrayIndex] = array[leftArrIndex];
            leftArrIndex++;
            tempArrayIndex++;
        }

        while (rightArrIndex <= ei) {
            temp[tempArrayIndex] = array[rightArrIndex];
            rightArrIndex++;
            tempArrayIndex++;
        }

        for (tempArrayIndex = 0, leftArrIndex = si; tempArrayIndex < temp.length; tempArrayIndex++, leftArrIndex++) {
            array[leftArrIndex] = temp[tempArrayIndex];
        }
    }

    /*
     * Quick Sort
     * time :
     * space :
     */
}
