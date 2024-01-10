package org.pdelimata.Tasks;

import java.util.*;
import java.util.stream.Collectors;

public class ThirdTask {

    public void runTask(Scanner scanner) {
        List<List<Integer>> input = readInputData(scanner);
        Map<Integer, List<Integer>> sortedData = getSortedData(input);

        int finalResult = calculateResult(sortedData);
        System.out.println("Result: " + finalResult);
        System.out.println();
    }

    private static List<List<Integer>> readInputData(Scanner scanner) {
        List<List<Integer>> allData = new ArrayList<>();
        System.out.println("Enter the number of data sets: ");
        int dataSetCount = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < dataSetCount; i++) {
            allData.add(getSortedInput(scanner.nextLine()));
        }
        return allData;
    }

    private static List<Integer> getSortedInput(String readLine) {
        List<Integer> result = convertInput(readLine);
        Collections.sort(result);
        return result;
    }

    private static List<Integer> convertInput(String str) {
        return Arrays.stream(str.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
    private static Map<Integer, List<Integer>> getSortedData(List<List<Integer>> input) {
        Map<Integer, List<Integer>> result = new HashMap<>();
        for (List<Integer> data : input) {
            if (!result.containsKey(data.get(0))) {
                result.put(data.get(0), new ArrayList<>());
            }
            List<Integer> list = result.get(data.get(0));
            if (!list.contains(data.get(1))) {
                list.add(data.get(1));
            }
        }
        return result;
    }

    private int calculateResult(Map<Integer, List<Integer>> sortedData) {
        int result = sortedData.size();
        Set<Integer> checkedValues = new HashSet<>();
        for (Map.Entry<Integer, List<Integer>> entry : sortedData.entrySet()) {
            if (checkedValues.contains(entry.getKey())) {
                result--;
            }
            checkedValues.add(entry.getKey());
            for (Integer value : entry.getValue()) {
                if (checkedValues.contains(value)) {
                    result--;
                }
                checkedValues.add(value);
            }
        }
        return result;
    }
}


