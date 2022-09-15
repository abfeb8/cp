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
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] result = new int[]{0}, freq = new int[10];
        Set<Integer> set = new HashSet<>();
        helper(root, result, freq);
        return result[0];
    }
    
    private void helper(TreeNode node, int[] result, int[] freq){
        if(node == null){
            return;
        }
        
        freq[node.val]++;
        if(node.left == null && node.right == null){
            if(isPartiy(freq)) 
                result[0]++;
        }
        
        // System.out.println(node.val);
        
        
        helper(node.left, result, freq);
        helper(node.right, result, freq);
        
        freq[node.val]--;
    }
    
    private boolean isPartiy(int[] freq){
        boolean oddFlag = false, palindrom = true;
        freq[0] = 0;
        for(int i : freq){
            // System.out.printf(i + " ");
            if((i&1) == 1){
                if(oddFlag){
                    palindrom = false;
                }
                oddFlag = true;
            }
        }
        // System.out.println();
        return palindrom;
    }
}