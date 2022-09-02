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
        List<Double> result = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            double d = 0.0;
            for(int i = 0; i<n; i++){
                TreeNode curNode = q.pollFirst();
                d+=curNode.val;
                if(curNode.left != null) q.add(curNode.left);
                if(curNode.right != null) q.add(curNode.right);
            }
            result.add(d/(n*1.0));
        }
        
        return result;
    }
}