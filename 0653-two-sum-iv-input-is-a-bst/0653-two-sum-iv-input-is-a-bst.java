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
    private boolean flag = false;
    public boolean findTarget(TreeNode root, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    dfs(root, map, k);
    // for(int i = 0;i<map.size();i++){
    //     int num = map.containsKey(i);
    //     int sum = k - num;
    //     if (map.containsKey(sum)) {
    //         return true;
    //     }
    // }
    // return false;
    return flag;
    }

    public void dfs(TreeNode root, HashMap<Integer, Integer> map, int k){
        if(root == null) return;

        dfs(root.left, map, k);
        int sum = k - root.val;
        if(map.containsKey(sum)){
            flag = true;
        }else{
            map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        }
        dfs(root.right, map, k);
    }
}