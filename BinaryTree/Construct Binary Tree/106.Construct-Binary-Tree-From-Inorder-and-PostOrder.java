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
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }

        return build(inorder,  postorder, 0, inorder.length-1, 0, postorder.length - 1);
    }

    public TreeNode build(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd){
       if(postEnd < postStart) return null;

       int rootVal = postorder[postEnd];
       int rootIndex = map.get(rootVal);

       int leftSize = rootIndex - inStart;

       TreeNode root = new TreeNode(rootVal);

       root.left = build(inorder, postorder, inStart, rootIndex -1, postStart, postStart+leftSize - 1);
       root.right = build(inorder, postorder, rootIndex + 1, inEnd, postStart+leftSize, postEnd -1);

       return root;


    }
}
