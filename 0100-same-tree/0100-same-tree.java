class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 1. If both are null, they are identical
        if (p == null && q == null) {
            return true;
        }
        
        // 2. If only one is null, or values don't match, they are different
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        
        // 3. Recursively check left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}