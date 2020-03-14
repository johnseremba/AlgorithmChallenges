package com.serions.datastructures;

import java.util.*;

public class Graph {
    private int numOfVertices;
    private LinkedList<Integer>[] adjacencyList;

    public Graph(int numOfVertices) {
        this.numOfVertices = numOfVertices;
        this.adjacencyList = new LinkedList[numOfVertices];
        for (int i = 0; i < numOfVertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Add and edge into a graph
    void addEdge(int vertex, int edge) {
        adjacencyList[vertex].add(edge);
    }

    List<Integer> BFS(int source) {
        // Result of the BFS Traversal
        List<Integer> result = new ArrayList<>();

        // Mark all vertices as not visited by default
        boolean[] visited = new boolean[numOfVertices];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<>();

        // Mark the current node as visited an enqueue it
        visited[source] = true;
        queue.add(source);

        while (queue.size() != 0) {
            // Dequeue a vertex from queue and add it to the traversed list
            source = queue.poll();
            result.add(source);

            // Get all adjacent vertices of the dequeued vertex
            for (int n : adjacencyList[source]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        return result;
    }

    public LinkedList<Integer>[] getAdjacencyList() {
        return adjacencyList;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        List<Integer> result = graph.BFS(2);
        System.out.println(result.toString());
    }
}
