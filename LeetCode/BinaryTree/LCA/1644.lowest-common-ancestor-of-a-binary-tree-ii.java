/*
 * @lc app=leetcode id=1644 lang=java
 *
 * [1644] Lowest Common Ancestor of a Binary Tree II
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Boolean foundP = false;
    Boolean foundQ = false;    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ans = find(root, p, q);
        if(!foundP || !foundQ) return null;
        return ans;
    }

    public TreeNode find(TreeNode root, TreeNode p, TreeNode q){

        if(root == null) return null;

        TreeNode left = find(root.left, p, q);
        TreeNode right = find(root.right, p, q);

        if(left != null && right != null) return root;

        if(root.val == p.val || root.val == q.val){
            if(root.val == p.val) foundP = true;
            if(root.val == q.val) foundQ = true;
            return root;
        }

        return left == null ? right : left;

    }
}
// @lc code=end

