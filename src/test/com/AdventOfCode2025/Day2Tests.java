package com.AdventOfCode2025;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class Day2Tests {
    @Test
    void Test1Example() throws IOException {
        var day2 = new com.AdventOfCode2025.Day2();
        assertEquals(1227775554, day2.Part1("/src/test/TestFiles2025/Day2Example.txt"));
    }

    @Test
    void Test1() throws IOException {
        var day2 = new com.AdventOfCode2025.Day2();
        assertEquals(1227775554, day2.Part1("/src/test/TestFiles2025/Day2.txt"));
    }

    @Test
    void Test2Example() throws IOException {
        var day1 = new com.AdventOfCode2025.Day1();
        assertEquals(6, day1.Part2("/src/test/TestFiles2025/Day1Example.txt"));
    }

    @Test
    void Test2() throws IOException {
        var day1 = new Day1();
        assertEquals(7199, day1.Part2("/src/test/TestFiles2025/Day1.txt"));
    }
}
