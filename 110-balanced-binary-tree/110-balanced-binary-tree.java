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
    Map<TreeNode, Integer> map = new HashMap<>();
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        getHeight(root);
        map.put(null, 0);
        // System.out.println(map);
        return helper(root.left, root.right);
    }
    
    private boolean helper(TreeNode a, TreeNode b){
        // System.out.println(a.val + " " b.val);
        return (Math.abs((map.get(a)) - map.get(b)) <= 1) && 
            (a == null || helper(a.left, a.right)) && 
            (b == null || helper(b.left, b.right));
    }
    
    private int getHeight(TreeNode root){
        if(root == null)
            return 0;
        
        map.put(root, Math.max(getHeight(root.left), getHeight(root.right)) + 1);
        return map.get(root);
    }
}