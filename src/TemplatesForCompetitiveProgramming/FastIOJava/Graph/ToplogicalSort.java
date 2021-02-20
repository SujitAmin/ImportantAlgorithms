package TemplatesForCompetitiveProgramming.FastIOJava.Graph;

import java.util.*;
public class ToplogicalSort {
    HashSet<Integer> visited;
    HashSet<Integer> visiting;
    Stack<Integer> stack;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        buildGraph(prerequisites, graph);
        initialize();

        if(hasCycle(numCourses, graph)) {
            return new int[0];
        }

        return getOrderFromStack(stack);
    }

    private void initialize() {
        visited = new HashSet<>() ;
        visiting = new HashSet<>();
        stack = new Stack<>();
    }

    private void buildGraph(int[][] prerequisites, Map<Integer, List<Integer>> graph) {
        for (int[] prerequisite : prerequisites) {
            int key = prerequisite[0];
            int ele = prerequisite[1];
            if (!graph.containsKey(key)) {
                graph.put(key, new ArrayList<>());
            }
            graph.get(key).add(ele);
        }
    }

    private boolean hasCycle(int n, Map<Integer, List<Integer>> graph){
        for(int i = 0; i<n;i++){
            if(cycleDfs(i,graph)) {
                return true;
            }
        }
        return false;
    }
    private boolean cycleDfs(int current, Map<Integer, List<Integer>> graph){
        if(visited.contains(current)) {
            return false;
        }
        if(visiting.contains(current)) {
            return true;
        }

        visiting.add(current);
        boolean cycle = false;
        if(graph.containsKey(current)){
            for(int w: graph.get(current)){
                if(!visited.contains(w)) {
                    cycle = cycleDfs(w,graph);
                    if(cycle){
                        break;
                    }
                }
                else if(visiting.contains(w)){
                    break;
                }
            }
        }
        visiting.remove(current);
        visited.add(current);
        stack.push(current);
        return cycle;
    }

    private int[] getOrderFromStack(Stack<Integer> stack){
        int[] array = new int[stack.size()];
        for(int i = array.length - 1; i>= 0; i--) array[i] = stack.pop();
        return array;
    }
}
