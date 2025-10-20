/*
 * @lc app=leetcode id=167 lang=java
 *
 * [167] Two Sum II - Input Array Is Sorted
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // TC: N SC: 1
        // Two Pointer
        int left = 0, right = numbers.length - 1;

        int[] ans = new int[2];

        while(left < right){

            int sum = numbers[left] + numbers[right];

            if(sum == target){
                ans[0] = left + 1;
                ans[1] = right + 1;
                return ans;
            }else if(sum > target){
                right--;
            }else{
                left++;
            }            
        }

        return ans;
    }
}
// @lc code=end

