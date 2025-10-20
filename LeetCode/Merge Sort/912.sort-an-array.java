/*
 * @lc app=leetcode id=912 lang=java
 *
 * [912] Sort an Array
 */

// @lc code=start
class Solution {
    int[] temp;
    public int[] sortArray(int[] nums) {
        temp = new int[nums.length];
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    public void sort(int[] nums, int start, int end){
        if(end == start) return;
        int mid = start + (end - start) / 2;

        sort(nums, start, mid);
        sort(nums, mid + 1, end);        
        merge(nums, start, end, mid);
    }

    public void merge(int[] nums, int start, int end, int mid){

        for(int i = start; i <= end; i++){
            temp[i] = nums[i];
        }

        int i = start, j = mid + 1;
        
        for(int p = start ; p <= end; p++){
            if(i == mid + 1){
                nums[p] = temp[j++];
            }else if(j == end + 1){
                nums[p] = temp[i++];
            }else if(temp[i] <= temp[j]){
                nums[p] = temp[i++];
            }else{
                nums[p] = temp[j++];
            }
        }
    }
}
// @lc code=end

