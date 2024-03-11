/*
 * @lc app=leetcode id=652 lang=java
 *
 * [652] Find Duplicate Subtrees
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

    LinkedList<TreeNode> ans = new LinkedList<>();
    
    HashMap<String, Integer> map = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return ans;
    }

    public String traverse(TreeNode root){
        if(root == null) return "#";

        String left = traverse(root.left);
        String right = traverse(root.right);    
        
        String center = left+ ","+ right + "," + String.valueOf(root.val);

        if(map.getOrDefault(center, 0) == 1) ans.add(root);
        
        map.put(center, map.getOrDefault(center, 0) + 1);
        
        return center;

    }
}
// @lc code=end

