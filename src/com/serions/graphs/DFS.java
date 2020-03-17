package com.serions.graphs;

import java.util.*;

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

        // Topological Sort
        public List<Integer> topologicalSort(int start) {
            LinkedList<Integer> result = new LinkedList<>();
            boolean[] visited = new boolean[numOfVertices];
            topologicalSortRecursive(start, visited, result);
            return result;
        }

        private void topologicalSortRecursive(int current, boolean[] visited, LinkedList<Integer> result) {
            visited[current] = true;
            for (int dest : adjacencyList[current]) {
                if (!visited[dest]) {
                    topologicalSortRecursive(dest, visited, result);
                }
            }
            result.addFirst(current);
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
        System.out.println();

        List<Integer> result = graph.topologicalSort(2);
        System.out.println(result.toString());
    }
}
