package com.messagepass;

/**
 * for storing edges of graph.
 */
public class Edge {
    /**
     * for storing source node.
     */
    int source;
    /**
     * for storing destination.
     */
    int destination;
    /**
     * for storing time completion.
     */
    int time;

    /**
     *
     * @param source for storing source node.
     * @param destination for storing destination node.
     * @param time for storing time(weight) between source and destination.
     */
    public Edge(final int source,final int destination,final int time) {
        this.source = source;
        this.destination = destination;
        this.time = time;
    }

}
