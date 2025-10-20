/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // SC: N TC: N * N
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums, int left, int right){
        if(nums.length == 0) return null;
        if(left > right) return null; 
        // look for the max value
        int maxIndex = -1;
        int max = Integer.MIN_VALUE;
        for(int i = left; i <= right; i++){
            if(nums[i] > max){
                max = nums[i];
                maxIndex = i;
            }
        }

        // Build Root
        TreeNode root = new TreeNode(max);

        TreeNode leftN = build(nums, left, maxIndex - 1);
        TreeNode rightN = build(nums, maxIndex + 1, right);
        root.left = leftN;
        root.right = rightN;

        return root;
    }
}
