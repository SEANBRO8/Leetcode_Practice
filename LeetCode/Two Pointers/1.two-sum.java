/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start
class Solution {

    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int[] ans = new int[2];
        while(left < right) {
            int sum = nums[left] + nums[right];
            if(sum == target){
                ans[0] = left;
                ans[1] = right;
                return ans;
            }
            else if(sum != target && left != right - 1) { 
                right--;
                continue;
            }else{
                left++;
                right = nums.length - 1;
            }
        }
        return ans;
    }
}
// @lc code=end

