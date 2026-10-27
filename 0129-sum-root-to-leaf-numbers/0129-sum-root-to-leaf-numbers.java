class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode root, int currentSum) {
        if (root == null) {
            return 0;
        }
        currentSum = currentSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return currentSum;
        }
        int leftSum = helper(root.left, currentSum);
        int rightSum = helper(root.right, currentSum);
        return leftSum + rightSum;
    }
}
