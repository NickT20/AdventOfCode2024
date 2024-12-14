package com.AdventOfCode2024;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day14 {
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
    private class NodePart2 {
        private int x;
        private int y;
        private final int vX;
        private final int vY;
        public int getX() { return this.x; }
        public int getY() { return this.y; }
        public void move(int width, int height) {
            x = (vX + x) % width;
            y = (vY + y) % height;
            if (x < 0) { x = x + width; }
            if (y < 0) { y = y + height; }
            if (x == width) { x = 0; }
            if (y == height) { y = 0; }
        }
        public NodePart2(int x, int y, int vX, int vY) {
            this.x = x;
            this.y = y;
            this.vX = vX;
            this.vY = vY;
        }
    }

    public long part1(String file, int width, int height) throws IOException {
        var nodes = new ArrayList<Node>();
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            while (br.ready()) {
                var line = br.readLine();
                Pattern pattern = Pattern.compile("p=(-*\\d+),(-*\\d+)\\sv=(-*\\d+),(-*\\d+)");
                Matcher matcher = pattern.matcher(line);

                if (!matcher.find()) { continue; }
                var x = Integer.parseInt(matcher.group(1));
                var y = Integer.parseInt(matcher.group(2));
                var vX = Integer.parseInt(matcher.group(3));
                var vY = Integer.parseInt(matcher.group(4));
                x = ((vX * 100) + x) % width;
                y = ((vY * 100) + y) % height;
                if (x < 0) { x = x + width; }
                if (y < 0) { y = y + height; }
                if (x == width) { x = 0; }
                if (y == height) { y = 0; }
                nodes.add(new Node(x, y));
            }
        }
        var q1 = 0;
        var q2 = 0;
        var q3 = 0;
        var q4 = 0;
        var midWidth = width / 2;
        var midHeight = height / 2;
        for (Node n: nodes) {
            if (n.getX() < midWidth && n.getY() < midHeight) {
                q1++;
            }
            if (n.getX() > midWidth && n.getY() < midHeight) {
                q2++;
            }
            if (n.getX() > midWidth && n.getY() > midHeight) {
                q3++;
            }
            if (n.getX() < midWidth && n.getY() > midHeight) {
                q4++;
            }
        }

        return (long) q1 * q2 * q3 * q4;
    }

    public long part2(String file, int width, int height) throws IOException {
        var nodes = new ArrayList<NodePart2>();
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            while (br.ready()) {
                var line = br.readLine();
                Pattern pattern = Pattern.compile("p=(-*\\d+),(-*\\d+)\\sv=(-*\\d+),(-*\\d+)");
                Matcher matcher = pattern.matcher(line);

                if (!matcher.find()) { continue; }
                var x = Integer.parseInt(matcher.group(1));
                var y = Integer.parseInt(matcher.group(2));
                var vX = Integer.parseInt(matcher.group(3));
                var vY = Integer.parseInt(matcher.group(4));
                nodes.add(new NodePart2(x, y, vX, vY));
            }
        }
        for (var t =0; t < 1000000000; t++){
            for (NodePart2 np : nodes) {
                np.move(width, height);
            }
            if (nodes.stream().anyMatch(n -> n.getX() == 23 && n.getY() == 42) &&
                nodes.stream().anyMatch(n -> n.getX() == 24 && n.getY() == 42) &&
                nodes.stream().anyMatch(n -> n.getX() == 25 && n.getY() == 42) &&
                nodes.stream().anyMatch(n -> n.getX() == 26 && n.getY() == 42) &&
                nodes.stream().anyMatch(n -> n.getX() == 27 && n.getY() == 42)
            ) {
                System.out.println("T: " + t);
                print(width, height, nodes);
            }
//            if (nodes.stream().noneMatch(n -> isInCorner(n))
//            ) {
//            if ( t % 101 == 27 && t > 8000 && t < 95000) {
//                System.out.println("T: " + t);
//                print(width, height, nodes);
//            }
//            }
        }

        return 0;
    }
    private static boolean isNearCenter(NodePart2 coord) {
        var centerX = 50;
        var centerY = 51;
        var range = 20;
        return Math.abs(coord.getX() - centerX) <= range && Math.abs(coord.getY() - centerY) <= range;
    }
    public static boolean isInCorner(NodePart2 coord) {
        var mapSize = 100;
        var range = 10;
        // Top-left corner
        boolean inTopLeft = coord.x < range && coord.y < range;

        // Top-right corner
        boolean inTopRight = coord.x >= mapSize - range && coord.y < range;

        // Bottom-left corner
        boolean inBottomLeft = coord.x < range && coord.y >= mapSize - range;

        // Bottom-right corner
        boolean inBottomRight = coord.x >= mapSize - range && coord.y >= mapSize - range;

        // Check if in any corner
        return inTopLeft || inTopRight || inBottomLeft || inBottomRight;
    }

    void print(int width, int height, ArrayList<NodePart2> nodes) {
        for (var y = 0; y < height; y++) {
            for (var x = 0; x < width; x++){
                int finalX = x;
                int finalY = y;
                if (nodes.stream().anyMatch(n -> n.getX() == finalX && n.getY() == finalY)) {
                    System.out.print("X");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
}
