class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            // If both p and q are greater than root, move to right child
            if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } 
            // If both p and q are less than root, move to left child
            else if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } 
            // We found the split point or one of the nodes!
            else {
                return root;
            }
        }
        return null;
    }
}