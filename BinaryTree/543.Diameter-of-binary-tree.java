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
    // traverse method
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
     
        int depth = traverse(root);

        return diameter;
    }


    public int traverse(TreeNode root){

        if(root == null) return 0;

        int left = traverse(root.left);
        int right = traverse(root.right);
        diameter = Math.max(left + right, diameter);

        return Math.max(left, right) + 1;

    }
    

}