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
    public List<Double> averageOfLevels(TreeNode root) {
      List<Double> ans = new ArrayList<>();
      if(root == null) return ans;

      Queue<TreeNode> q = new LinkedList<>();
      q.add(root);
     
      while(!q.isEmpty()){
        int sz = q.size();
         Double sum = 0.0;


        for(int i = 0;i<sz;i++){
        TreeNode p = q.poll();
        sum+=p.val;

        if(p.left != null){  
            q.add(p.left);
        }
         if(p.right != null){
            q.add(p.right);
        }
        }
        ans.add(sum/sz);
      }
      return ans;  
    }
}