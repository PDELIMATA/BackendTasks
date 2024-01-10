package org.pdelimata.Tasks;

import java.util.*;
import java.util.stream.Collectors;

public class FirstTask {

    public void runTask(Scanner scanner) {
        System.out.println("Enter a list of integers separated by spaces:");
        String input = scanner.nextLine();

        if (input.isEmpty()) {
            System.out.println("Empty input. Please provide a list of integers.");
            return;
        }

        List<Integer> list = convertInput(input);

        Set<Integer> sortedSet = new TreeSet<>(list);
        printResult(list, sortedSet);
    }


    private static List<Integer> convertInput(String str) {
        return Arrays.stream(str.split(" "))
                .map(Integer::parseInt).sorted().collect(Collectors.toList());
    }

    private static void printResult(List<Integer> list, Set<Integer> set) {
        System.out.println("Result:");
        printSet(set);
        System.out.println("count: " + list.size());
        System.out.println("distinct: " + set.size());
        System.out.println("min: " + list.get(0));
        System.out.println("max: " + list.get(list.size() - 1));
        System.out.println();
    }

    private static void printSet(Set<Integer> set) {
        for (Integer element : set) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
