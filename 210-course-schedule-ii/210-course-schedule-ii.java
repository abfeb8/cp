class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    boolean hasCycle = false;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // create adj matrix
        for(int[] arr : prerequisites){
            map.putIfAbsent(arr[1], new LinkedList<Integer>());
            map.get(arr[1]).add(arr[0]);
        }
        
        int[] visited = new int[numCourses];
        /* visited
        0 -> not visited
        1 -> toposort is in process
        2 -> toposort done
        */
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<numCourses; i++){
            if(visited[i] == 0 && !hasCycle){
                topologicalSortUtil(i, visited, stack);
            }
        }
        
        if(hasCycle) return new int[0];
        
        int[] result = new int[numCourses];
        for(int i = 0; i<numCourses; i++){
            result[i] = stack.pop();
        }
            
        return result;
    }
    
    
    private void topologicalSortUtil(int v, int visited[], Stack<Integer> stack){
        visited[v] = 1;
        Integer i;
        
        if(hasCycle) return;
 
        Iterator<Integer> it = map.getOrDefault(v, new LinkedList<Integer>()).iterator();
        while (it.hasNext()){
            i = it.next();
            if (visited[i] == 0) topologicalSortUtil(i, visited, stack);
            else if(visited[i] == 1) hasCycle = true;
        }
        visited[v] = 2;
        stack.push(new Integer(v));
    }
}