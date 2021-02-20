import java.util.ArrayList;
import java.util.*;

public class Treasure {
    public int countComponents(int n, int[][] edges) {
        if(n <= 0 || edges == null)
            return 0;

        if(n == 1 || edges.length == 0)
            return 0;


        int count = 0;
        boolean[] visited = new boolean[n];

        // step 1: create the adj list from edge list
        List<List<Integer>> adjList = createGraph(edges, n);

        // step 2: calculate the number of cc
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                numberOfConnectedComponents(i, adjList, visited);
            }
        }
        return count;
    }

    private void numberOfConnectedComponents(int node, List<List<Integer>> adjList, boolean[] visited) {
        if (visited[node])
            return;

        visited[node] = true;
        for (int neighbor : adjList.get(node))
            numberOfConnectedComponents(neighbor, adjList, visited);
    }

    private List<List<Integer>> createGraph(int[][] edges, int n) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }
}