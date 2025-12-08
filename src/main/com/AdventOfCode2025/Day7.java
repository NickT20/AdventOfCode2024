package com.AdventOfCode2025;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import com.AdventOfCode2025.Models.Node;

public class Day7 {
    public long Part1(String file) throws IOException {
        long result = 0;
        var flow = new ArrayList<Node>();
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            var y = 0;
            while (br.ready()) {
                var line = br.readLine();
                var startIndex = line.indexOf('S');
                if (startIndex != -1) {
                    flow.add(new Node(startIndex, 0));
                    continue;
                }

                for(var x = 0; x < line.length(); x++) {
                    final int finalX = x;
                    final int finalY = y;
                    if (flow.stream().anyMatch(f -> f.getX() == finalX && f.getY() == finalY - 1)) {
                        if (line.charAt(x) == '.') {
                            flow.add(new Node(x, y));
                        } else {
                            result++;
                            if(x + 1 != line.length()) {
                                flow.add(new Node(x+1, y));
                            }
                            if(x - 1 >= 0) {
                                flow.add(new Node(x-1, y));
                            }
                        }
                    }
                }
                y++;
            }
        }

        return result;
    }
   

    public long Part2(String file) throws IOException {
        long result = 0;
        var flow = new ArrayList<Node>();
            var y = 0;
        var hashMe = new HashSet<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            while (br.ready()) {
                var line = br.readLine();
                var startIndex = line.indexOf('S');
                if (startIndex != -1) {
                    flow.add(new Node(startIndex, 0));
                    hashMe.add(startIndex + "-" + "0");
                    y++;
                    continue;
                }

                for(var x = 0; x < line.length(); x++) {
                    final int finalX = x;
                    final int finalY = y;
                    if (flow.stream().anyMatch(f -> f.getX() == finalX && f.getY() == finalY - 1)) {
                        if (line.charAt(x) == '.') {
                            flow.add(new Node(x, y));
                            var hashList = hashMe.stream().filter(h -> h.endsWith(finalX + "-" + (finalY - 1))).toList();
                            for (var hl : hashList) {
                                hashMe.remove(hl);
                                hashMe.add(hl + "|" + finalX + "-" + finalY);
                            }
                        } else {
                            result++;
                            if(x + 1 != line.length()) {
                                flow.add(new Node(x+1, y));
                                var hashList = hashMe.stream().filter(h -> h.endsWith(finalX + "-" + (finalY - 1))).toList();
                                for (var hl : hashList) {
                                    // hashMe.remove(hl);
                                    hashMe.add(hl + "|" + (finalX + 1) + "-" + finalY);
                                }
                            }
                            if(x - 1 >= 0) {
                                flow.add(new Node(x-1, y));
                                var hashList = hashMe.stream().filter(h -> h.endsWith(finalX + "-" + (finalY - 1))).toList();
                                for (var hl : hashList) {
                                    // hashMe.remove(hl);
                                    hashMe.add(hl + "|" + (finalX - 1) + "-" + finalY);
                                }
                            }
                        }
                    }
                }
                y++;
            }
        }

        final int resultY = y;
        var count = hashMe.stream().filter(h -> h.endsWith("-" + (resultY-1))).toList();
        return count.size();
    }
}
