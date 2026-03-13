class Solution {
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        calculateHeight(root);
        return maxDiameter;
    }

    private int calculateHeight(TreeNode node) {
        if (node == null) return 0;

        // Recursive calls to find the height of subtrees
        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        // The diameter at this node is leftHeight + rightHeight
        // We update the global maximum
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

        // Return the height of this node to its parent
        return Math.max(leftHeight, rightHeight) + 1;
    }
}