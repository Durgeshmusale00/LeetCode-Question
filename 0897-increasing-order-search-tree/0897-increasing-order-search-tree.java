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
    public TreeNode increasingBST(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        TreeNode dummy = new TreeNode(0);
        TreeNode curr = dummy;
        for (int val : ans) {
            curr.right = new TreeNode(val);
            curr = curr.right;
        }
        return dummy.right;
    }

    public void inorder(TreeNode root, ArrayList<Integer> ans) {
        if (root == null) return;

        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
    }
}