/*
 * @lc app=leetcode id=1457 lang=java
 *
 * [1457] Pseudo-Palindromic Paths in a Binary Tree
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
    int[] counts = new int[10];
    public int pseudoPalindromicPaths (TreeNode root) {
        traverse(root);
        return ans;
    }

    public void traverse(TreeNode root){
        if(root == null) return;

        if(root.left == null && root.right == null){
            int odd = 0;
            counts[root.val]++;
            for(int count : counts){
                if(count % 2 == 1) odd++;
            }

            if(odd <= 1) ans++;
            counts[root.val]--;
        }

        counts[root.val]++;
        traverse(root.left);
        traverse(root.right);
        counts[root.val]--;
    }
}
// @lc code=end

