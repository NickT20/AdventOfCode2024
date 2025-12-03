package com.AdventOfCode2024;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Instant;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day16Tests {
    @Test
    void Test1Example() throws IOException {
        var day16 = new Day16();
        assertEquals(11048, day16.part1("/src/test/TestFiles/Day16Example.txt"));
    }

    @Test
    void Test1() throws IOException {
        var day16 = new Day16();
        assertEquals(143564, day16.part1("/src/test/TestFiles/Day16.txt"));
    }

    @Test
    void Test2Example() throws IOException {
        var day16 = new Day16();
        assertEquals(9021, day16.part2("/src/test/TestFiles/Day16Example.txt"));
    }

    // 1540517 - too low
    // 1548955 - too high
    @Test
    void Test2() throws IOException {
        var day16 = new Day16();
        assertEquals(1543141, day16.part2("/src/test/TestFiles/Day16.txt"));
    }
}
