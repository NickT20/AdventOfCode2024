package com.AdventOfCode2025;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Collectors;

import com.AdventOfCode2025.Models.Node;
import com.AdventOfCode2025.Models.Range;

public class Day5 {
    public long Part1(String file) throws IOException {
        long result = 0;
        var nodes = new ArrayList<Range>();
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            var process = false;
            while (br.ready()) {
                var line = br.readLine();
                if (line.trim().isEmpty()) {
                    process = true;
                    continue;
                }
                if (!process) {
                    var parts = line.split("-");
                    nodes.add(new Range(Long.parseLong(parts[0]), Long.parseLong(parts[1])));
                } else {
                    var ingredient = Long.parseLong(line);
                    if (nodes.stream().anyMatch(n -> ingredient <= n.getMax() && ingredient >= n.getMin())) {
                        result++;
                    }
                }
            }
        }

        return result;
    }

    public long Part2(String file) throws IOException {
        long result = 0;
        var nodes = new ArrayList<Range>();
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            var process = false;
            while (br.ready()) {
                var line = br.readLine();
                if (line.trim().isEmpty()) {
                    process = true;
                    continue;
                }
                if (!process) {
                    var parts = line.split("-");
                    var min = Long.parseLong(parts[0]);
                    var max = Long.parseLong(parts[1]);
                    var equalMin = nodes.stream().filter(n -> n.getMin() == max).findFirst();
                    if (equalMin.isPresent()) {
                        equalMin.get().setMin(min);
                        continue;
                    }
                    var equalMax = nodes.stream().filter(n -> n.getMax() == min).findFirst();
                    if (equalMax.isPresent()) {
                        equalMax.get().setMax(max);
                        continue;
                    }


                    var existingMin = nodes.stream().filter(n -> n.getMin() < min && n.getMax() > min).findFirst();
                    var existingMax = nodes.stream().filter(n -> n.getMin() < max && n.getMax() > max).findFirst();
                    if (existingMin.isPresent() && existingMax.isPresent()) {
                        nodes.remove(existingMin.get());
                        nodes.remove(existingMax.get());
                        nodes.add(new Range(existingMin.get().getMin(), existingMax.get().getMax()));
                    } else if (existingMin.isPresent() && max > existingMin.get().getMax()) {
                        existingMin.get().setMax(max);
                    } else if (existingMax.isPresent() && min < existingMax.get().getMin()) {
                        existingMax.get().setMin(min);
                    } else {
                        nodes.add(new Range(Long.parseLong(parts[0]), Long.parseLong(parts[1])));
                    }
                }
            }
        }

        for (var node: nodes) {
            result += node.getMax() - node.getMin();
            // inclusive
            result++;
        }

        return result;
    }
}
