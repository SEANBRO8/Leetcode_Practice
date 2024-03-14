/*
 * @lc app=leetcode id=1650 lang=java
 *
 * [1650] Lowest Common Ancestor of a Binary Tree III
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node a = p, b = q;

        while(a != b){

            if(a == null) a = q;
            else a = a.parent;
            if(b == null) b = p;
            else b = b.parent;

        }

        return a;
    }
}
// @lc code=end

