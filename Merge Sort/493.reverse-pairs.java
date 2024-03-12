/*
 * @lc app=leetcode id=493 lang=java
 *
 * [493] Reverse Pairs
 */

// @lc code=start
class Solution {
    int[] temp;
    int count = 0;
    public int reversePairs(int[] nums) {
        int n = nums.length;
        temp = new int[n];
        sort(0, n - 1, nums);

        return count;
    }

    public void sort(int start, int end, int[]nums){

        if(end == start) return;

        int mid = start + (end - start) / 2;

        sort(start, mid, nums);
        sort(mid + 1, end, nums);
        merge(start, end, mid, nums);

    }

    public void merge(int start, int end, int mid,int[]nums){

        for(int i = start; i <= end; i++){
            temp[i] = nums[i];
        }

        int afterMid = mid + 1;

        for(int i = start; i <= mid; i++){
            while(afterMid <= end && (long)nums[i] > 2 * (long)nums[afterMid]){
                afterMid++;
            }
            count += afterMid - mid - 1;
        }

        int i = start, j = mid + 1;

        for(int p = start; p <= end; p++){

            if(i == mid + 1){
                nums[p] = temp[j++];
            }else if(j == end + 1){
                nums[p] = temp[i++];                
            }else if(temp[i] > temp[j]){
                nums[p] = temp[j++];
            }else{
                nums[p] = temp[i++];                
            }
        }

    }
}
// @lc code=end

