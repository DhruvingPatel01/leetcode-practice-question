class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            // Reach the leftmost node of the current node
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            
            // Backtrack from the stack
            curr = stack.pop();
            res.add(curr.val);
            
            // Now visit the right subtree
            curr = curr.right;
        }
        return res;
    }
}