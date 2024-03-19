import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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
    // BSF
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode last = queue.peek();
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                TreeNode cur = queue.remove();
                if(cur.right != null){
                    queue.offer(cur.right);
                }
                if(cur.left != null){
                    queue.offer(cur.left);
                }
            }
            ans.add(last.val);
        }
        return ans;
    }
}
// @lc code=end

