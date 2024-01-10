package org.pdelimata.Tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SecondTask {

    public void runTask(Scanner scanner) {
        System.out.println("Enter a list of integers separated by spaces:");
        String input = scanner.nextLine();

        if (input.isBlank()) {
            System.out.println("Empty input. Please provide a list of integers.");
            return;
        }

        ArrayList<Integer> list = convertInput(input);


        System.out.println("Pairs that sum up to 13:");
        printPairsSumThirteen(list);
        System.out.println();
    }

    private static ArrayList<Integer> convertInput(String input) {
        return (ArrayList<Integer>) Arrays.stream(input.split(" "))
                .toList()
                .stream()
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
    }

    private void printPairsSumThirteen(ArrayList<Integer> list) {

        for (Integer element : list) {
            if (element < 7 && list.contains(13 - element)) {
                System.out.println(element + " " + (13 - element));
            }
        }
    }
}

