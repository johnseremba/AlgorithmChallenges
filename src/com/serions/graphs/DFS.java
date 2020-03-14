package com.serions.graphs;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class DFS {
    static class Graph {
        private int numOfVertices;
        private LinkedList<Integer>[] adjacencyList;

        public Graph(int numOfVertices) {
            this.numOfVertices = numOfVertices;
            this.adjacencyList = new LinkedList[numOfVertices];

            for (int i = 0; i < numOfVertices; i++) {
                adjacencyList[i] = new LinkedList<>();
            }
        }

        void addEdge(int vertex, int edge) {
            adjacencyList[vertex].add(edge);
        }

        // Implement DFS with recursion
        void DFSWithRecursion(int start) {
            boolean[] visited = new boolean[numOfVertices];
            dfsRecursive(start, visited);
        }

        void dfsRecursive(int current, boolean[] visited) {
            visited[current] = true;
            visit(current);

            for (int dest : adjacencyList[current]) {
                if (!visited[dest]) {
                    dfsRecursive(dest, visited);
                }
            }
        }

        // DFS without recursion
        void dfsWithoutRecursion(int start) {
            Stack<Integer> stack = new Stack<>();
            boolean[] visited = new boolean[numOfVertices];

            // Push starting node into the stack
            stack.push(start);

            while (!stack.isEmpty()) {
                int current = stack.pop();
                visited[current] = true;
                visit(current);

                for (int dest : adjacencyList[current]) {
                    if (!visited[dest]) {
                        stack.push(dest);
                    }
                }
            }
        }

        void visit(int vertex) {
            System.out.print(vertex + " ");
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

        graph.DFSWithRecursion(2);
        System.out.println();
        graph.dfsWithoutRecursion(2);
    }
}
