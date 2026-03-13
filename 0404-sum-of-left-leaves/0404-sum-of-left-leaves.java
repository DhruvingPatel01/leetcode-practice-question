class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        
        int sum = 0;
        
        // Check if the left child exists
        if (root.left != null) {
            // Check if that left child is a leaf
            if (root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            } else {
                // If it's not a leaf, keep searching down the left branch
                sum += sumOfLeftLeaves(root.left);
            }
        }
        
        // Always check the right branch for potential left leaves deeper down
        sum += sumOfLeftLeaves(root.right);
        
        return sum;
    }
}