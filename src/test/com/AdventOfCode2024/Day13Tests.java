package com.AdventOfCode2024;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day13Tests {
    @Test
    void Test1Example() throws IOException {
        var day13 = new Day13();
        assertEquals(480, day13.part1("/src/test/TestFiles/Day13Example.txt"));
    }

    @Test
    void Test1() throws IOException {
        var day13 = new Day13();
        assertEquals(299, day13.part1("/src/test/TestFiles/Day13.txt"));
    }

    @Test
    void Test2Example() throws IOException {
        var day13 = new Day13();
        assertEquals(480, day13.part2("/src/test/TestFiles/Day13Example.txt"));
    }

    @Test
    void Test2() throws IOException {
        var day13 = new Day13();
        assertEquals(1032, day13.part2("/src/test/TestFiles/Day13.txt"));
    }
}
