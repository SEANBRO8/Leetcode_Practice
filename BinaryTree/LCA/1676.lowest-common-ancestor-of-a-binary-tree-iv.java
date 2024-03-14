package LCA;
/*
 * @lc app=leetcode id=1676 lang=java
 *
 * [1676] Lowest Common Ancestor of a Binary Tree IV
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;


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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Set<TreeNode> set = new HashSet<>();

        for(TreeNode node : nodes){
            set.add(node);
        }
        return search(root, set);
    }

    public TreeNode search(TreeNode root, Set<TreeNode> set){
        if(root == null) return null;

        if(set.contains(root)) return root;

        TreeNode left = search(root.left, set);
        TreeNode right = search(root.right, set);

        if(left != null && right != null) return root;

        if(left != null) return left;
        else return right;


    }
}
// @lc code=end

