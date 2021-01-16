package graphsalgorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphBFS {
    private int V;
    private LinkedList<Integer>[] adj;

    GraphBFS(int v) {
        V = v;
        adj = new LinkedList[V];
        for(int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    //print BFS traversal from a given source s
    void BFS(int s) {
        //mark all the vertices as not visited
        //(by default set as false)
        boolean visited[] = new boolean[V];

        //create a queue for BFS
        Queue<Integer> queue = new LinkedList<>();

        //mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);

        while(queue.size() != 0) {
            //dequeue a vertex from queue
            s = queue.poll();
            System.out.print(s + " ");

            for (int i = 0 ; i < adj[s].size(); i++) {
                int value = adj[s].get(i);
                if(!visited[value]) {
                    visited[value] = true;
                    queue.add(value);
                }
            }
        }
    }

    public static void main(String args[]) {
        GraphBFS g = new GraphBFS(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");
        g.BFS(2);
    }
}
