package com.AdventOfCode2024;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day3Tests {
    @Test
    void Test1Example() throws IOException {
        var day3 = new Day3();
        assertEquals(161, day3.Part1("/src/test/TestFiles/Day3Example.txt"));
    }

    @Test
    void Test1() throws IOException {
        var day3 = new Day3();
        assertEquals(192767529, day3.Part1("/src/test/TestFiles/Day3.txt"));
    }

    @Test
    void Test2Example() throws IOException {
        var day3 = new Day3();
        assertEquals(48, day3.Part2("/src/test/TestFiles/Day3Example.txt"));
    }

    // 110561937 - too high
    @Test
    void Test2() throws IOException {
        var day3 = new Day3();
        assertEquals(104083373, day3.Part2("/src/test/TestFiles/Day3.txt"));
    }
}
