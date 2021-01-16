package graphsalgorithms;

public class GraphMatrixDFS {
    int v;
    int[][] adj;

    GraphMatrixDFS(int vertex) {
        v = vertex;
        adj = new int[v][v];
    }

    private void DFSUtil(int start, boolean[] visited) {
        visited[start] = true;
        System.out.println(start);
        //for every node of the graph
        for(int i = 0; i < v; i++) {
            //if some node is adjacent to the current node
            //and it has not already been visited
            if(!visited[i]) {
                if(adj[start][i] == 1) {
                    DFSUtil(i, visited);
                }
            }
        }
    }

    public static void main(String[] args) {
        int v = 5;
        GraphMatrixDFS graphMatrixDFS = new GraphMatrixDFS(5);
        graphMatrixDFS.addEdge(0,1);
        graphMatrixDFS.addEdge(0,2);
        graphMatrixDFS.addEdge(0,3);
        graphMatrixDFS.addEdge(0,4);

        boolean[] visited = new boolean[v];
        graphMatrixDFS.DFSUtil(0, visited);
    }

    void addEdge(int start, int end) {
        adj[start][end] = 1;
        adj[end][start] = 1;
    }
}
