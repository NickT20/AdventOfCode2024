package com.AdventOfCode2024;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day6Tests {
    @Test
    void Test1Example() throws IOException {
        var day6 = new Day6();
        assertEquals(41, day6.Part1("/src/test/TestFiles</Day6Example.txt"));
    }

    // 5503 too high
    // 5316 too high
    @Test
    void Test1() throws IOException {
        var day6 = new Day6();
        assertEquals(5030, day6.Part1("/src/test/TestFiles/Day6.txt"));
    }

    @Test
    void Test2Example() throws IOException {
        var day6 = new Day6();
        assertEquals(6, day6.Part2("/src/test/TestFiles/Day6Example.txt"));
    }

    @Test
    void Test2() throws IOException {
        var day6 = new Day6();
        assertEquals(5285, day6.Part2("/src/test/TestFiles/Day6.txt"));
    }
}
