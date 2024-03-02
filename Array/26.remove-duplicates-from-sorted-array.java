package Array;
/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        
        int n = nums.length;
        int slow = 0, fast = 0;
        while(fast < n){

            if(nums[slow] != nums[fast]){
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;

        /**
         * 
         *  int j = 1; 
         *  int n = nums.length
         * for(int i = 1; i < n; i++){
         * 
         *      if(nums[i] != nums[i - 1]){
         * 
         *          nums[j] = nums[i];
         *          j++;
         *      }
         *
         * }
         * 
         *  return j 
         * 
         * 
         */
    }
}
// @lc code=end

