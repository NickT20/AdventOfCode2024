package com.AdventOfCode2025;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class Day8Tests {
    @Test
    void Test1Example() throws IOException {
        var Day8 = new Day8();
        assertEquals(40, Day8.Part1("/src/test/TestFiles2025/Day8Example.txt"));
    }

    @Test
    void Test1() throws IOException {
        var Day8 = new Day8();
        assertEquals(79560, Day8.Part1("/src/test/TestFiles2025/Day8.txt"));
    }

    @Test
    void Test2Example() throws IOException {
        var Day8 = new Day8();
        assertEquals(25272, Day8.Part2("/src/test/TestFiles2025/Day8Example.txt"));
    }

    @Test
    void Test2() throws IOException {
        var Day8 = new Day8();
        // 10092017166524 too low
        assertEquals(31182420, Day8.Part2("/src/test/TestFiles2025/Day8.txt"));
    }
}
