package com.AdventOfCode2024;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day11Tests {
    @Test
    void Test1Example() throws IOException {
        var day11 = new Day11();
        assertEquals(55312, day11.part1("/src/test/TestFiles/Day11Example.txt"));
    }

    @Test
    void Test1() throws IOException {
        var day11 = new Day11();
        assertEquals(299, day11.part1("/src/test/TestFiles/Day11.txt"));
    }

    @Test
    void Test2Example() throws IOException {
        var day11 = new Day11();
        // 8298105970
        assertEquals(0, day11.part2("/src/test/TestFiles/Day11Example.txt"));
    }

    // 56,538,899 too low
    // 60,156,581 wrong
    // 207961583799296
    @Test
    void Test2() throws IOException {
        var day11 = new Day11();
        assertEquals(1032, day11.part2("/src/test/TestFiles/Day11.txt"));
    }
}
