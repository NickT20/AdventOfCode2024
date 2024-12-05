package com.AdventOfCode2024;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day5Tests {
    @Test
    void Test1Example() throws IOException {
        var day5 = new Day5();
        assertEquals(143, day5.Part1("/src/test/TestFiles/Day5Example.txt"));
    }

    @Test
    void Test1() throws IOException {
        var day5 = new Day5();
        assertEquals(4135, day5.Part1("/src/test/TestFiles/Day5.txt"));
    }

    @Test
    void Test2Example() throws IOException {
        var day5 = new Day5();
        assertEquals(123, day5.Part2("/src/test/TestFiles/Day5Example.txt"));
    }

    @Test
    void Test2() throws IOException {
        var day5 = new Day5();
        assertEquals(5285, day5.Part2("/src/test/TestFiles/Day5.txt"));
    }
}
