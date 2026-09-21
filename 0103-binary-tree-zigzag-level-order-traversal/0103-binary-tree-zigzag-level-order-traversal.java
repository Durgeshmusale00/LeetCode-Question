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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
     if(root == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int lev = 0;
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
            if(lev  % 2 != 0){
            Collections.reverse(subAns);
            ans.add(subAns);
            }else{
            ans.add(subAns);
            }
            lev++;
        }
        return ans;
    }
}