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
        // {-1 : [Node(9, 1)], 0 : [Node(3, 0), Node(15, 2)], 1 : [Node(20, 1)], 2 : [Node(7, 2)]}
        Map<Integer, List<Node>> map = new TreeMap<>();
        mapNodeToCol(root, 0, 0, map);

        return map.keySet().stream()
            .map(k -> customSort(map.get(k)))
            .toList();
    }
    
    private List<Integer> customSort(List<Node> list){
        return list.stream()
            .sorted((n1, n2) -> n1.row-n2.row != 0 ? n1.row-n2.row : n1.val-n2.val)
            .map(n -> n.val)
            .toList();
    }
    
    private void mapNodeToCol(TreeNode node, int r, int c, Map<Integer, List<Node>> map) {
        if(node == null)
            return;
        
        map.putIfAbsent(c, new ArrayList<Node>());
        map.get(c).add(new Node(node.val, r));
        
        mapNodeToCol(node.left, r+1, c-1, map);
        mapNodeToCol(node.right, r+1, c+1, map);
    }
}