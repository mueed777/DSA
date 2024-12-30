public class AssignmentArray {
    public static void main(String args[]) {
        
    }

    /*
     * Question 1
     */
    public static boolean containDuplicate(int nums[]) {
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
     * Question 2
     */
    public int search(int[] nums, int target) {
        int min = minSearch(nums);

        if(nums[min] <= target && target <= nums[nums.length - 1]) {
            return search(nums, min, nums.length - 1, target);
        } else {
            return search(nums, 0, min, target);
        }
    }

    private int search(int[] nums, int left, int right, int target) {
        int l = left;
        int r = right;

        while (l <= r) {
            int mid = (l + (r - l)) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    private int minSearch(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            int mid = (left + (right - left)) / 2;
            if(mid > 0 && nums[mid - 1] > nums[mid]) {
                return mid;
            } else if (nums[left] <= nums[mid] && nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }


    /*
     * Question 3
     */
    public static int maxProfit(int[] prices) {
        int buy = prices[0];
        int profit = 0;

        for(int i = 1; i < prices.length - 1; i++) {
            if (buy < prices[i]) {
                profit = Math.max(prices[i] - buy, profit);
            } else {
                buy = prices[i];
            }
        }
        return profit;
    }

}