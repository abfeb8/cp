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
    class Node {
        int val;
        int row;
        Node (int val, int row){
            this.val = val;
            this.row = row;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Map<Integer, List<Node>> map = new TreeMap<>();
        
        helper(root, 0, 0, map);
        
        for(int k : map.keySet()){
            result.add(map.get(k).stream()
                       .sorted((n1, n2) -> n1.row-n2.row != 0 ? 
                               n1.row-n2.row : n1.val - n2.val)
                       .map(n -> n.val)
                       .toList());
        }
        
        return result;
    }
    
    private void helper(TreeNode node, int r, int c, Map<Integer, List<Node>> map){
        if(node == null)
            return;
        
        map.putIfAbsent(c, new ArrayList<Node>());
        map.get(c).add(new Node(node.val, r));
        
        helper(node.left, r+1, c-1, map);
        helper(node.right, r+1, c+1, map);
        
    }
}