package TemplatesForCompetitiveProgramming.FastIOJava.Graph;
import java.util.*;
class BFSOnAdjacencyMatrix {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0 )
            return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        int countFresh = 0;
        Queue<int[]> queue = new LinkedList<>();

        //Put the position of all rotten oranges in queue
        //count the number of fresh oranges
        for(int i = 0; i < rows; i++) {
            for(int j = 0 ; j < cols; j++) {
                if(grid[i][j] == 2)
                    queue.add(new int[]{i, j});
                if(grid[i][j] == 1)
                    countFresh++;

            }
        }

        //if count of fresh oranges is zero --> return 0
        if(countFresh == 0) {
            return 0;
        }
        int countMinutes = 0;

        int[][] dirs = {{-1, 0},{1,0},{0,-1},{0,1}};

        //bfs starting from initially rotten oranges
        while(!queue.isEmpty()) {
            countMinutes++;
            int queueSize = queue.size();
            for(int i = 0; i < queueSize; i++) {
                int[] point = queue.poll();
                for(int[] dir: dirs) {
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];

                    if(isNotValid(x, y, rows, cols, grid)) {
                        continue;
                    }
                    //mark the orange at (x , y) as rotten
                    grid[x][y] = 2;
                    //put the new rotten orange at (x , y) in queue
                    queue.add(new int[]{x,y});
                    //decrease the count of fresh oranges by 1
                    countFresh--;
                }
            }
        }
        return countFresh == 0 ? countMinutes - 1: -1;
    }
    boolean isNotValid(int x, int y , int rows, int cols, int[][] grid) {
        if(x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || grid[x][y] == 2) {
           return true;
        }
        return false;
    }
}
