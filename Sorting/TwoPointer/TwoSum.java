package TwoPointer;

public class TwoSum{

    public int twoSumClosestOrEqual(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int best = Integer.MAX_VALUE; 

        while (l < r) {
            int sum = nums[l] + nums[r];

            if (sum == target) {
                return sum; 
            }

            if (Math.abs(sum - target) < Math.abs(best - target)) {
                best = sum;
            }

            if (sum < target) {
                l++;        
            } else {
                r--;        
            }
        }
        return best; 
    }

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int l = 0, r = n - 1, idx = n - 1;

        while (l <= r) {
            int left = nums[l] * nums[l];
            int right = nums[r] * nums[r];
            if (left > right) {
                res[idx--] = left;
                l++;
            } else {
                res[idx--] = right;
                r--;
            }
        }
        return res;
    }
}

