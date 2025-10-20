/*
 * @lc app=leetcode id=297 lang=java
 *
 * [297] Serialize and Deserialize Binary Tree
 */

// @lc code=start

import java.util.LinkedList;
import java.util.Queue;




/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // BFS solution
    String NULL = "NULL";
    String SEP = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return NULL;
        Queue<TreeNode> queue = new LinkedList<>();

        StringBuilder sb = new StringBuilder();
        queue.offer(root);

        while(queue.size() > 0){
            TreeNode cur = queue.remove();
            if(cur == null){
                sb.append(NULL).append(SEP);
                continue;
            }
            sb.append(cur.val).append(SEP);
            queue.offer(cur.left);
            queue.offer(cur.right);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;

        String[] nodes = data.split(SEP);
        if(nodes[0].equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
    
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        int index = 1;

        while(queue.size() > 0){

            int size = queue.size();

            for(int i = 0; i < size; i++){
                TreeNode parent = queue.remove();
                String left = nodes[index++];

                if(!left.equals(NULL)){
                    parent.left = new TreeNode(Integer.valueOf(left));
                    queue.offer(parent.left);
                }
                String right = nodes[index++];
                
                if(!right.equals(NULL)){
                    parent.right = new TreeNode(Integer.valueOf(right));
                    queue.offer(parent.right);
                }
            }
        }
        return root;
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end

