package com.AdventOfCode2024;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day12Tests {
    @Test
    void Test1Example() throws IOException {
        var day12 = new Day12();
        assertEquals(1930, day12.part1("/src/test/TestFiles/Day12Example.txt"));
    }

    @Test
    void Test1() throws IOException {
        var day12 = new Day12();
        assertEquals(299, day12.part1("/src/test/TestFiles/Day12.txt"));
    }

    @Test
    void Test2Example() throws IOException {
        var day12 = new Day12();
        // 8298105970
        assertEquals(0, day12.part2("/src/test/TestFiles/Day12Example.txt"));
    }

    @Test
    void Test2() throws IOException {
        var day12 = new Day12();
        assertEquals(1032, day12.part2("/src/test/TestFiles/Day12.txt"));
    }
}
