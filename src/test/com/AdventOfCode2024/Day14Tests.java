package com.AdventOfCode2024;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day14Tests {
    @Test
    void Test1Example() throws IOException {
        var day14 = new Day14();
        assertEquals(12, day14.part1("/src/test/TestFiles/Day14Example.txt", 11, 7));
    }

    @Test
    void Test1() throws IOException {
        var day14 = new Day14();
        assertEquals(224438715, day14.part1("/src/test/TestFiles/Day14.txt", 101, 103));
    }

    @Test
    void Test2Example() throws IOException {
        var day14 = new Day14();
        assertEquals(480, day14.part2("/src/test/TestFiles/Day14Example.txt", 11, 7));
    }

    @Test
    void Test2() throws IOException {
        var day14 = new Day14();
        assertEquals(7603, day14.part2("/src/test/TestFiles/Day14.txt", 101, 103));
    }
}
