package com.AdventOfCode2025;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Day1 {
    public int Part1(String file) throws IOException {
        var result = 0;
        var location = 50;
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            while (br.ready()) {
                var line = br.readLine();
                if (line.charAt(0) == 'L') {
                    var decrease = line.substring(1);
                    int intNumber = Integer.parseInt(decrease);
                    location = location - intNumber;
                    while(location < 0) {
                        location = location + 100;
                    }
                    if (location == 0) {
                        result++;
                    }
                }
                if (line.charAt(0) == 'R') {
                    var increase = line.substring(1);
                    int intNumber = Integer.parseInt(increase);
                    location = location + intNumber;
                    while(location > 99) {
                        location = location - 100;
                    }
                    if (location == 0) {
                        result++;
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
                System.out.println("Command: " + line + "| Location: " + location + "| Result: " + result);
            }

        }

        return result;
    }
}
