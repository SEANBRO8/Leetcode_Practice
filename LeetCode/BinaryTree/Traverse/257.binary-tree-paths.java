/*
 * @lc app=leetcode id=257 lang=java
 *
 * [257] Binary Tree Paths
 */

// @lc code=start

import java.util.List;

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
    // record the ans
    List<String> ans = new ArrayList<>();
    // record the path
    List<String> path = new ArrayList<>();   
    public List<String> binaryTreePaths(TreeNode root) {
        traverse(root);
        return ans;
    }

    public void traverse(TreeNode root){

        if(root == null){
            return;
        }
        // base case 
        if(root.left == null && root.right == null){
            path.add(root.val +"");
            ans.add(String.join("->", path));
            path.remove(path.size()-1);  
            return;
        }
        // preorder traversal
        path.add(root.val +"");
        traverse(root.left);
        traverse(root.right);  
        path.remove(path.size()-1);      

    }
}
// @lc code=end

