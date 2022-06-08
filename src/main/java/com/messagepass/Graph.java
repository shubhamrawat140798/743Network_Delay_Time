/**
 * package to check for total time to reach message node 0 to All.
 */
package com.messagepass;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;
/**
 * for storing graph.
 */
final class Graph {
    /**
     * for storing total number of nodes.
     */
    final int vertices;
    /**
     * for storing edge in the Linked list.
     * (creating dictionary on the bases of target).
     */
    private LinkedList<Edge>[] adjacencylist;
    /**
     * constructor to vertices and to determine the size of adjacencylist.
     * @param vertices for storing vertices of a graph.
     */
    Graph(final int vertices) {
        this.vertices = vertices;
        adjacencylist = new LinkedList[vertices];
        //initialize adjacency lists for all the vertices
        for (int index = 0; index < vertices; index++) {
            adjacencylist[index] = new LinkedList<>();
        }
    }
    /**
     *
     * @param source for storing source node.
     * @param destination for storing destination node.
     * @param time for storing time(weight) between nodes.
     */
    public void addEdge(final int source,
        final int destination, final int time) {
        Edge edge = new Edge(source, destination, time);
        //for directed graph
        adjacencylist[destination].addFirst(edge);
    }
    /**
     * for printing graph.
     */
    public void printGraph() {
        for (int index = 0; index < vertices; index++) {
            LinkedList<Edge> list = adjacencylist[index];
            for (Edge edge : list) {
                System.out.println("vertex-" + edge.source
                + " is connected to " + edge.destination
                + " with time " + edge.time);
            }
        }

    }

    /**
     * for printing shortest path.
     */
    public void getShortest() {
        List<Integer> distances = new ArrayList<>();
        for (int target = 1; target < vertices; target++) {
            int distance = findDistance(target, adjacencylist);
            distances.add(distance);
        }
        System.out.println("Output is: " + Collections.max(distances));
    }

    /**
     *
     * @param target for measuring distance depth first search manner.
     * @param adjacencylist LinkedList array for vertices.
     * @return return time in which message will reach to the all nodes.
     */
    public int findDistance(final int target,
       final LinkedList<Edge>[] adjacencylist) {
       if (target == 0 && target < vertices) {
           return 0;
       }
       List<Integer> distances = new ArrayList<>();
       LinkedList<Edge> targetDistance = adjacencylist[target];
       for (Edge edge : targetDistance) {
           int distance = edge.time + findDistance(edge.source, adjacencylist);
           distances.add(distance);
       }
        return Collections.min(distances);
    }
}
