// ARRAYS

public class Arrays {
    public static void main(String[] args) {

    }

    /*
     * update
     * time complexity:
     * space complexity:
     */
    public static void update(int marks[]) {
        for (int i = 0; i < marks.length; i++) {
            marks[i] = marks[i] + 1;
        }
    }

    /*
     * linear search
     * time complexity:
     * space complexity:
     */
    public static int linearSearch(int num[], int key) {
        for (int i = 0; i < num.length; i++) {
            if (num[i] == key) {
                return i;
            }
        }
        return -1;
    }

    /*
     * largest number
     * time complexity:
     * space complexity:
     */
    public static int largestNum(int num[]) {
        int largestNum = Integer.MIN_VALUE; // -infinity
        for (int i = 0; i < num.length; i++) {
            if (num[i] > largestNum) {
                largestNum = num[i];
            }
        }
        return largestNum;
    }

    /*
     * Binary Search
     * time complexity: O(log n)
     * space complexity:
     */
    public static int binarySearch(int numbers[], int key) {
        int start = 0;
        int end = numbers.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (numbers[mid] == key) { // found
                return mid;
            } else if (numbers[mid] < key) { // right
                start = mid + 1;
            } else { // left
                end = mid - 1;
            }
        }
        return -1;
    }

    /*
     * reverse array
     * time complexity:
     * space complexity:
     */
    public static void reverseArray(int arr[]) {
        int firstIndex = 0;
        int lastIndex = arr.length - 1;

        while (firstIndex < lastIndex) {
            int temp = arr[lastIndex];
            arr[lastIndex] = arr[firstIndex];
            arr[firstIndex] = temp;
            firstIndex++;
            lastIndex--;
        }
    }

    /*
     * pairs in array
     * time complexity: O(n^2)
     * space complexity: O(1)
     */
    public static void arrayInPairs(int array[]) {
        int totalPairs = 0;
        for (int i = 0; i < array.length; i++) {
            int current = array[i];
            for (int j = i + 1; j < array.length; j++) {
                System.out.print("(" + current + ", " + array[j] + ")");
                totalPairs++;
            }
            System.out.println();
        }
        System.out.println("total pairs = " + totalPairs);
    }

    /*
     * print subarrays
     * time complexity: O(n^3)
     * space complexity: O(1)
     */
    public static void printSubArray(int array[]) {
        for (int i = 0; i < array.length; i++) {
            int start = i;
            for (int j = i; j < array.length; j++) {
                int end = j;
                System.out.print("[");
                for (int k = start; k <= end; k++) {
                    System.out.print(array[k]);
                    if (k < end) {
                        System.out.print(", ");
                    }
                }
                System.out.println("]");
            }
            System.out.println();
        }
    }

    /*
     * max subarray sum - Brute Force Algorithm
     * time complexity: O(n^3)
     * space complexity:
     */
    public static void maxSubArraySum(int array[]) {
        int current = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            int start = i;
            for (int j = i; j < array.length; j++) {
                int end = j;
                current = 0;
                for (int k = start; k <= end; k++) {
                    current += array[k];
                }
                System.out.println("Current: " + current);

                if (maxSum < current) {
                    maxSum = current;
                }

            }
        }
        System.out.println("Max sum: " + maxSum);
    }

    /*
     * max subarray sum - Kadance's Algorithm (most efficient)
     * time complexity: O(n)
     * space complexity:
     */
    public static void maxSubArraySumKadance(int array[]) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int i = 0; i < array.length; i++) {
            currentSum += array[i];
            if (currentSum < 0) {
                currentSum = 0;
            }
            maxSum = Math.max(maxSum, currentSum);
        }
        System.out.println("Our max subarray sum: " + maxSum);
    }

    /*
     * Trapping Rainwater
     * time complexity:
     * space complexity:
     */
    public static int trappedWater(int array[]) {
        // left max boundary
        int leftMax[] = new int[array.length];
        leftMax[0] = array[0];

        for (int i = 1; i <= array.length - 1; i++) {
            leftMax[i] = Math.max(array[i], leftMax[i - 1]);
        }

        // right max boundary
        int rightMax[] = new int[array.length];
        rightMax[array.length - 1] = array[array.length - 1];

        for (int i = array.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(array[i], rightMax[i + 1]);
        }

        int trappedWater = 0;
        for (int i = 0; i < array.length; i++) {
            // water level
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            // count trapped water
            trappedWater += waterLevel - array[i];
        }
        return trappedWater;
    }
}
