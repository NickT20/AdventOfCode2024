package com.AdventOfCode2025;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day5Tests {
    @Test
    void Test1Example() throws IOException {
        var day5 = new Day5();
        assertEquals(3, day5.Part1("/src/test/TestFiles2025/Day5Example.txt"));
    }

    @Test
    void Test1() throws IOException {
        var day5 = new Day5();
        assertEquals(613, day5.Part1("/src/test/TestFiles2025/Day5.txt"));
    }

    @Test
    void Test2Example() throws IOException {
        var day5 = new Day5();
        assertEquals(14, day5.Part2("/src/test/TestFiles2025/Day5Example.txt"));
    }

    @Test
    void Test2() throws IOException {
        var day5 = new Day5();
        // too high 391291976643862
        assertEquals(391291976643862L, day5.Part2("/src/test/TestFiles2025/Day5.txt"));
    }
}
