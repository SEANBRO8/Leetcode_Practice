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
    int depth = 0;
    int ans = 0;
    public int maxDepth(TreeNode root) {
        traverse(root);
        return ans;
    }

    public void traverse(TreeNode root){

        if(root == null) return;
        depth++;
        
        if(root.left == null && root.right == null){
            ans = Math.max(ans, depth);
        }
        traverse(root.left);
        traverse(root.right);
        depth--;
    }
}
