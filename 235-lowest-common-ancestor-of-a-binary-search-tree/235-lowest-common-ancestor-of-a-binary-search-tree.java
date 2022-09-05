/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, Math.max(p.val, q.val), Math.min(p.val, q.val));
    }
    
    private TreeNode helper(TreeNode node, int max, int min){
        if(node.val<=max && node.val>=min){
            return node;
        }
        
        if(node.val>max)
            return helper(node.left, max, min);
        else
            return helper(node.right, max, min);
    }
}