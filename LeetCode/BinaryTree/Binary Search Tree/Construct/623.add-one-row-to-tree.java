/*
 * @lc app=leetcode id=623 lang=java
 *
 * [623] Add One Row to Tree
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
    int curDepth = 0;
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(root == null) return root;

        if(depth == 1){
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        traverse(root, depth, val);
        return root;
    }

    public void traverse(TreeNode root, int depth, int val) {
        
        if(root == null) return;
        curDepth++;

        if(curDepth == depth - 1){
            TreeNode leftN = new TreeNode(val);
            TreeNode rightN = new TreeNode(val);
            
            leftN.left= root.left;
            rightN.right= root.right;

            root.left = leftN;
            root.right = rightN;
        }

        traverse(root.left, depth, val);
        traverse(root.right, depth, val);

        curDepth--;
    }
}
// @lc code=end

