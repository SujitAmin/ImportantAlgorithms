package graphsalgorithms;

public class AdjacencyMatrix {
    private boolean adjMatrix[][];
    private int numVertices;

    public AdjacencyMatrix(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new boolean[numVertices][numVertices];
    }

    public void addEdge(int i , int j) {
        adjMatrix[i][j] = true;
        adjMatrix[i][j] = true;
    }
    public void removeEdge(int i , int j) {
        adjMatrix[i][j] = false;
        adjMatrix[j][j] = false;
    }

    //print the matrix
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < numVertices; i++) {
            s.append(i + ": ");
            for (boolean j : adjMatrix[i]) {
                s.append((j ? 1 : 0) + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public static void main(String args[]) {
        AdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix(4);
        adjacencyMatrix.addEdge(0,1);
        adjacencyMatrix.addEdge(0, 2);
        adjacencyMatrix.addEdge(1, 2);
        adjacencyMatrix.addEdge(2, 0);
        adjacencyMatrix.addEdge(2, 3);

        System.out.println(adjacencyMatrix.toString());
    }
}
