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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        
        if(root == null) return list;
        
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            list.add(q.peek().val);
            for(int i = 0; i<n; i++){
                TreeNode curNode = q.poll();
                if(curNode.right!=null) q.add(curNode.right);
                if(curNode.left!=null) q.add(curNode.left);
            }
        }
        return list;
    }
}