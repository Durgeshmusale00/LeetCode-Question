class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        ArrayList<Integer> list = new ArrayList<>();
        dfsGather(root, list);
        helper(root, 1, list);
    }

    public void helper(TreeNode current, int i, ArrayList<Integer> list) {
        if (i >= list.size() || current == null) {
            return;
        }
        current.left = null;     
        current.right = new TreeNode(list.get(i)); 
        helper(current.right, i + 1, list);
    }

    public void dfsGather(TreeNode root, ArrayList<Integer> list) {
        if (root == null) return;

        list.add(root.val);
        dfsGather(root.left, list);
        dfsGather(root.right, list);
    }
}
