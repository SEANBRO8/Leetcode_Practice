/*
 * @lc app=leetcode id=530 lang=java
 *
 * [530] Minimum Absolute Difference in BST
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

    TreeNode prev = null;
    int ans = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        traverse(root);
        return ans;
    }

    public void traverse(TreeNode root){

        if(root == null) return;

        traverse(root.left);

        if(prev != null) ans = Math.min(root.val - prev.val, ans);
        prev = root;
        traverse(root.right);       

    }
}
// @lc code=end

