package datastructures.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {
    private HashMap<String, List<String>> adjList = new HashMap<>();

    public boolean addVertex(String vertex) {
        if (adjList.get(vertex) == null) {
            adjList.put(vertex, new ArrayList<>());
            return true;
        }
        return false;
    }

    public boolean removeVertex(String vertex) {
        if (!adjList.containsKey(vertex)) return false;

        for (String otherVertex : adjList.get(vertex)) {
            adjList.get(otherVertex).remove(vertex);
        }
        adjList.remove(vertex);
        return true;
    }

    public boolean removeEdge(String vertexOne, String vertexTwo) {
        if (adjList.containsKey(vertexOne) && adjList.containsKey(vertexTwo)) {
            adjList.get(vertexOne).remove(vertexTwo);
            adjList.get(vertexTwo).remove(vertexOne);
            return true;
        }
        return false;
    }

    public boolean addEdge(String vertexOne, String vertexTwo) {
        if (adjList.containsKey(vertexOne) && adjList.containsKey(vertexTwo)) {
            adjList.get(vertexOne).add(vertexTwo);
            adjList.get(vertexTwo).add(vertexOne);
            return true;
        }

        return false;
    }

    public void printGraph() {
        adjList.forEach((key, value) -> System.out.println("Key: " + key + "--->" + value.toString()));
    }
}
