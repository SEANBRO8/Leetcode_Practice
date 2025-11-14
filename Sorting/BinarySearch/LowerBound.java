package BinarySearch;

public class LowerBound {
    public int lowerBound(int[]nums, int target){
        int l = 0, r = nums.length - 1;
        // look for left bound
        while(l <= r){
            int m = l + (r - l) / 2;
            if(nums[m] >= target){
                r = m - 1;
            }else l = m + 1;
        }
        return l;
    }
}
