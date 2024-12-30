// Array 2D // testing 1 2 3

import java.util.Scanner;

public class Array2D {
    public static void main(String[] args) {
        print2DArray();
    }

    public static void print2DArray() {
        int matrix[][] = new int[3][3];
        int n = matrix.length, m = matrix[0].length;

        Scanner sc = new Scanner(System.in);

        // input
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // output - print
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // search(matrix, 10);
    }

    public static boolean search(int matrix[][], int key) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == key) {
                    System.out.println("Found at (" + i + ", " + j + ")");
                    return true;
                }
            }
        }
        System.out.println("Could not find");
        return false;
    }
}