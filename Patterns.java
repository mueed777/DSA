public class Patterns {
    public static void main(String args[]) {
        // starPattern();
        // hollow_rectangle(5, 5);
        // floyd_triangle(5);
        // triangle_1_0(5);
        // butterflyPattern(5);
        // solidRhombus(10);
        // hollow_rhombus(5);
        diomond_pattern(4);
    }

    //Star Pattern (nested loop)
    public static void starPattern() {
        for(int line = 1; line <= 4; line++) {
            for(int star = 1; star <= line; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // Hollow Rectangle Pattern
    public static void hollow_rectangle(int totalRow, int totalCol) {
        //outer loop
        for (int i = 1; i <= totalRow; i++) {
            // inner loop
            for (int j = 1; j <= totalCol; j++) {
                if (i == 1 || i == totalRow || j == 1 || j == totalCol) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    // Floyd's Triangle pattern
    public static void floyd_triangle(int row) {
        int counter = 1;
        // outer loop - how many row
        for(int i = 1; i <= row; i++) {
            // inner loop - how many times will counter be printed
            for (int j = 1; j <= i; j++) {
                System.out.print(counter + " ");
                counter++;
            }
            System.out.println();
        }
    }

    // 01 triangle pattern
    public static void triangle_1_0(int row) {
        int counter = 1;
        // outer loop - amount of row
        for (int i = 1; i <= row; i++) {
            // inner loop - track 1 and 0
            for (int j = 1; j <= i; j++) {
                System.out.print(counter + " ");
                if (counter == 1) {
                    counter -= counter;
                } else {
                    counter++;
                }
            }
            System.out.println();
        }
    }

    // Butterfly pattern
    public static void butterflyPattern(int n) {
        // outer loop - 1st half row
        for (int i = 1; i <= n; i++) {
            // star - i
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            // space
            for (int j = 1; j <= 2 * (n-i); j++) {
                System.out.print(" ");
            }
            
            // star - i
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }


        for (int i = n; i >= 1; i--) {
            // star - i
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            // space
            for (int j = 1; j <= 2 * (n-i); j++) {
                System.out.print(" ");
            }
            
            // star - i
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // Solid Rhombus pattern
    public static void solidRhombus(int n) {
        int m = n;
        int k = n - 1;
        m -= n;
        // outer loop - keep track of rows
        for (int i = 1; i <= n; i++) {
            // space
            for (int j = 1; j <= k; j++) {
                System.out.print(" ");
            }

            // star
            for (int j = 1; j <= n; j++) {
                System.out.print("*");
            }

            // space
            for (int j = 0; j <= m; j++) {
                System.out.print(" ");
            }
            k--;
            m++;
            System.out.println();
        }
    }

    // Hollow Rhombus pattern
    // public static void hollow_rhombus(int n) {
    //     int space1 = n - 1;
    //     int space2 = n;
    //     int middleSpace = n - 2;
    //     space2 -= n;
    //     // outer loop
    //     for (int i = 1; i <= n; i++) {
    //         // first row
    //         if (i == 1) {
    //             for (int j = 1; j <= space1; j++) {
    //                 System.out.print(" ");
    //             }

    //             for (int j = 1; j <= n; j++) {
    //                 System.out.print("*");
    //             }
    //             System.out.println();
    //         }


    //         // middle-space
    //         if (i != 1 || i != n) {
    //             for (int j = 1; j<= space1 - 1; j++) {
    //                 System.out.print(" ");
    //             }
            
    //             System.out.print("*");

    //             // middle space
    //             for (int j = 1; j <= middleSpace; j++) {
    //                 System.out.print(" ");
    //             }
    //             System.out.print("*");

    //             for (int j = 1; j<= space2 + 1; j++) {
    //                 System.out.print(" ");
    //             }
    //             System.out.println();

    //         }

    //         // last row
    //         if (i == n) {
    //             for (int j = 1; j <= n; j++) {
    //                 System.out.print("*");
    //             }
    //             for (int j = 1; j <= space1; j++) {
    //                 System.out.print(" ");
    //             }
    //         }
    //         space2++;
    //         space1--;
    //     }
    // }

    public static void hollow_rhombus(int n) {
        for (int i = 1; i <= n; i++) {
            // spaces
            for (int j = 1; j <= (n - i); j++) {
                System.out.print(" ");
            }

            // hollow rectangle - stars
            for(int j = 1; j <= n; j++) {
                if (i == 1 || i == n || j == 1 || j == n) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }   
            System.out.println();
        }
    }

    // Dioamond pattern
    public static void diomond_pattern(int n) {
        // 1st half
        for (int i = 1; i <= n; i++) {
            // space
            for (int j = 1; j <= (n - i); j++) {
                System.out.print(" ");
            }

            // star - (2i - 1)
            for (int j = 1; j <= ((2 * i) - 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // 2nd half
        for (int i = n; i >= 1; i--) {
            // space
            for (int j = 1; j <= (n - i); j++) {
                System.out.print(" ");
            }

            // star - (2i - 1)
            for (int j = 1; j <= ((2 * i) - 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
