package org.pdelimata.Tasks;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ThirdTaskTest {

    @ParameterizedTest
    @MethodSource("testCases")
    public void testNumbersOfSeparatedGraphs(int expectedOutput, String input) {
        //given
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        try {
            System.setIn(inputStream);
            System.setOut(printStream);

            ThirdTask thirdTask = new ThirdTask();

            //when
            thirdTask.runTask(new java.util.Scanner(System.in));

            String normalizedExpectedOutput = "Enter the number of data sets: " + System.lineSeparator() + "Result: " + expectedOutput;
            String normalizedActualOutput = outputStream.toString().trim().replace("\r\n", "\n").replace("\n", System.lineSeparator());

            //then
            assertEquals(normalizedExpectedOutput, normalizedActualOutput);
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                arguments(4, "10\n1 2\n1 5\n2 3\n57 111\n333 666\n57 33\n11 12\n11 4\n5 7\n7 8\n"),
                arguments(1, "3\n1 2\n1 5\n2 3\n"),
                arguments(2, "2\n-4 -5\n-6 -7\n")
        );
    }
}