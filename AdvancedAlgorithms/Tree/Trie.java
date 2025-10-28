package Tree;
import java.util.*;

public class Trie {
    TreeNode root;

    public Trie(){
        root = new TreeNode();
    }

    public void insect(String word){
        TreeNode cur = this.root;

        for(char ch : word.toCharArray()){

            if(!root.children.containsKey(ch)){
                root.children.put(ch, new TreeNode());
            }
            cur = cur.children.get(cur);
        }

        // finish the insection
        cur.word = true;
    }

    public boolean search(String word){
        TreeNode cur = this.root;
        
        for(char ch : word.toCharArray()){
            if(!cur.children.containsKey(ch)) return false;
            cur = cur.children.get(ch);
        }

        return cur.word;
    }

    public boolean startsWith(String prefix){
        TreeNode cur = this.root;

        for(char ch : prefix.toCharArray()){
            if(!cur.children.containsKey(ch)) return false;
            cur = cur.children.get(ch);
        }

        return true;
    }

}

class TreeNode{

    boolean word; // isLeaf ?
    HashMap<Character, TreeNode> children = new HashMap<>();

}
