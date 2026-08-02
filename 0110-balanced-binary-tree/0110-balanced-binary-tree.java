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

    class Answer{
        boolean result = true;
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
     Answer ans = new Answer();
     helper(root, ans);
     return ans.result;
    }

    public int helper(TreeNode root, Answer ans){
    if(!ans.result) return -1;
    if(root == null ) return -1;

    int left_l = helper(root.left, ans);
    int right_l = helper(root.right, ans);

    if(Math.abs(left_l - right_l) > 1) ans.result = false;

    return Math.max(left_l, right_l) + 1;
    }
}