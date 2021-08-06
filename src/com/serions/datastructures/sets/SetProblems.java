package com.serions.datastructures.sets;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetProblems {
    public static void main(String[] args) {
        Set<String> set1 = new LinkedHashSet<>();
        set1.add("set");
        set1.add("paper");

        Set<String> set2 = new LinkedHashSet<>();
        set2.add("paper");
        set2.add("scissors");

        // Union of set 1 and set 2
        Set<String> union_data = new HashSet<>(set1);
        union_data.addAll(set1);
        System.out.println(union_data);

        // Intersection data
        Set<String> intersection_data = new HashSet<>(set1);
        intersection_data.retainAll(set2);
        System.out.println(intersection_data);

        // Difference of set 1 and set 2
        Set<String> difference_data = new HashSet<>(set1);
        difference_data.removeAll(set2);
        System.out.println(difference_data);

        // TreeSet is used when sorting is important
        // add returns false when you try to add a duplicate element to a set
        Set<Integer> sortedSet = new TreeSet<>();
        sortedSet.add(3);
        sortedSet.add(4);
        sortedSet.add(8);
        sortedSet.add(1);
        sortedSet.add(2);
        sortedSet.add(29);
        System.out.println(sortedSet);
    }
}
