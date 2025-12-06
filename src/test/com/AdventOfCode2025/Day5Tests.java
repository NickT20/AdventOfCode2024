package com.AdventOfCode2025;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class Day5Tests {
    @Test
    void Test1Example() throws IOException {
        var day5 = new Day5();
        assertEquals(3, day5.Part1("/src/test/TestFiles2025/Day5Example.txt"));
    }

    @Test
    void Test1() throws IOException {
        var day5 = new Day5();
        assertEquals(613, day5.Part1("/src/test/TestFiles2025/Day5.txt"));
    }

    @Test
    void Test2Example() throws IOException {
        var day5 = new Day5();
        assertEquals(14, day5.Part2("/src/test/TestFiles2025/Day5Example.txt"));
    }

    @Test
    void Test2() throws IOException {
        var day5 = new Day5();
        // too high 391291976643862
        // too high 388518907260115
        // not right 337273250657995
        // not right 337273250657987
        // not right 337253734761542
        // not right 335677576867788
        // right -   336495597913098
        assertEquals(336495597913098L, day5.Part2("/src/test/TestFiles2025/Day5.txt"));
    }
}
