// ArrayLists

import java.util.*;

public class ArrayLists {
    public static void main(String args) {

    }

    /*
     * container with most water (two pointers)
     * time :
     * space :
     */
    public static int maxArea(ArrayList<Integer> height) {
        int leftPointer = 0, rightPointer = height.size() - 1, width, currHeight, area, maxArea = 0;

        while (leftPointer < rightPointer) {
            width = rightPointer - leftPointer;
            currHeight = Math.min(height.get(leftPointer), height.get(rightPointer));
            area = width * currHeight;

            if (maxArea < area) {
                maxArea = area;
            }

            if (height.get(leftPointer) < height.get(rightPointer)) {
                leftPointer++;
            } else { // height.get(leftPointer) >= height.get(rightPointer)
                rightPointer--;
            }
        }
        return maxArea;
    }

    /*
     * find if any pair in a sorted ArrayList has a target sum (two pointers)
     * input : [1, 2, 3, 4, 5, 6], target = 5
     * output: true
     * time : O(n^2) (use two pointers when list is 'sorted' or try to use different
     * technique for optimal solution)
     * space :
     */
    public static boolean isPairSum(ArrayList<Integer> arrayList, int target) {
        int leftPointer = 0;
        int rightPointer = leftPointer + 1;

        while (leftPointer != arrayList.size() - 1) {
            int sum = arrayList.get(leftPointer) + arrayList.get(rightPointer);

            if (sum == target) {
                return true;
            }

            if (rightPointer == arrayList.size() - 1) {
                sum = arrayList.get(leftPointer) + arrayList.get(rightPointer);
                if (sum == target) {
                    return true;
                }
                leftPointer++;
                rightPointer = 0;
                rightPointer = leftPointer + 1;
            } else {
                rightPointer++;
            }
        }
        return false;
    }

    /*
     * 
     */
    public static boolean isPairSum2(ArrayList<Integer> array, int target) {
        int breakingPoint = -1;
        int n = array.size();
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > array.get(i + 1)) { // array sorted
                breakingPoint = i;
                break;
            }
        }

        int lp = breakingPoint + 1; // smallest
        int rp = breakingPoint; // largest

        while (lp != rp) {
            int sum = array.get(lp) + array.get(rp);
            if (sum == target) {
                return true;
            } else if (sum < target) {
                lp = (lp + 1) % n; // rotate right
            } else { // sum > target
                rp = (n + rp - 1) % n;
            }
        }
        return false;
    }
}
