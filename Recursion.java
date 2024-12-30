// Recursion

public class Recursion {
    public static void main(String args) {

    }

    // Recursion Basics

    /*
     * iteration
     * functions
     * used in mostly: Trees, Graphs, DP(dynamic programming)
     */

    /*
     * Steps:
     * 1. base case
     * 2. do some work
     * 3. call inner function
     * 
     * memory - call stack, stack overflow
     */

    /*
     * print numbers in decresaing order
     * time :
     * space :
     */
    public static void decreasingOrder(int n) {
        if (n == 1) {
            System.out.println(n);
            return;
        }
        System.out.print(n + " ");
        decreasingOrder(n - 1);
    }

    /*
     * print numbers in decresaing order
     * time :
     * space :
     */
    public static void increasingOrder(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        increasingOrder(n - 1);
        System.out.print(n + " ");
    }

    /*
     * print factorial of a number n
     * factoria => n! = n x (n - 1)!
     * time :
     * space :
     */
    public static int findFactorial(int n) {
        if (n == 0) {
            return 1;
        }
        int factorial = n * findFactorial(n - 1);
        return factorial;
    }

    /*
     * print sum of first n natural number
     * time :
     * space :
     */
    public static int sumNatural(int n) {
        int sum = 0;
        if (n == 1) {
            return 1;
        }
        sum = n + sumNatural(n - 1);
        return sum;
    }

    /*
     * print nth fibonacci number
     * input : 5
     * output : 0 1 2 3 5
     * time :
     * space :
     */
    public static int fibonacci(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 0) {
            return 0;
        }

        int fibn = fibonacci(n - 1) + fibonacci(n - 2);
        return fibn;
    }

    /*
     * is if given array is sorted or not
     * input : {1, 2, 3, 4, 5}
     * output : true
     * time :
     * space :
     */
    public static boolean isSorted(int arr[], int startingPoint) {
        if (startingPoint == arr.length - 1) {
            return true;
        } else if (arr[startingPoint] > arr[startingPoint + 1]) {
            return false;
        }
        return isSorted(arr, startingPoint + 1);
    }
}