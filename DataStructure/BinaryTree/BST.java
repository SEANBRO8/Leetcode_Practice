package BinaryTree;
import java.util.HashMap;

public class BST {
    

    public TreeNode buildBSTfromArray(int[]arr){
        if (arr == null || arr.length == 0) return null;
        return buildOne(arr, 0, arr.length - 1);
    }
    // Build from sorted arr
    public TreeNode buildOne(int[]arr, int left, int right){
        // 1 - 2 - 3 - 4
        if(left > right) return null;
        int mid = left + (right - left) / 2; 

        TreeNode root = new TreeNode(arr[mid]);
        
        root.left = buildOne(arr, left, mid - 1);
        root.right = buildOne(arr, mid + 1, right);
        return root;
    }   
    // build from preOrder and InOrder
    public TreeNode buildFromPreIn(int[] preOrder, int[] inOrder){

        if(preOrder == null || inOrder == null) return null;
        for(int i = 0; i < inOrder.length; i++){
            this.mapOne.put(inOrder[i], i);
        }

        return buildTwo(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);

    }
    private final HashMap<Integer, Integer> mapOne = new HashMap<Integer, Integer>();
    
    public TreeNode buildTwo(int[]preOrder, int preStart, int preEnd, int[]inOrder, int inStart, int inEnd){
    
        if (preStart > preEnd || inStart > inEnd) return null;
        int rootVal = preOrder[preStart];
        int rootIndex = mapOne.get(rootVal);
        int leftSize = rootIndex - inStart;
        TreeNode root = new TreeNode(rootVal);

        root.left = buildTwo(preOrder, preStart+1, preStart + leftSize, inOrder, inStart, rootIndex - 1);
        root.right = buildTwo(preOrder, preStart + leftSize + 1, preEnd, inOrder, rootIndex + 1, inEnd);
        return root;
    }   

    // build from postOrder and InOrder
    HashMap<Integer, Integer> mapTwo = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] inOrder, int[] postOrder) {
        
        for(int i = 0; i < inOrder.length; i++){
            mapTwo.put(inOrder[i], i);
        }

        return buildThree(postOrder, 0, inOrder.length - 1, inOrder,  0,  inOrder.length - 1);
    }
    
    public TreeNode buildThree(int[]postOrder, int postStart, int postEnd, int[]inOrder, int inStart, int inEnd){
    
        if(postEnd < postStart || inStart > inEnd) return null;
        int rootVal = postOrder[postEnd];
        int rootIndex = mapTwo.get(rootVal);
        int leftSize = rootIndex - inStart;
        TreeNode root = new TreeNode(rootVal);

        root.left = buildThree(postOrder, postStart, postStart + leftSize - 1, inOrder, inStart, rootIndex - 1);
        root.right = buildThree(postOrder, postStart + leftSize, postEnd - 1, inOrder, rootIndex + 1, inEnd);
        return root;
    }   

    // search
    public boolean search(TreeNode root, int target){
        if(root == null) return false;

        if(root.val < target ) return search(root.right, target);
        else if(root.val > target ) return search(root.left, target);
        else return true;
    }

    public TreeNode insert(TreeNode root, int val){

        if(root == null) return new TreeNode(val);

        if(root.val < val){
            root.right = insert(root.right, val);
        }else if(root.val > val){
            root.left = insert(root.left, val);
        }
        return root;
    }
    // return root of BST
    public TreeNode remove(TreeNode root, int val){

        if(root == null) return null;

        if(root.val < val ) root.right = remove(root.right, val);
        else if(root.val > val) root.left = remove(root.left, val);
        else{
            if(root.left == null) return root.right;
            else if(root.right == null) return root.left;
            else {
                TreeNode min = findMin(root.right);
                root.val = min.val;
                root.right = remove(root.right, min.val);
            }
        }

        return root;
    }

    public TreeNode findMin(TreeNode root){
       if(root == null) return null;

        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

}