package com.AdventOfCode2025;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class Day7Tests {
    @Test
    void Test1Example() throws IOException {
        var day7 = new Day7();
        assertEquals(21, day7.Part1("/src/test/TestFiles2025/Day7Example.txt"));
    }

    @Test
    void Test1() throws IOException {
        var day7 = new Day7();
        assertEquals(5335495999141L, day7.Part1("/src/test/TestFiles2025/Day7.txt"));
    }

    @Test
    void Test2Example() throws IOException {
        var day7 = new Day7();
        assertEquals(40, day7.Part2("/src/test/TestFiles2025/Day7Example.txt"));
    }

    @Test
    void Test2() throws IOException {
        var day7 = new Day7();
        // 10092017166524 too low
        assertEquals(10142723156431L, day7.Part2("/src/test/TestFiles2025/Day7.txt"));
    }
}
