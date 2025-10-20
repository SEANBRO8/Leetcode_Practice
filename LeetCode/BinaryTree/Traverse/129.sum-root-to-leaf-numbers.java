/*
 * @lc app=leetcode id=129 lang=java
 *
 * [129] Sum Root to Leaf Numbers
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
    StringBuilder num = new StringBuilder();

    public int sumNumbers(TreeNode root) {
        traverse(root);
        return ans;
    }

    public void traverse(TreeNode root){
        if(root == null) return;

        if(root.left == null && root.right == null){
            num.append(root.val);
            ans += Integer.valueOf(String.valueOf(num));
            num.deleteCharAt(num.length() - 1);
            return;
        }

        num.append(root.val);
        traverse(root.left);
        traverse(root.right);
        num.deleteCharAt(num.length() - 1);

    }
}
// @lc code=end

