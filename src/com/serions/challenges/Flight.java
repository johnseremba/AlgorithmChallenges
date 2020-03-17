package com.serions.challenges;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * We are tracking down our rogue agent and she travels from place to place to avoid being tracked. Each of her travels are based on a list of itineraries in an unusual or incorrect order. The task is to determine the complete route she will take.
 * You are given an array of routes containing her travel itineraries. Convert this into a complete, in-order list of the places she will travel.
 * Specification
 * findRoutes(routes)
 * Parameters
 * routes: Array<Array<String>> - Array of itineraries
 * Return Value
 * String - An ordered list or destinations
 * Constraints
 * All inputs have at least one valid, complete route
 * Examples
 * input;
 * [["USA","BRA"],["JPN","PHL"],["BRA","UAE"],["UAE","JPN"]]
 *
 * output;
 * "USA, BRA, UAE, JPN, PHL"
 * */

public class Flight {
    static class Node {
        Node prev;
        Node next;
        String data;

        public Node(String data) {
            this.data = data;
        }

        @Override
        public String toString() {
            String next = "";
            String prev = "";
            if (this.next != null) {
                next = this.next.data;
            }
            if (this.prev != null) {
                prev = this.prev.data;
            }
            return " { next: " + next +
                    " prev: " + prev +
                    " data: " + this.data + " } ";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return data.equals(node.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }
    }

    static class Routes {
        Node head;
        List<Node> nodesList = new ArrayList<>();

        public Routes(String[][] routes) {
            for (String[] str : routes) {
                String data = str[0];
                String next = str[1];
                insert(data, next);
            }
        }

        public Node getNodeByString(String data) {
            for (Node node : nodesList) {
                String str = node.data;
                if (str.equalsIgnoreCase(data)) return node;
            }
            return null;
        }

        public void insert(String data, String next) {
            Node node = getNodeByString(data);
            Node nextNode = getNodeByString(next);

            if (nextNode == null) {
                nextNode = new Node(next);
            }
            if (node == null) {
                node = new Node(data);
            }
            nextNode.prev = node;
            node.next = nextNode;

            nodesList.remove(nextNode);
            nodesList.remove(node);
            nodesList.add(nextNode);
            nodesList.add(node);

            head = getRootNode();
        }

        public Node getRootNode() {
            for (Node node : nodesList) {
                if (node.prev == null) return node;
            }
            return null;
        }

        public String printList() {
            StringBuilder sb = new StringBuilder();
            Node currentNode = head;

            while (currentNode != null) {
                sb.append(currentNode.data).append(", ");
                currentNode = currentNode.next;
            }

            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Routes routes = new Routes(new String[][]{
                {"Chicago", "Winnipeg"},
                {"Halifax", "Montreal"},
                {"Montreal", "Toronto"},
                {"Toronto", "Chicago"},
                {"Winnipeg", "Seattle"}
        });
        System.out.println(routes.printList());
    }
}
