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
    public boolean isSymmetric(TreeNode root) {
        return help(root, root);
    }
    
    private boolean help(TreeNode l, TreeNode r){
        
        if(l != null && r != null){
            return l.val == r.val && help(l.left, r.right) && help(l.right, r.left);
        }
        
        if(l == null && r == null){
            return true;
        }
            
        return false;
    }
}