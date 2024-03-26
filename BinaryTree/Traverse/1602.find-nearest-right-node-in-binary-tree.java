/*
 * @lc app=leetcode id=1602 lang=java
 *
 * [1602] Find Nearest Right Node in Binary Tree
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

    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        traverse(root, 0, u);
        return ans;
    }

    TreeNode ans = null;
    int targetDepth = -1;
    
    public void traverse(TreeNode root, int depth, TreeNode u){
        if(root == null || ans != null) return;

        if(u.val == root.val){
            targetDepth = depth;
        }
        else if(depth == targetDepth){
            ans = root;
            return;
        }
        traverse(root.left, depth + 1, u);
        traverse(root.right, depth + 1, u);



    }
}
// @lc code=end

