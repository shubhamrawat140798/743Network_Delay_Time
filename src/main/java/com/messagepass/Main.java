package com.messagepass;

// Status Not complete.
public class Main {
    public static void main(String[] args) {
        // for testin purpose
        int vertices = 6;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1, 5);
        graph.addEdge(0, 2, 3);
        graph.addEdge(0, 5, 4);
        graph.addEdge(1, 3, 8);
        graph.addEdge(2, 3, 1);
        graph.addEdge(3, 5, 10);
        graph.addEdge(3, 4, 5);
        graph.printGraph();
        graph.getShortest();
        
    }
}
