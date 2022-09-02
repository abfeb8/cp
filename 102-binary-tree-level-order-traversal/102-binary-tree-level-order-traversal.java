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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null)
            return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> levelList = new ArrayList<>();
            for(int i = 0; i<n; i++){
                TreeNode curNode = q.poll();
                levelList.add(curNode.val);
                if(curNode.left != null) q.add(curNode.left);
                if(curNode.right != null) q.add(curNode.right);
            }
            result.add(levelList);
        }
        
        return result;
    }
}