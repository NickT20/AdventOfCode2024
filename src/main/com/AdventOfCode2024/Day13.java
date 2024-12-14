package com.AdventOfCode2024;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day13 {
    private class Node {
        private final int x;
        private final int y;
        public int getX() { return this.x; }
        public int getY() { return this.y; }
        public String getKey() {
            return this.x + "-" + this.y;
        }
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private HashMap<String, Integer> score = new HashMap<>();
    private HashSet<String> visited = new HashSet<>();
    public Integer part1(String file) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            while (br.ready()) {
                visited = new HashSet<>();
                // Define a regex pattern for extracting X and Y values
                Pattern pattern = Pattern.compile("X\\+(\\d+),\\s*Y\\+(\\d+)");
                // Match against the input text

                var line1 = br.readLine();
                if (line1.isBlank()) {
                    line1 = br.readLine();

                }

                Node firstNode = null;
                Matcher matcher = pattern.matcher(line1);
                if (matcher.find()) {
                    var x = Integer.parseInt(matcher.group(1));
                    var y = Integer.parseInt(matcher.group(2));
                    firstNode = new Node(x, y);
                }

                Node secondNode = null;
                var line2 = br.readLine();
                matcher = pattern.matcher(line2);
                if (matcher.find()) {
                    var x = Integer.parseInt(matcher.group(1));
                    var y = Integer.parseInt(matcher.group(2));
                    secondNode = new Node(x, y);
                }

                Node destinationNode = null;
                // Define a regex for extracting Prize coordinates
                Pattern prizePattern = Pattern.compile("Prize:\\s*X=(\\d+),\\s*Y=(\\d+)");
                Matcher prizeMatcher = prizePattern.matcher(br.readLine());
                if (prizeMatcher.find()) {
                    var x = Integer.parseInt(prizeMatcher.group(1));
                    var y = Integer.parseInt(prizeMatcher.group(2));
                    destinationNode = new Node(x, y);
                    getScore(firstNode, secondNode, destinationNode, new Node(0, 0), new Node(0, 0));
                }

            }
        }
        var overallScore = 0;
        for (Integer s: score.values()) {
            if (s!= null) {
                overallScore += s;
            }
        }

        return overallScore;
    }

    private void getScore(Node first, Node second, Node destination, Node current, Node calculations) {
        if (visited.contains(current.getKey())) { return; }
        visited.add(current.getKey());
        if (current.getX() == destination.getX() && current.getY() == destination.getY()) {
            var tempScore = (calculations.getX() * 3) + calculations.y;
            if (score.get(destination.getKey()) == null || tempScore < score.get(destination.getKey())) {
                score.put(destination.getKey(), tempScore);
                return;
            }
        }

        if (current.getX() > destination.getX() || current.getY() > destination.getY()) {
            return;
        }

        // press a
        getScore(first, second, destination, new Node(current.getX() + first.getX(), current.getY() + first.getY()), new Node(calculations.getX() + 1, calculations.getY()));
        // press b
        getScore(first, second, destination, new Node(current.getX() + second.getX(), current.getY() + second.getY()), new Node(calculations.getX(), calculations.getY() + 1));
    }

    public long part2(String file) throws IOException {
        var overallScore = 0L;
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            while (br.ready()) {
                Pattern pattern = Pattern.compile("X\\+(\\d+),\\s*Y\\+(\\d+)");

                var line1 = br.readLine();
                if (line1.isBlank()) {
                    line1 = br.readLine();
                }

                Node firstNode = null;
                Matcher matcher = pattern.matcher(line1);
                if (matcher.find()) {
                    var x = Integer.parseInt(matcher.group(1));
                    var y = Integer.parseInt(matcher.group(2));
                    firstNode = new Node(x, y);
                }

                Node secondNode = null;
                var line2 = br.readLine();
                matcher = pattern.matcher(line2);
                if (matcher.find()) {
                    var x = Integer.parseInt(matcher.group(1));
                    var y = Integer.parseInt(matcher.group(2));
                    secondNode = new Node(x, y);
                }

                // Define a regex for extracting Prize coordinates
                Pattern prizePattern = Pattern.compile("Prize:\\s*X=(\\d+),\\s*Y=(\\d+)");
                Matcher prizeMatcher = prizePattern.matcher(br.readLine());
                if (prizeMatcher.find()) {
                    var x = Integer.parseInt(prizeMatcher.group(1)) + 10000000000000L;
                    var y = Integer.parseInt(prizeMatcher.group(2)) + 10000000000000L;
                    var cramerA = ((x * secondNode.getY()) - (y * secondNode.getX())) / ((firstNode.getX() * secondNode.getY()) - (firstNode.getY()) * secondNode.getX());
                    var cramerB = ((y * firstNode.getX()) - (x * firstNode.getY())) / ((firstNode.getX() * secondNode.getY()) - (firstNode.getY()) * secondNode.getX());

                    var f = cramerA * firstNode.getX() + cramerB * secondNode.getX();
                    var ff = cramerA * firstNode.getY() + cramerB * secondNode.getY();

                    if (f == x && y == ff) {
                        overallScore += 3 * cramerA + cramerB;
                    }
                }

            }
        }

        return overallScore;
    }
}
