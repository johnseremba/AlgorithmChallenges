package com.serions.graphs;

import java.util.Arrays;
import java.util.LinkedList;

public class BFS {
    static class Graph {
        private int numOfVertices;
        private LinkedList<Integer>[] adjacencyList;

        public Graph(int numOfVertices) {
            this.numOfVertices = numOfVertices;
            this.adjacencyList = new LinkedList[numOfVertices];

            // Initialize Adjacency list
            for (int i = 0; i < numOfVertices; i++) {
                adjacencyList[i] = new LinkedList<>();
            }
        }

        void addEdge(int vertex, int edge) {
            adjacencyList[vertex].add(edge);
        }

        void BFS(int source) {
            // Mark all nodes as not visited by default
            boolean[] visited = new boolean[numOfVertices];

            // Queue to store traversed nodes
            LinkedList<Integer> queue = new LinkedList<>();

            // Mark source node as visited and add it to queue
            visited[source] = true;
            queue.add(source);

            while (queue.size() != 0) {
                // dequeue vertex and print it
                int n = queue.poll();
                System.out.print(n + " ");
                for (int i : adjacencyList[n]) {
                    if (!visited[i]) {
                        visited[i] = true;
                        queue.add(i);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println(Arrays.toString(graph.adjacencyList));
        graph.BFS(2);
    }
}
