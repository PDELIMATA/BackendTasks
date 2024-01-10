package org.pdelimata.Tasks;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecondTaskTest {

    @ParameterizedTest
    @CsvSource({
            "'\n', 'Enter a list of integers separated by spaces:\nEmpty input. Please provide a list of integers.\n'",
            "'1 2 3 4 5\n', 'Enter a list of integers separated by spaces:\nPairs that sum up to 13:\n\n'",
            "'3 7 5 6\n', 'Enter a list of integers separated by spaces:\nPairs that sum up to 13:\n6 7\n\n'",
            "'1 2 10 7 5 3 6 6 13 0\n', 'Enter a list of integers separated by spaces:\nPairs that sum up to 13:\n0 13\n3 10\n6 7\n6 7\n\n'"
    })
    public void testCheckingPairsSummingThirteen(String input, String expectedOutput) {
        //given
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        try {
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));
            System.setIn(new ByteArrayInputStream(input.getBytes()));

            SecondTask task = new SecondTask();
            Scanner scanner = new Scanner(System.in);

            // when
            task.runTask(scanner);

            String normalizedExpectedOutput = expectedOutput.replace("\n", System.lineSeparator());
            String normalizedActualOutput = outContent.toString().replace("\r\n", "\n").replace("\n", System.lineSeparator());

            //then
            assertEquals(normalizedExpectedOutput, normalizedActualOutput);
        } finally {
            System.setOut(originalOut);
            System.setIn(originalIn);
        }
    }
}