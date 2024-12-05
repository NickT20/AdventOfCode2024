package com.AdventOfCode2024;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Day5 {
    class Coordinaties {
        public Coordinaties(int x, int y) {
            this.x = x;
            this.y = y;
        }
        final int x;
        final int y;
        public int getX() { return this.x; }
        public int getY() { return this.y; }
    }
    public int Part1(String file) throws IOException {
        var result = 0;
        var rules = new ArrayList<Coordinaties>();
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            var isInstructions = true;
            while (br.ready()) {
                var line = br.readLine();
                if (line.length() <= 1) {
                    isInstructions = false;
                    continue;
                }

                if (isInstructions) {
                    var parts = line.split("\\|");
                    rules.add(new Coordinaties(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])));
                } else {
                    var parts = line.split(",");
                    var invalid = false;
                    for (var x = 0; x < parts.length && !invalid; x++) {
                        for (var y = x + 1; y < parts.length && !invalid; y++) {
                            final int testX = Integer.parseInt(parts[x]);
                            final int testY = Integer.parseInt(parts[y]);

                            if(!rules.stream().anyMatch(pred -> pred.getX() == testX && pred.getY() == testY))
                            {
                                invalid = true;
                            }
                        }
                    }

                    if (!invalid) {
                        result += Integer.parseInt(parts[(parts.length / 2)]);
                    }
                }
            }
        }

        return result;
    }
    public int Part2(String file) throws IOException {
        var result = 0;
        var rules = new ArrayList<Coordinaties>();
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            var isInstructions = true;
            while (br.ready()) {
                var line = br.readLine();
                if (line.length() <= 1) {
                    isInstructions = false;
                    continue;
                }

                if (isInstructions) {
                    var parts = line.split("\\|");
                    rules.add(new Coordinaties(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])));
                } else {
                    var parts = line.split(",");
                    var invalid = false;
                    for (var x = 0; x < parts.length; x++) {
                        for (var y = x + 1; y < parts.length; y++) {
                            final int testX = Integer.parseInt(parts[x]);
                            final int testY = Integer.parseInt(parts[y]);

                            if(!rules.stream().anyMatch(pred -> pred.getX() == testX && pred.getY() == testY))
                            {
                                parts[x] = String.valueOf(testY);
                                parts[y] = String.valueOf(testX);
                                x = -1;
                                y = 100;
                                invalid = true;
                            }
                        }
                    }

                    if (invalid) {
                        result += Integer.parseInt(parts[(parts.length / 2)]);
                    }
                }
            }
        }

        return result;
    }
}
