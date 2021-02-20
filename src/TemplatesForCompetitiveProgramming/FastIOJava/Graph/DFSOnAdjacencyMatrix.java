package TemplatesForCompetitiveProgramming.FastIOJava.Graph;

class DFSOnAdjacencyMatrix {
    public int maxAreaOfIsland(int[][] adjacencyMatrix) {
        int maxArea = 0;

        int rows = adjacencyMatrix.length;
        int cols = adjacencyMatrix[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                maxArea = Math.max(maxArea, area(i, j, adjacencyMatrix, visited));
            }
        }
        return maxArea;
    }

    private int area(int row , int column , int[][] adjacenyMatrix, boolean[][] visited) {
        if(isNotValid(row, column, adjacenyMatrix, visited[row][column])) {
            return 0;
        }

        visited[row][column] = true;
        return 1 + area(row + 1, column, adjacenyMatrix, visited) + area(row - 1, column, adjacenyMatrix, visited) + area(row, column + 1, adjacenyMatrix, visited) + area(row, column - 1, adjacenyMatrix, visited);
    }

    private boolean isNotValid(int row, int column, int[][] adjacenyMatrix, boolean b) {
        return row < 0 || row >= adjacenyMatrix.length || column < 0 || column >= adjacenyMatrix[0].length || b || adjacenyMatrix[row][column] == 0;
    }
}
