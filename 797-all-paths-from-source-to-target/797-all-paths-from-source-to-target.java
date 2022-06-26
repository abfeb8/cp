class Solution {
    
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int src = 0, target = graph.length - 1;
        var path = new ArrayList<Integer>();
        
        helper(graph, src, target, path);
        
        return result;
    }
    
    private void helper(int[][] graph, int curNode, int target, List<Integer> path){
        if(curNode == target){
            var rout = new ArrayList<Integer>(path);
            rout.add(target);
            result.add(rout);
        }
        
        path.add(curNode);
        
        for(int node : graph[curNode]){
            helper(graph, node, target, path);
        }
        
        path.remove(path.size() - 1);
    }
}