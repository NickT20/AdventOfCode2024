package com.AdventOfCode2025;

import java.io.IOException;

import com.AdventOfCode2025.Day1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day1Tests {
    @Test
    void Test1Example() throws IOException {
        var day1 = new com.AdventOfCode2025.Day1();
        assertEquals(3, day1.Part1("/src/test/TestFiles2025/Day1Example.txt"));
    }

    @Test
    void Test1() throws IOException {
        var day1 = new com.AdventOfCode2025.Day1();
        assertEquals(1168, day1.Part1("/src/test/TestFiles2025/Day1.txt"));
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
