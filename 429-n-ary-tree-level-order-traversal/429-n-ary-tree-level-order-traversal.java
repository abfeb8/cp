/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> tempList = new ArrayList<>();
            for(int i = 0; i<n; i++){
                Node curNode = q.poll();   
                tempList.add(curNode.val);
                for(Node child : curNode.children){
                    q.add(child);
                }
            }
            result.add(tempList);
        }
        
        return result;
    }
}