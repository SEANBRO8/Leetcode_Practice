import java.util.List;
/*
 * @lc app=leetcode id=199 lang=java
 *
 * [199] Binary Tree Right Side View
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
    // DFS solution
    List<Integer> ans = new ArrayList<>();
    int depth = 0;
    public List<Integer> rightSideView(TreeNode root) {
        traverse(root);
        return ans;
    }

    public void traverse(TreeNode root){

        if(root == null) return;
        depth++;
        if(ans.size() < depth) ans.add(root.val);
        traverse(root.right);
        traverse(root.left);  
        depth--;     

    }
}
// @lc code=end

