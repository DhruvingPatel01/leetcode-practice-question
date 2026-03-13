class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        // Step 1: Search for the node
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } 
        // Step 2: Node found! Handle deletion
        else {
            // Case 1 & 2: Leaf or only one child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // Case 3: Two children
            // Find the inorder successor (smallest in the right subtree)
            root.val = findMin(root.right);
            
            // Delete the inorder successor from the right subtree
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private int findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.val;
    }
}