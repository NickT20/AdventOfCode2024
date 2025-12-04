package com.AdventOfCode2025;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day3Tests {
    @Test
    void Test1Example() throws IOException {
        var day3 = new Day3();
        assertEquals(357, day3.Part1("/src/test/TestFiles2025/Day3Example.txt"));
    }

    @Test
    void Test1() throws IOException {
        var day3 = new Day3();
        assertEquals(17359, day3.Part1("/src/test/TestFiles2025/Day3.txt"));
    }

    @Test
    void Test2Example() throws IOException {
        var day3 = new Day3();
        assertEquals(3121910778619L, day3.Part2("/src/test/TestFiles2025/Day3Example.txt"));
    }

    @Test
    void Test2() throws IOException {
        var day3 = new Day3();
        assertEquals(172787336861064L, day3.Part2("/src/test/TestFiles2025/Day3.txt"));
    }
}
