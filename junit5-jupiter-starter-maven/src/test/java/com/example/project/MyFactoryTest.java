package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import static org.junit.jupiter.api.DynamicTest.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.ThrowingConsumer;


class MyFactoryTest {

   	@TestFactory
    Iterable<DynamicTest> dynamicTestsWithIterable() {
        return Arrays.asList(
        DynamicTest.dynamicTest("Add test",
        () -> assertEquals(2, Math.addExact(1, 1))),
        DynamicTest.dynamicTest("Multiply Test",
        () -> assertEquals(4, Math.multiplyExact(2, 2))));
    }

    @TestFactory
    public Collection<DynamicTest> simpleDynamicTest() {
        return Collections.singleton(dynamicTest("simple dynamic test", () -> assertTrue(2 > 1)));
    }

    @TestFactory
    public Stream<DynamicTest> streamDynamicTest() {
    return stream(
        Stream.of("Hello", "World").iterator(),
        (word) -> String.format("Test - %s", word),
        (word) -> assertTrue(word.length() < 4)
    );
    }
    
    @TestFactory
    Iterator<DynamicTest> dynamicTestsFromIterator() {
        return Arrays.asList(
            dynamicTest("5th dynamic test", () -> assertTrue(true)),
            dynamicTest("6th dynamic test", () -> assertEquals(4, 2 * 2))
        ).iterator();
    }    

    @TestFactory
    Stream<DynamicTest> generateRandomNumberOfTests() {

        // Generates random positive integers between 0 and 100 until
        // a number evenly divisible by 7 is encountered.
        Iterator<Integer> inputGenerator = new Iterator<Integer>() {

            Random random = new Random();
            int current;

            @Override
            public boolean hasNext() {
                current = random.nextInt(100);
                return current % 7 != 0;
            }

            @Override
            public Integer next() {
                return current;
            }
        };

        // Generates display names like: input:5, input:37, input:85, etc.
        Function<Integer, String> displayNameGenerator = (input) -> "input:" + input;

        // Executes tests based on the current input value.
        ThrowingConsumer<Integer> testExecutor = (input) -> assertTrue(input % 7 != 0);

        // Returns a stream of dynamic tests.
        return DynamicTest.stream(inputGenerator, displayNameGenerator, testExecutor);
    }
   
}
