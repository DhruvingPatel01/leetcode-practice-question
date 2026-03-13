/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// class Solution {
//     public List<List<Integer>> levelOrder(TreeNode root) {
//     List<List<Integer>>r =new ArrayList<>();
//     if(root == null)
//     return r;
//     Queue<TreeNode>q =new Queue<>();
//     q.offer(root);
//     while(!q.isEmpty())
//     {
//         int size=q.size();
//         List<List<Integer>>minr =new Arraylist<>();
//         while(size>0)
//         {
//             TreeNode temp=q.peek;
//             q.poll();
//             if(temp.left!=null)q.offer(temp.left);
//             if(temp.right!=null)q.offer(temp.right);
//             minr.offer(temp.val);
//             size --;
//         }
//         r.add(minr);
//     }
//     return r;
//     }
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> r = new ArrayList<>();
        if (root == null) return r; 

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> minr = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                minr.add(temp.val);

                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
            }
            r.add(minr);
        }
        return r;
    }
};