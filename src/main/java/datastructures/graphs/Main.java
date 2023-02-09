package datastructures.graphs;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");


        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");

        graph.printGraph();

        System.out.println("After removing edge: ");

        graph.removeEdge("A", "B");

        graph.printGraph();

        System.out.println("After removing vertex: ");



        graph.removeVertex("A");
        graph.printGraph();
    }
}
