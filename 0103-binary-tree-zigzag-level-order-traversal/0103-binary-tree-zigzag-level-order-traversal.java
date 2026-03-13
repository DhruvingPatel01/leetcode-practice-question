import java.util.*;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            // Use LinkedList to allow efficient adding to both ends
            LinkedList<Integer> currentLevel = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (leftToRight) {
                    currentLevel.add(node.val); // Adds to the end
                } else {
                    currentLevel.addFirst(node.val); // Adds to the front
                }

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            result.add(currentLevel);
            leftToRight = !leftToRight; // Flip the direction for the next level
        }

        return result;
    }
}