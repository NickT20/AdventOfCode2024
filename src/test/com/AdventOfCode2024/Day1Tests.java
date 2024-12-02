package com.AdventOfCode2024;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day1Tests {
    @Test
    void Test1Example() throws IOException {
        var day1 = new Day1();
        assertEquals(11, day1.Part1("/src/test/TestFiles/Day1Example.txt"));
    }

    @Test
    void Test1() throws IOException {
        var day1 = new Day1();
        assertEquals(1110981, day1.Part1("/src/test/TestFiles/Day1.txt"));
    }

    @Test
    void Test2Example() throws IOException {
        var day1 = new Day1();
        assertEquals(31, day1.Part2("/src/test/TestFiles/Day1Example.txt"));
    }

    @Test
    void Test2() throws IOException {
        var day1 = new Day1();
        assertEquals(24869388, day1.Part2("/src/test/TestFiles/Day1.txt"));
    }
}
