/*
 * @lc app=leetcode id=297 lang=java
 *
 * [297] Serialize and Deserialize Binary Tree
 */

// @lc code=start

import java.util.LinkedList;

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
    // DFS solution
    String NULL = "NULL";
    String sep = ",";

    StringBuilder sb = new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        serilize(root);
        return sb.toString();
    }

    public void serilize(TreeNode root){
        if(root == null){
            sb.append(NULL);
            sb.append(sep);      
            return;      
        } 

        sb.append(String.valueOf(root.val)).append(sep);

        serilize(root.left);
        serilize(root.right);        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> list = new LinkedList<>();
        for(String s : data.split(sep)){
            list.addLast(s);
        }
        
        return deserialize(list);

    }

    public TreeNode deserialize(LinkedList<String> list) {
        if(list.isEmpty()) return null;
        String first = list.removeFirst();
        if(first.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.valueOf(first));

        root.left = deserialize(list);
        root.right = deserialize(list);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end

