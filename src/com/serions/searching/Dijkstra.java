package com.serions.searching;

import java.util.*;

public class Dijkstra {
    public static class Graph {
        Set<Node> nodes = new HashSet<>();

        void addNode(Node node) {
            nodes.add(node);
        }
    }

    public static class Node {
        String name;
        List<Node> shortestPath = new LinkedList<>(); // list of nodes that describes the shortest path calculated from source node
        Integer distance = Integer.MAX_VALUE; // simulate an infinite distance
        Map<Node, Integer> adjacentNodes = new HashMap<>(); // Adjacent nodes with their distances

        void addDestination(Node destination, int distance) {
            adjacentNodes.put(destination, distance);
        }

        public Node(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static Graph calculateShortestPathFromSource(Graph graph, Node source) {
        source.distance = 0;
        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();
        unsettledNodes.add(source);

        while (unsettledNodes.size() != 0) {
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            // Evaluation
            for (Map.Entry<Node, Integer> adjacentPair : currentNode.adjacentNodes.entrySet()) {
                Node adjacentNode = adjacentPair.getKey();
                Integer edgeWeight = adjacentPair.getValue();
                if (!settledNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
        return graph;
    }

    private static Node getLowestDistanceNode(Set<Node> unsettledNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Node node : unsettledNodes) {
            int nodeDistance = node.distance;
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    private static void calculateMinimumDistance(Node evaluationNode, Integer edgeWeight, Node sourceNode) {
        Integer sourceDistance = sourceNode.distance;

        if ((sourceDistance + edgeWeight) < evaluationNode.distance) {
            evaluationNode.distance = sourceDistance + edgeWeight;
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.shortestPath);
            shortestPath.add(sourceNode);
            evaluationNode.shortestPath = shortestPath;
        }
    }

    public static void main(String[] args) {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        nodeA.addDestination(nodeB, 10);
        nodeA.addDestination(nodeC, 15);
        nodeB.addDestination(nodeD, 12);
        nodeB.addDestination(nodeF, 15);
        nodeC.addDestination(nodeE, 10);
        nodeD.addDestination(nodeE, 2);
        nodeD.addDestination(nodeF, 1);
        nodeF.addDestination(nodeE, 5);

        Graph graph = new Graph();
        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);

        graph = calculateShortestPathFromSource(graph, nodeA);
        System.out.println(nodeE.shortestPath.toString());
    }

}
