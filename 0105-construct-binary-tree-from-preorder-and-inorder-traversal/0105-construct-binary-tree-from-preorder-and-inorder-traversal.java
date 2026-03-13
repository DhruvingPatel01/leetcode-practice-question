import java.util.HashMap;
import java.util.Map;

class Solution {
    int preorderIndex;
    Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        inorderIndexMap = new HashMap<>();
        
        // Build a map to find indices in inorder array in O(1)
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return arrayToTree(preorder, 0, inorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        // If there are no elements to construct the tree
        if (left > right) return null;

        // Select the preorderIndex element as the root and increment it
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // Build left and right subtrees based on root's split point in inorder
        int splitIndex = inorderIndexMap.get(rootValue);

        // Important: Left subtree must be built first because the 
        // preorder array follows Root -> Left -> Right order
        root.left = arrayToTree(preorder, left, splitIndex - 1);
        root.right = arrayToTree(preorder, splitIndex + 1, right);

        return root;
    }
}