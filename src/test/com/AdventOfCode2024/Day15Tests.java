package com.AdventOfCode2024;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day15Tests {
    @Test
    void Test1Example() throws IOException {
        var day15 = new Day15();
        assertEquals(10092, day15.part1("/src/test/TestFiles/Day15Example.txt"));
    }

    @Test
    void Test1() throws IOException {
        var day15 = new Day15();
        assertEquals(224438715, day15.part1("/src/test/TestFiles/Day15.txt"));
    }

    @Test
    void Test2Example() throws IOException {
        var day15 = new Day15();
        assertEquals(9021, day15.part2("/src/test/TestFiles/Day15Example.txt"));
    }

    // 1540517 - too low
    // 1548955 - too high
    @Test
    void Test2() throws IOException {
        var day15 = new Day15();
        assertEquals(1543141, day15.part2("/src/test/TestFiles/Day15.txt"));
    }
}
