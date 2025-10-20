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
    Map<Integer, Integer> inorderMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for(int i =0 ; i < inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length -1 , inorder, 0, inorder.length -1);
    }

    public TreeNode build(int[]preorder, int preStart, int preEnd, int[]inorder, 
    int inStart, int inEnd){
        // PreOrder root left right;
        // InOrder left root right;
        if(preStart > preEnd) return null;

        int rootVal = preorder[preStart];

        int rootIndex = inorderMap.get(rootVal);

        int leftSize = rootIndex - inStart;

        TreeNode root = new TreeNode(rootVal);

        root.left = build(preorder, preStart + 1, preStart + leftSize, inorder,
        inStart, rootIndex -1
        );

        root.right = build(preorder, preStart + leftSize + 1, preEnd, inorder, rootIndex  +1, inEnd);
        return root;
    }


}
