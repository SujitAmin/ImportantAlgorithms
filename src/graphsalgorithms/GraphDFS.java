package graphsalgorithms;

import java.util.LinkedList;

public class GraphDFS {
    //No. of vertices
    private int V;

    //Array of lists for
    //Adjacency List Representation.
    private LinkedList<Integer>[] adj;

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    GraphDFS(int V) {
        this.V = V;
        adj = new LinkedList[V];
        for(int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    private void DFS() {
        //Mark all the vertices as not visited
        // ( set as false by default in java)
        boolean[] visited = new boolean[V];

        //call the recursive helper function to print
        //DFS traversal starting from all vertices one by one
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                DFSUtil(i, visited);
            }
        }
    }

    private void DFSUtil(int v, boolean[] visited) {
        //mark the current node as visited
        //and print it.
        visited[v] = true;
        System.out.print(v + " ");

        for(int i = 0; i < adj[v].size(); i++) {
            int value = adj[v].get(i);
            if(!visited[value]) {
                DFSUtil(value, visited);
            }
        }
    }

    public static void main(String[] args) {
        GraphDFS g = new GraphDFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println(
                "Following is Depth First Traversal");

        g.DFS();
    }
}
