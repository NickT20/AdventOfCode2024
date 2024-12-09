package com.AdventOfCode2024;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day8Tests {
    @Test
    void Test1Example() throws IOException {
        var day8 = new Day8();
        assertEquals(14, day8.part1("/src/test/TestFiles/Day8Example.txt"));
    }
    // 882304363039 too high
    @Test
    void Test1() throws IOException {
        var day8 = new Day8();
        // 882304362421
        assertEquals(299, day8.part1("/src/test/TestFiles/Day8.txt"));
    }

    @Test
    void Test2Example() throws IOException {
        var day8 = new Day8();
        assertEquals(34, day8.part2("/src/test/TestFiles/Day8Example.txt"));
    }

    @Test
    void Test2() throws IOException {
        var day8 = new Day8();
        assertEquals(1032, day8.part2("/src/test/TestFiles/Day8.txt"));
    }
}
