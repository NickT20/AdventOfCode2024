package com.AdventOfCode2024;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;

public class Day7 {
    public long Part1(String file) throws IOException {
        long result = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            while (br.ready()) {
                var line = br.readLine();
                var part1 = line.split(": ");
                var part2 = part1[1].split(" ");
                long total = Long.parseLong(part1[0]);
                long[] intParts = Arrays.stream(part2).mapToLong(Long::parseLong).toArray();
                if (backtrack(total, intParts,  intParts[0], 1)) {
                    result = result + total;
                }
            }
        }

        return result;
    }

    private boolean backtrack(long target, long[] set, long currentTotal, int index) {
        if (index >= set.length) {
            return currentTotal == target;
        }

        // addition
        if (backtrack(target, set, currentTotal + set[index], index + 1)) {
            return true;
        }

        return backtrack(target, set, currentTotal * set[index], index + 1);
    }

    public long Part2(String file) throws IOException {
        long result = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            while (br.ready()) {
                var line = br.readLine();
                var part1 = line.split(": ");
                var part2 = part1[1].split(" ");
                long total = Long.parseLong(part1[0]);
                long[] intParts = Arrays.stream(part2).mapToLong(Long::parseLong).toArray();
                if (backtrack2(total, intParts,  intParts[0], 1)) {
                    result = result + total;
                }
            }
        }

        return result;
    }

    private boolean backtrack2(long target, long[] set, long currentTotal, int index) {
        if (index >= set.length) {
            return currentTotal == target;
        }

        // addition
        if (backtrack2(target, set, currentTotal + set[index], index + 1)) {
            return true;
        }

        // multiplication
        if (backtrack2(target, set, currentTotal * set[index], index + 1)) {
            return true;
        }

        return backtrack2(target, set, Long.parseLong(String.valueOf(currentTotal) + set[index]), index + 1);
    }
}
