package Tree;

public class BSTOperations {

    // -----------------------------
    // TreeNode Definition
    // -----------------------------
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }

    // -----------------------------
    // 1. Search in BST
    // -----------------------------
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        if (val < root.val) return searchBST(root.left, val);
        else return searchBST(root.right, val);
    }

    // -----------------------------
    // 2. Insert into BST
    // -----------------------------
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        if (val < root.val) root.left = insertIntoBST(root.left, val);
        else root.right = insertIntoBST(root.right, val);

        return root;
    }

    // -----------------------------
    // 3. Delete Node from BST (LC450)
    // -----------------------------
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Found the node
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // Two children: replace with successor (min in right subtree)
            TreeNode successor = findMin(root.right);
            root.val = successor.val;

            root.right = deleteNode(root.right, successor.val);
        }
        return root;
    }

    // Helper: find minimum node (successor)
    public TreeNode findMin(TreeNode node) {
        while (node.left != null) node = node.left;
        return node;
    }

    // Helper: find maximum node
    public TreeNode findMax(TreeNode node) {
        while (node.right != null) node = node.right;
        return node;
    }

    // -----------------------------
    // 4. Validate BST (Upper/Lower Bound Method, LC98)
    // -----------------------------
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;

        return validate(node.left, min, node.val) &&
               validate(node.right, node.val, max);
    }

    // -----------------------------
    // 5. Validate BST via Inorder (Strictly Increasing)
    // -----------------------------
    Long prev = null;

    public boolean isValidBSTInorder(TreeNode root) {
        prev = null;
        return inorderValidate(root);
    }

    private boolean inorderValidate(TreeNode node) {
        if (node == null) return true;

        if (!inorderValidate(node.left)) return false;

        if (prev != null && node.val <= prev) return false;
        prev = (long) node.val;

        return inorderValidate(node.right);
    }

    // -----------------------------
    // 6. Kth Smallest in BST (Inorder Traversal)
    // -----------------------------
    int count = 0, result = -1;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorderKth(root);
        return result;
    }

    private void inorderKth(TreeNode node) {
        if (node == null || count == 0) return;

        inorderKth(node.left);

        if (--count == 0) {
            result = node.val;
            return;
        }

        inorderKth(node.right);
    }

    // -----------------------------
    // 7. LCA in BST (LC235)
    // -----------------------------
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);

        if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);

        return root;
    }

    // -----------------------------
    // 8. BST Iterator (LC173)
    // -----------------------------
    public class BSTIterator {
        private java.util.Stack<TreeNode> stack = new java.util.Stack<>();

        public BSTIterator(TreeNode root) {
            pushLeft(root);
        }

        private void pushLeft(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        public int next() {
            TreeNode node = stack.pop();
            if (node.right != null) pushLeft(node.right);
            return node.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
