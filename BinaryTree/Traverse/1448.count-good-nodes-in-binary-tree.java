/*
 * @lc app=leetcode id=1448 lang=java
 *
 * [1448] Count Good Nodes in Binary Tree
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
    public int goodNodes(TreeNode root) {
        traverse(root, root.val);
        return ans;
    }

    public void traverse(TreeNode root, int max){

        if(root == null) return;

        if(root.val >= max){
            ans++;
        }

        max = Math.max(max, root.val);

        traverse(root.left, max);
        traverse(root.right, max);


    }
}
// @lc code=end

