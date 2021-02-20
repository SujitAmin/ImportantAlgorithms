package graphsalgorithms;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSorting {
    //no of vertices;
    private int noOfVertices;

    //adjacency list as arraylist of arraylist's
    private ArrayList<ArrayList<Integer>> adj;

    TopologicalSorting(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        adj = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < noOfVertices; i++) {
            adj.add(new ArrayList<Integer>());
        }
    }

    void addEdge(int u, int v) {
        adj.get(u).add(v);
    }
    private void topologicalSortUtil(int vertex, boolean[] visited, Stack<Integer> stack) {
        //mark the current node as visited.
        visited[vertex] = true;

        //recur for all the vertices adjacent to this vertex.
        for(Integer element : adj.get(vertex)) {
            if(!visited[element]) {
                topologicalSortUtil(element, visited, stack);
            }
        }

        //push current vertex to stack which stores result.
        stack.push(vertex);
    }
    private void topologicalSort() {
        Stack<Integer> stack = new Stack<>();

        //mark all the vertices as not visited.
        boolean[] visited = new boolean[noOfVertices];

        //call the recursive helper function to store
        for(int i = 0; i < noOfVertices; i++) {
            if(!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void main(String[] args) {
        TopologicalSorting topologicalSorting = new TopologicalSorting(6);
        topologicalSorting.addEdge(5, 2);
        topologicalSorting.addEdge(5, 0);
        topologicalSorting.addEdge(4, 0);
        topologicalSorting.addEdge(4, 1);
        topologicalSorting.addEdge(2, 3);
        topologicalSorting.addEdge(3, 1);

        //Note: Here, we can also use vector
        // instead of the stack. If the vector
        // is used then print the elements in
        // reverse order to get the topological sorting.
        topologicalSorting.topologicalSort();
    }
}
