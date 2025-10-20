import java.util.List;
/*
 * @lc app=leetcode id=971 lang=java
 *
 * [971] Flip Binary Tree To Match Preorder Traversal
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
    List<Integer> ans = new ArrayList<Integer>();
    int i = 0;
    int[] voyage;
    boolean canFlip = true;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        this.voyage = voyage;

        traverse(root);

        if(canFlip) return ans;
        return Arrays.asList(-1);
    }

    public void traverse(TreeNode root){

        if(root == null && !canFlip){
            return;
        }
        if(root.val != voyage[i++]){
            canFlip = false;
            return;
        }

        if(root.left != null && root.left.val != voyage[i]){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            ans.add(root.val);
        }

        traverse(root.left);
        traverse(root.right);


    }
}
// @lc code=end

