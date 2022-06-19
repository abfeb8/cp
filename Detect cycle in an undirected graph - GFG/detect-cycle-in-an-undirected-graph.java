// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


class Solution {
    
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        // System.out.println(adj);
        boolean[] isVisited = new boolean[V];
        Deque<Node> q = new ArrayDeque<>();
        for(int i = 0; i<V; i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                q.addLast(new Node(i, -1));
                // System.out.println(q);
                while(!q.isEmpty()){
                    // System.out.println(adj.get(q.peek()));
                    Node node = q.pollFirst();
                    // System.out.printf(node.val + "-> ");
                    for(int e : adj.get(node.val)){
                        if(e == node.parent){
                            continue;
                        }
                        // System.out.printf(e + " " );
                        if(isVisited[e]){
                            return true;
                        }
                        isVisited[e] = true;
                        q.addLast(new Node(e, node.val));
                        // System.out.println(q);
                    }
                    // System.out.println();
                }
            }
        }
        
        return false;
    }
}

class Node {
    int val;
    int parent;
    
    public Node(int v, int p){
        this.val = v;
        this.parent = p;
    }
}