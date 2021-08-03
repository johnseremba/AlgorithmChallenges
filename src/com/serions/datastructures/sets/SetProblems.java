package com.serions.datastructures.sets;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

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
    }
}
