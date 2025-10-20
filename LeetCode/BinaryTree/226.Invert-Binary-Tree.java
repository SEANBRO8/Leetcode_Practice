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
    // Traverse
    // TC: N: SC: N
    public TreeNode invertTree(TreeNode root) {
        traverse(root);
        return root;
    }

    public void traverse(TreeNode root){

        if(root == null) return;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        traverse(root.left);
        traverse(root.right);
    }
    // Recursion 
    // public TreeNode invertTree(TreeNode root) {
    //     if(root == null) return null;

    //     TreeNode left = invertTree(root.left);
    //     TreeNode right = invertTree(root.right);
    //     root.left = right;
    //     root.right = left;
    //     return root;
    // }

}
