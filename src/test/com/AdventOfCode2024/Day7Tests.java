package com.AdventOfCode2024;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day7Tests {
    @Test
    void Test1Example() throws IOException {
        var day7 = new Day7();
        assertEquals(BigInteger.valueOf(3749), day7.Part1("/src/test/TestFiles/Day7Example.txt"));
    }

    // 882304363039 too high
    @Test
    void Test1() throws IOException {
        var day7 = new Day7();
        assertEquals(5030, day7.Part1("/src/test/TestFiles/Day7.txt"));
    }

    @Test
    void Test2Example() throws IOException {
        var day7 = new Day7();
        assertEquals(6, day7.Part2("/src/test/TestFiles/Day7Example.txt"));
    }

    @Test
    void Test2() throws IOException {
        var day7 = new Day7();
        assertEquals(5285, day7.Part2("/src/test/TestFiles/Day7.txt"));
    }
}
