/*
 * @lc app=leetcode id=315 lang=java
 *
 * [315] Count of Smaller Numbers After Self
 */

// @lc code=start
class Solution {

    Pair[] temp;
    int[] count;
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<>();  
        
        temp = new Pair[nums.length];
        count = new int[nums.length];
        Pair[] arr = new Pair[nums.length];

        for(int i = 0; i < nums.length; i++){
            arr[i] = new Pair(nums[i], i);
        }

        sort(arr, 0, arr.length - 1);


        for(int i = 0 ; i < count.length; i++){
            ans.add(count[i]);
        }

        return ans;
    }

    public void sort(Pair[] nums, int start, int end){


        if(end == start) return;

        int mid = start + (end - start) / 2;

        sort(nums, start, mid);
        sort(nums, mid + 1, end);

        merge(nums, start, end, mid);
    }

    public void merge(Pair[] nums, int start, int end, int mid){

        for(int i = start; i <= end; i++){
            temp[i] = nums[i];
        }
        int i = start, j = mid + 1;

        for(int p = start; p <= end; p++){
            if(i == mid + 1){
                nums[p] = temp[j++];
            }else if(j == end + 1){
                nums[p] = temp[i++];
                count[nums[p].id] += j - mid - 1;
            }else if(temp[i].value > temp[j].value){
                nums[p] = temp[j++];
            }else{
                nums[p] = temp[i++];
                count[nums[p].id] += j - mid - 1;
            }
        }

    }
}

class Pair{

    int value;
    int id;   

    Pair(int value , int id){
        this.value = value;
        this.id = id;
    }
}
// @lc code=end

