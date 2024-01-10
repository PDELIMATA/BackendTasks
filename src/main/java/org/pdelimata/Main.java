package org.pdelimata;

import org.pdelimata.Tasks.FirstTask;
import org.pdelimata.Tasks.SecondTask;
import org.pdelimata.Tasks.ThirdTask;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.println("Choose task: enter 1, 2 or 3");
            System.out.println("Exit, enter q");

            input = scanner.nextLine();
            switch (input) {
                case "1" -> {
                    System.out.println("Task 1, enter input:");
                    FirstTask firstTask = new FirstTask();
                    firstTask.runTask(scanner);
                }
                case "2" -> {
                    System.out.println("Task 2, enter input:");
                    SecondTask secondTask = new SecondTask();
                    secondTask.runTask(scanner);
                }
                case "3" -> {
                    System.out.println("Task 3, enter input:");
                    ThirdTask thirdTask = new ThirdTask();
                    thirdTask.runTask(scanner);
                }
            }
        } while (!input.equals("q"));
        scanner.close();
    }
}