package com.AdventOfCode2025;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class Day6Tests {
    @Test
    void Test1Example() throws IOException {
        var day6 = new Day6();
        assertEquals(4277556, day6.Part1("/src/test/TestFiles2025/Day6Example.txt"));
    }

    @Test
    void Test1() throws IOException {
        var day6 = new Day6();
        assertEquals(5335495999141L, day6.Part1("/src/test/TestFiles2025/Day6.txt"));
    }

    @Test
    void Test2Example() throws IOException {
        var day6 = new Day6();
        assertEquals(3263827, day6.Part2("/src/test/TestFiles2025/Day6Example.txt"));
    }

    @Test
    void Test2() throws IOException {
        var day6 = new Day6();
        // 10092017166524 too low
        assertEquals(10142723156431L, day6.Part2("/src/test/TestFiles2025/Day6.txt"));
    }
}
