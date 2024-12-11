package com.AdventOfCode2024;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day10Tests {
    @Test
    void Test1Example() throws IOException {
        var day10 = new Day10();
        assertEquals(36, day10.part1("/src/test/TestFiles/Day10Example.txt"));
    }
    // 882304363039 too high
    @Test
    void Test1() throws IOException {
        var day10 = new Day10();
        // 882304362421
        assertEquals(299, day10.part1("/src/test/TestFiles/Day10.txt"));
    }

    @Test
    void Test2Example() throws IOException {
        var day10 = new Day10();
        assertEquals(2858, day10.part2("/src/test/TestFiles/Day10Example.txt"));
    }

    @Test
    void Test2() throws IOException {
        var day10 = new Day10();
        assertEquals(1032, day10.part2("/src/test/TestFiles/Day10.txt"));
    }
}
