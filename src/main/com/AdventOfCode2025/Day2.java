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
    public int Part2(String file) throws IOException {
        var result = 0;
        var location = 50;
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            while (br.ready()) {
                var line = br.readLine();
                int intNumber = Integer.parseInt(line.substring(1));
                if (line.charAt(0) == 'L') {
                    // If we start at zero and don't end on zero then take away one which will be made up later
                    if (location == 0 && intNumber % 100 != 0) { result--; }

                    location = location - intNumber;

                    while(location < 0) {
                        location = location + 100;
                        result++;
                    }

                    if (location == 0) {
                        result++;
                    }
                }
                if (line.charAt(0) == 'R') {
                    location = location + intNumber;
                    while(location > 99) {
                        location = location - 100;
                        result++;
                    }
                }
            }

        }

        return result;
    }
}
