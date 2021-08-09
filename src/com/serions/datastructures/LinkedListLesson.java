package com.serions.datastructures;

import java.util.LinkedList;

public class LinkedListLesson {
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<>();
        ll.add("A");
        ll.add("B");
        ll.add("C");
        ll.add("D");
        ll.add(2, "F");
        System.out.println(ll);
    }
}
