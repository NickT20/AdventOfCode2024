package com.AdventOfCode2024;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day2Tests {
    @Test
    void Test1Example() throws IOException {
        var day2 = new Day2();
        assertEquals(2, day2.Part1("/src/test/TestFiles/Day2Example.txt", false));
    }

    @Test
    void Test1() throws IOException {
        var day2 = new Day2();
        assertEquals(591, day2.Part1("/src/test/TestFiles/Day2.txt", false));
    }

    @Test
    void Test2Example() throws IOException {
        var day2 = new Day2();
        assertEquals(4, day2.Part1("/src/test/TestFiles/Day2Example.txt", true));
    }

    @Test
    void Test2() throws IOException {
        var day2 = new Day2();
        assertEquals(620, day2.Part1("/src/test/TestFiles/Day2.txt", true));
    }
}
