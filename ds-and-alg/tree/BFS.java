package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class BFS {
    public static LinkedList<Integer> adj[];

    public static  void addEdges(List<LinkedList<Integer>> edges){
        adj = new LinkedList<Integer>[edges.size()];
        
        for (List<Integer> nestedList : edges) {
            if (adj[nestedList.get(0)] == null) { adj[nestedList.get(0)] = new LinkedList<Integer>();}
            adj[nestedList.get(0)].add(nestedList.get(1));
        }
    }       

    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        BFS.addEdges(edges);
        
        boolean[] visited = new boolean[n];
        visited[s] = true;
        result.add(s);
        
        while (result.size() != 0) {
            s = result.poll();
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()){
                int f = i.next();
                if (!visited[f]){
                    visited[f] = true;
                    result.add(f);
                }
            }
        }
        
        
        return Arrays.asList(result.toArray(Integer::intValue));
    }
    
}
    /**
     * 2
4 2
1 2
1 3
1
3 1
2 3
2
     */

