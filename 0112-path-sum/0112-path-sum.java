class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // Case 1: The node is null
        if (root == null) {
            return false;
        }

        // Case 2: We reached a leaf node
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        // Case 3: Recursively check subtrees with the reduced targetSum
        int remainingSum = targetSum - root.val;
        return hasPathSum(root.left, remainingSum) || 
               hasPathSum(root.right, remainingSum);
    }
}