package TemplatesForCompetitiveProgramming.FastIOJava.Graph;


import java.util.*;

class CreateAdjacencyList {
    Map<String, ArrayList<String>> adjacencyList = new HashMap<>();
    LinkedList<String> result = new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        createGraph(tickets);
        return result;
    }

    void createGraph(List<List<String>> tickets) {
        for(List<String> fromToArray : tickets) {
            if(!adjacencyList.containsKey(fromToArray.get(0))) {
                adjacencyList.put(fromToArray.get(0), new ArrayList<>());
            }
            adjacencyList.get(fromToArray.get(0)).add(fromToArray.get(1));
        }
    }
}
