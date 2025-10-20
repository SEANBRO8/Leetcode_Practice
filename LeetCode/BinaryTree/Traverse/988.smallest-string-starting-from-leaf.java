/*
 * @lc app=leetcode id=988 lang=java
 *
 * [988] Smallest String Starting From Leaf
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

    StringBuilder sb = new StringBuilder();
    String ans = "";

    public String smallestFromLeaf(TreeNode root) {
        traverse(root);
        return ans.toString();
    }

    public void traverse(TreeNode root){

        if(root == null) return;

        if(root.left == null && root.right == null){

            sb.append( (char)(root.val + 'a'));
            sb.reverse();
            if(sb.toString().compareTo(ans) < 0 || ans == "" ) ans = sb.toString();
            sb.reverse();
            sb.deleteCharAt(sb.length() - 1);      
            return;      
        }

        sb.append( (char)(root.val + 'a'));
        traverse(root.left);
        traverse(root.right);
        sb.deleteCharAt(sb.length() - 1);    

    }
}
// @lc code=end

