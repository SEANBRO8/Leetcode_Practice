class Solution {
    public boolean verifyTreeOrder(int[] postorder) {
        return check(postorder, 0 , postorder.length - 1);
    }

    public boolean check(int[]postorder, int start, int end){

        if(start >= end) return true;

        int root = postorder[end];

        int left = start;

        while(left < end && postorder[left] < root){
            left++;
        }

        int right = left;

        while(left < end && postorder[right] > root){
            right++;
        }

        if(right != end) return false;

        return check(postorder, start, left - 1) && check(postorder, left, end - 1); 
    }

    
}
