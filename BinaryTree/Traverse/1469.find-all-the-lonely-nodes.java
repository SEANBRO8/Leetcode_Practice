import java.util.List;
/*
 * @lc app=leetcode id=1469 lang=java
 *
 * [1469] Find All The Lonely Nodes
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
    List<Integer> ans = new ArrayList<>();
    public List<Integer> getLonelyNodes(TreeNode root) {
        traverse(root);
        return ans;
    }

    public void traverse(TreeNode root) {

        if(root == null) return;

        if(root.left == null && root.right != null){
            ans.add(root.right.val);
        }
        if(root.right == null && root.left != null){
            ans.add(root.left.val);
        }

        traverse(root.left);
        traverse(root.right);


    }
}
// @lc code=end

