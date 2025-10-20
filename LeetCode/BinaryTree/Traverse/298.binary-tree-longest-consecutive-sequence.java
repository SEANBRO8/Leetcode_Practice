/*
 * @lc app=leetcode id=298 lang=java
 *
 * [298] Binary Tree Longest Consecutive Sequence
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
    int ans = 0;
    public int longestConsecutive(TreeNode root) {
        traverse(root, 1, Integer.MIN_VALUE);
        return ans;
    }

    public void traverse(TreeNode root, int len, int parentVal){
        if(root == null) return;

        if(root.val == parentVal + 1){
            len++;
        }else{
            len = 1;
        }

        ans = Math.max(ans, len);
        traverse(root.left, len, root.val);
        traverse(root.right, len, root.val);
    }
}
// @lc code=end

