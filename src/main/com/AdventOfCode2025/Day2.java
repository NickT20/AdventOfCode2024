package com.AdventOfCode2025;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day2 {
    public long Part1(String file) throws IOException {
        long result = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            while (br.ready()) {
                var line = br.readLine();
                var parts = line.split("-");
                var start = Long.parseLong(parts[0]);
                var end = Long.parseLong(parts[1]);
                for(var x = start; x <= end; x++) {
                    var stringValue = String.valueOf(x);
                    var length = stringValue.length();
                    if (length % 2 == 0) {
                        var half = length / 2;
                        var part1 = stringValue.substring(0, half);
                        var part2 = stringValue.substring(half);
                        if (part1.equals(part2)) {
                            result += x;
                        }
                    }
                }
            }
        }

        return result;
    }

    private boolean isInvalid(String testString) {
        var sb = new StringBuilder(testString);
        var length = testString.length();
        var doubled = sb.append(testString);
        return doubled.indexOf(testString, 1) < length;

    }
    public long Part2(String file) throws IOException {
        long result = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            while (br.ready()) {
                var line = br.readLine();
                var parts = line.split("-");
                var start = Long.parseLong(parts[0]);
                var end = Long.parseLong(parts[1]);
                for(var x = start; x <= end; x++) {
                    var stringValue = String.valueOf(x);
                    if (isInvalid(stringValue)) {
                        result += x;
                    }
                }
            }
        }

        return result;
    }
}
