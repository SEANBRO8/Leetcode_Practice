package BinaryTree;
import java.util.ArrayList;
import java.util.List;


public class TreeMap {
    TreeNode root;

    public TreeMap(){
        root = null;
    }

    public void insect(int key, int val){
        if(root == null){
            root = new TreeNode(key, val);
        }else{
            TreeNode cur = root;
            while(cur != null){
                if(cur.key < key){
                    if(cur.right == null){
                        cur.right = new TreeNode(key, val);
                        break;
                    }
                    cur = cur.right;
                }else if(cur.key > key){
                    if(cur.left == null){
                        cur.left = new TreeNode(key, val);
                        break;
                    }
                    cur = cur.left;
                }else{
                    cur.val = val;
                    break;
                }
            }
        }
    }

    public int get(int key){
        if(root == null) return -1;

        TreeNode cur = dfsGet(key, root);

        return cur == null? -1 : cur.val;
    }

    public TreeNode dfsGet(int key, TreeNode root){
        if(root == null) return null;
        TreeNode cur = root;
        if(cur.key < key){
            return dfsGet(key, cur.right);
        }
        if(cur.key > key){
            return dfsGet(key, cur.left);
        }
        return cur;
    }

    public int getMin(){
        if(root == null) return -1;
        return findMin(root).val;
    }

    public TreeNode findMin(TreeNode root){
        if(root == null) return null;
        TreeNode cur = root;

        while(cur.left != null){
            cur = cur.left;
        }
        return cur;
    }

    public int getMax(){
        if(root == null) return -1;
        return findMax(root).val;
    }

    public TreeNode findMax(TreeNode root){
        if(root == null) return null;
        TreeNode cur = root;

        while(cur.right != null){
            cur = cur.right;
        }
        return cur;
    }

    public void remove(int key){
        root = removeKey(key, root);
    }

    public TreeNode removeKey(int key, TreeNode root){

        if(root == null) return null;

        if(key < root.key){
            root.left = removeKey(key, root.left);
        }
        if(key > root.key){
            root.right = removeKey(key, root.right);
        }
        if(key == root.key){
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            else{
                TreeNode min = findMin(root.right);
                root.val = min.val;
                root.key = min.key;
                root.right = removeKey(min.key, root.right);
            }
        }
        return root;
    }

    public List<Integer> getInorderKeys() {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        dfs(root, ans);
        return ans;
    }

     public void dfs(TreeNode root, List<Integer> ans){
        if(root == null) return;
        dfs(root.left, ans);
        ans.add(root.key);
        dfs(root.right, ans);
    }

    public static class TreeNode {
        TreeNode left, right;
        int key, val;
        public TreeNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
