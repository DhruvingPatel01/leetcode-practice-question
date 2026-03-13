class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if we hit null or find one of the targets
        if (root == null || root == p || root == q) {
            return root;
        }

        // Look for p and q in the left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both left and right are non-null, this node is the LCA
        if (left != null && right != null) {
            return root;
        }

        // If only one side returned something, pass it up to the parent
        return (left != null) ? left : right;
    }
}