class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        
        for(int i = 0; i<n; i++){
            if(colors[i] == 0){
                if(!helper(graph, colors, i, 1, -1))
                    return false;
            }
        }
        return true;
    }
    
    private boolean helper(int[][] graph, int[] colors, int curNode, int color, int parent){
        if(colors[curNode] != 0)
            return colors[curNode] == color;
        
        
        colors[curNode] = color;
        // System.out.printf(curNode + "(" + color + ")->");
        int nxtColor = color%2 == 0 ? 1 : 2;
        for(int n : graph[curNode]){
            if(n != parent && !helper(graph, colors, n, nxtColor, curNode)){
                return false;
            }
        }
            
        
        // System.out.println(curNode + "(" + colors[curNode] + ")->");
        return true;
    }
}