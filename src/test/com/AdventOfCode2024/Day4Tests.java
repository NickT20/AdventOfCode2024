package com.AdventOfCode2024;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day4Tests {
    @Test
    void Test1Example() throws IOException {
        var day4 = new Day4();
        assertEquals(18, day4.Part1("/src/test/TestFiles/Day4Example.txt"));
    }

    @Test
    void Test1() throws IOException {
        var day4 = new Day4();
        assertEquals(2685, day4.Part1("/src/test/TestFiles/Day4.txt"));
    }

    @Test
    void Test2Example() throws IOException {
        var day4 = new Day4();
        assertEquals(9, day4.Part2("/src/test/TestFiles/Day4Example.txt"));
    }

    @Test
    void Test2() throws IOException {
        var day4 = new Day4();
        assertEquals(2048, day4.Part2("/src/test/TestFiles/Day4.txt"));
    }
}
