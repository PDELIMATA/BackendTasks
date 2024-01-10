package org.pdelimata.Tasks;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FirstTaskTest {

    @ParameterizedTest
    @CsvSource({
            "4 2 2 1 3 4 4 5, 'Enter a list of integers separated by spaces:\n1 2 3 4 5 \ncount: 8\ndistinct: 5\nmin: 1\nmax: 5\n\n'",
            "'\n', 'Enter a list of integers separated by spaces:\nEmpty input. Please provide a list of integers.\n'",
            "5, 'Enter a list of integers separated by spaces:\n5 \ncount: 1\ndistinct: 1\nmin: 5\nmax: 5\n\n'",
            "-4 -2 -2 -1 -3 -4 -4 -5, 'Enter a list of integers separated by spaces:\n-5 -4 -3 -2 -1 \ncount: 8\ndistinct: 5\nmin: -5\nmax: -1\n\n'"
    })
    public void testDistinctSortingWithStatistics(String input, String expectedOutput) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        Scanner scanner = new Scanner(System.in);
        FirstTask firstTask = new FirstTask();
        firstTask.runTask(scanner);

        String normalizedExpectedOutput = expectedOutput.replace("\n", System.lineSeparator());
        String normalizedActualOutput = outputStream.toString().replace("\r\n", "\n").replace("\n", System.lineSeparator());

        assertEquals(normalizedExpectedOutput, normalizedActualOutput);
    }
}