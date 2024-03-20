/*
 * @lc app=leetcode id=1022 lang=java
 *
 * [1022] Sum of Root To Leaf Binary Numbers
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
    int path = 0;
    public int sumRootToLeaf(TreeNode root) {
        traverse(root);
        return ans;
    }

    public void traverse(TreeNode root){
        if(root == null) return;

        if(root.left == null && root.right == null){
            ans += path << 1 | root.val;
            return;
        }
        path = path << 1 | root.val;
        traverse(root.left);
        traverse(root.right);
        path = path >> 1;

    }
}
// @lc code=end

