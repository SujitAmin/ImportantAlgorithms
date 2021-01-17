package graphsalgorithms;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GraphMatrixBFS {
    //number of vertex
    int V;

    //adjacency matrix
    int[][] adj;

    //function to fill the empty
    //adjacency matrix
    GraphMatrixBFS(int v) {
        this.V = v;

        adj = new int[V][V];

        for(int row = 0; row < V; row++) {
            Arrays.fill(adj[row], 0);
        }
    }

    void addEdge(int start, int end) {
        // Considering a bidirectional edge.
        adj[start][end] =  1;
        adj[end][start] = 1;
    }

    void bfs(int start) {
        // Visited vector to so that a vertex is not
        // visited more than once. Initializing the vector
        // to false as no vertex is visited at the beginining
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int value = queue.poll();
            System.out.println(value + " ");

            for(int i = 0 ; i < V; i++) {
                if(!visited[i]) {
                    if(adj[value][i] == 1) {
                        //push the adjacent node to
                        //the queue
                        queue.add(i);
                        visited[i] = true;
                    }
                }
            }
        }


    }

    public static void main(String[] args) {
        int v = 5;
        int e = 4;

        GraphMatrixBFS graphMatrixBFS = new GraphMatrixBFS(v);
        graphMatrixBFS.addEdge(0, 1);
        graphMatrixBFS.addEdge(0, 2);
        graphMatrixBFS.addEdge(1, 3);

        graphMatrixBFS.bfs(0);
    }


}
