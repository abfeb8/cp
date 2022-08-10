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
    public TreeNode sortedArrayToBST(int[] nums) {
        int l = 0, r = nums.length-1;
        TreeNode node = new TreeNode();
        return helper(nums, node, l, r);
        
        // return node;
    }
    
    private TreeNode helper(int[] nums, TreeNode node, int l, int r){
        if(l > r){
            return null;
        }
        int mid = (l+r)/2;
        node.val = nums[mid];
        
        node.left = helper(nums, new TreeNode(), l, mid-1);
        node.right = helper(nums, new TreeNode(), mid+1, r);
            
        return node;
    }
}