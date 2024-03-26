/*
 * @lc app=leetcode id=270 lang=java
 *
 * [270] Closest Binary Search Tree Value
 */

// @lc code=start
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
    int ans = Integer.MAX_VALUE;
    public int closestValue(TreeNode root, double target) {
        traverse(root, target);
        return ans;
    }

    public void traverse(TreeNode root, double target){
        if(root == null) return;

        if(root.val < target){
            if(Math.abs(root.val - target) < Math.abs(ans - target)){
                ans = root.val;
            }
            traverse(root.right, target);
        }else{
            traverse(root.left, target);
            if(Math.abs(root.val - target) < Math.abs(ans - target)){
                ans = root.val;
            } 
        }

    }
}
// @lc code=end

