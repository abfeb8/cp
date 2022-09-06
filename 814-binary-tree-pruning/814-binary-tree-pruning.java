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
    public TreeNode pruneTree(TreeNode root) {
        if(!contains1(root))
            return null;
        return root;
    }
    
    private boolean contains1(TreeNode node){
        if(node == null)
            return false;
        
        boolean leftContains1 = contains1(node.left);
        boolean rightContains1 = contains1(node.right);
        
        if(!leftContains1){
            node.left = null;
        }
        
        if(!rightContains1){
            node.right = null;
        }
        
        return node.val == 1 || leftContains1 || rightContains1;
    }
}