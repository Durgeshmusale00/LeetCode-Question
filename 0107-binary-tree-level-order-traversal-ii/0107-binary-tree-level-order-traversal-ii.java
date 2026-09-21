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
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        int idx = 0;
        que.add(root);
        // ans.add(root.val);
        while (!que.isEmpty()) {
            List<Integer> subAns = new ArrayList<>();
            int sz = que.size();
            for (int i = 0; i < sz; i++) {
                TreeNode curr = que.poll();
                subAns.add(curr.val);
                if (curr.left != null) {
                    que.add(curr.left);
                }
                if (curr.right != null) {
                    que.add(curr.right);
                }
            }
            ans.add(subAns);

        }
        Collections.reverse(ans);
        return ans;
    }
}