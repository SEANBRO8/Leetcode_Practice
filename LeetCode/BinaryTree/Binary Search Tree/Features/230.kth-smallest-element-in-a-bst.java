/*
 * @lc app=leetcode id=230 lang=java
 *
 * [230] Kth Smallest Element in a BST
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
    List<Integer> list = new ArrayList<>();
    
    public int kthSmallest(TreeNode root, int k) {
        traverse(root);
        return list.get(k - 1);
    }

    public void traverse(TreeNode root){
        if(root == null) return;

        traverse(root.left);
        list.add(root.val);
        traverse(root.right);
    }
}
// @lc code=end

