package graphsalgorithms;

public class UnionFindByRank {
    int noOfVertices, noOfEdges;
    Edge[] edgeArray;

    UnionFindByRank(int noOfVertices, int noOfEdges) {
        this.noOfVertices = noOfVertices;
        this.noOfEdges = noOfEdges;
        edgeArray = new Edge[noOfEdges];
        for (int i = 0; i < noOfEdges; i++) {
            edgeArray[i] = new Edge();
        }
    }

    // class to represent edges.
    static class Edge {
        int source, destination;
    }

    // class to represent subset.
    static class Node {
        int parent, rank;
        Node(int parent, int rank) {
            this.parent = parent;
            this.rank = rank;
        }
    }

    //find the root.
    private int find(Node[] nodes, int vertex) {
        if(nodes[vertex].parent != vertex) {
            nodes[vertex].parent = find(nodes, nodes[vertex].parent);
        }
        return nodes[vertex].parent;
    }

    // a function that does union of two sets of x and y
    // (uses union by rank).
    void Union(Node[] nodes, int x, int y) {

        int xroot = find(nodes, x);
        int yroot = find(nodes, y);

        //xroot rank < yroot rank
        //assign xroot parent ==> yroot;
        //dont increase rank
        if(nodes[xroot].rank < nodes[yroot].rank)
            nodes[xroot].parent = yroot;
        else if (nodes[yroot].rank < nodes[xroot].rank)
            nodes[yroot].parent = xroot;
        else {
            // increase rank...
            nodes[xroot].parent = yroot;
            nodes[yroot].rank++;
        }
    }

    private boolean isCycle(UnionFindByRank unionFindByRank) {
        int vertices = unionFindByRank.noOfVertices;
        int edges = unionFindByRank.noOfEdges;

        Node[] nodes = new Node[vertices];

        for(int v = 0; v < vertices; v++) {
            nodes[v] = new Node(v, 0);
        }

        for(int e = 0; e < edges; e++) {
            int x = find(nodes, unionFindByRank.edgeArray[e].source);
            int y = find(nodes, unionFindByRank.edgeArray[e].destination);

            if(x == y) {
                return true;
            }
            Union(nodes, x, y);
        }
        return false;
    }

    public static void main(String[] args) {
        /*
        * let us create the following graph
        * 0
        * |\
        * | \
        * |  \
        * |   \
        * |    \
        * 1-----2
        * */
        int vertices = 3;
        int edges = 3;
        UnionFindByRank graph = new UnionFindByRank(vertices, edges);

        // add edge 0 - 1
        graph.edgeArray[0].source = 0;
        graph.edgeArray[0].destination = 1;

        // add edge 1 - 2
        graph.edgeArray[1].source = 1;
        graph.edgeArray[1].destination = 2;

        // edge 0 - 2
        graph.edgeArray[2].source = 0;
        graph.edgeArray[2].destination = 2;

        if(graph.isCycle(graph)) {
            System.out.println("Graph contains cycle");
        } else {
            System.out.println("Graph doesn't contain cycle");
        }
    }
}
