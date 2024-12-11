package com.AdventOfCode2024;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day9Tests {
    @Test
    void Test1Example() throws IOException {
        var day9 = new Day9();
        assertEquals(1928, day9.part1("/src/test/TestFiles/Day9Example.txt"));
    }
    // 882304363039 too high
    @Test
    void Test1() throws IOException {
        var day9 = new Day9();
        // 882304362421
        assertEquals(299, day9.part1("/src/test/TestFiles/Day9.txt"));
    }

    @Test
    void Test2Example() throws IOException {
        var day9 = new Day9();
        assertEquals(2858, day9.part2("/src/test/TestFiles/Day9Example.txt"));
    }

    @Test
    void Test2() throws IOException {
        var day9 = new Day9();
        assertEquals(1032, day9.part2("/src/test/TestFiles/Day9.txt"));
    }
}
