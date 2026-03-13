import java.util.*;

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // Use LinkedList for result to make addFirst() O(1)
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            
            // Key Step: Always add the new level to the beginning of the list
            result.addFirst(currentLevel);
        }

        return result;
    }
}