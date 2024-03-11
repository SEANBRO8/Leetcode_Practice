class Solution {
    // Solution one construct from post to pre
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
    // Solution two post to pre

    public TreeNode build(int[] preorder, int[] postorder, int preStart, int preEnd, int postStart, int postEnd){
        // pre:  N L R
        // post: L R N  
        if(postStart > postEnd) return null;
        if(postStart == postEnd) return new TreeNode(postorder[postEnd]);
        
        int rootValue = postorder[postEnd];
        int rightValue = postorder[postEnd - 1];

        int rightRootIndex = map.get(rightValue);

        int leftSize = rightRootIndex - preStart - 1;

        TreeNode root = new TreeNode(rootValue);        
        root.left = build(preorder, postorder, preStart + 1, preStart + leftSize, postStart, postStart + leftSize - 1 );
        root.right = build(preorder, postorder, preStart + leftSize + 1, preEnd, postStart + leftSize, postEnd - 1);

        return root;

    }
}
