/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    private int index = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    private void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) return;

        sb.append(root.val).append(",");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0)
            return null;

        String[] arr = data.split(",");
        int[] preorder = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            preorder[i] = Integer.parseInt(arr[i]);
        }

        index = 0;
        return build(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode build(int[] preorder, int lower, int upper) {
        if (index == preorder.length)
            return null;

        int val = preorder[index];

        if (val < lower || val > upper)
            return null;

        index++;

        TreeNode root = new TreeNode(val);

        root.left = build(preorder, lower, val);
        root.right = build(preorder, val, upper);

        return root;
    }
}