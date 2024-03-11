class Solution {
    
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for(int i = 0; i < postorder.length;i++){
            map.put(postorder[i], i);
        }
        return build(preorder, postorder, 0, preorder.length - 1, 0,postorder.length -1 );
    }

    public TreeNode build(int[] preorder, int[] postorder, int preStart, int preEnd, int postStart, int postEnd){

        if(preStart > preEnd) return null;
        if(preStart == preEnd) return new TreeNode(preorder[preStart]);

        int rootVal = preorder[preStart];
        int leftRootVal = preorder[preStart + 1];

        int leftRootValIndex = map.get(leftRootVal);

        int leftSize = leftRootValIndex + 1 - postStart;

        TreeNode root = new TreeNode(rootVal);

        root.left = build(preorder, postorder, preStart + 1, leftSize + preStart, postStart, leftRootValIndex);
        root.right = build(preorder, postorder, leftSize + preStart + 1, preEnd, leftRootValIndex + 1, postEnd -1);
        return root;
    }
}
