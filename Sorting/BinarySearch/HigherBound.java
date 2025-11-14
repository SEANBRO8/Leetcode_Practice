package BinarySearch;

public class HigherBound {
    public int higherBound(int[]nums, int target){
        int l = 0, r = nums.length - 1;
        // look for left bound
        while(l <= r){
            int m = l + (r - l) / 2;
            if(nums[m] <= target){
                l = m + 1;
            }else r = m - 1;
        }
       
        return l;
    }
}
