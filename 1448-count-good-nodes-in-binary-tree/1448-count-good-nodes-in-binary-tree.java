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
    public int goodNodes(TreeNode root) {
        return helper(root, root.val);
    }
    
    private int helper(TreeNode curNode, int curMax){
        if(curNode == null)
            return 0;
        
        if(curNode.val < curMax){
            return helper(curNode.left, curMax) + helper(curNode.right, curMax);
        } else {
            return helper(curNode.left, curNode.val) + helper(curNode.right, curNode.val) + 1;
        }
    }
}