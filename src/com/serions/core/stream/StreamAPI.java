package com.serions.core.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {
    public static void main(String[] args) {
        String[] arr = new String[]{"a", "b", "c", "a", "c"};
        Stream<String> stream = Arrays.stream(arr);
        // find distinct elements in list
        System.out.println(stream.distinct().count());

        // Check if an element contains
        boolean exists = Arrays.stream(arr).anyMatch(element -> element.contains("a"));

        // Filtering
        List<String> list = Arrays.asList("One", "OneAndOnly", "Derek");
        Stream<String> listStream = list.stream().filter(element -> element.contains("One"));
        System.out.println(listStream.collect(Collectors.toList()));

        // Mapping
        List<Integer> anotherList = Arrays.asList(1,2,3,4,5,6);
        Stream<Integer> modifiedStream = anotherList.stream().map(e -> e*2);
        System.out.println(modifiedStream.collect(Collectors.toSet()));

        // Matching
        List<String> matchingList = Arrays.asList("hey", "hello", "bonjour");
        boolean isValid = matchingList.stream().anyMatch(e -> e.contains("e"));
        boolean isValidOne = matchingList.stream().allMatch(String::isEmpty);
        boolean isValidTwo = matchingList.stream().noneMatch(e -> e.contains("not-in-list"));
        System.out.println(isValid + ", " + isValidOne + ", " + isValidTwo);

        // Reduction
        List<Integer> integers = Arrays.asList(100, 100, 100, -10);
        // reduce requires two params, the start value, and an accumulator function
        int reduced = integers.stream().reduce(5, (x, y) -> x * y);
        System.out.println(reduced);

        int sum = integers.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);

        // Collecting
        List<String> resultList = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(resultList);
    }
}
