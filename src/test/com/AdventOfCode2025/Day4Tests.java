package com.AdventOfCode2025;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class Day4Tests {
    @Test
    void Test1Example() throws IOException {
        var day4 = new Day4();
        assertEquals(13, day4.Part1("/src/test/TestFiles2025/Day4Example.txt"));
    }

    @Test
    void Test1() throws IOException {
        var day4 = new Day4();
        assertEquals(1424, day4.Part1("/src/test/TestFiles2025/Day4.txt"));
    }

    @Test
    void Test2Example() throws IOException {
        var day4 = new Day4();
        assertEquals(3121910778619L, day4.Part2("/src/test/TestFiles2025/Day4Example.txt"));
    }

    @Test
    void Test2() throws IOException {
        var day4 = new Day4();
        assertEquals(172787336861064L, day4.Part2("/src/test/TestFiles2025/Day4.txt"));
    }
}
