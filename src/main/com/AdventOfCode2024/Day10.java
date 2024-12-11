package com.AdventOfCode2024;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.stream.Collectors;

public class Day10 {
    private HashSet<String> day10Result = new HashSet<>();
    private int day10Result2 = 0;
    private class Node {
        private final int value;
        private final int x;
        private final int y;
        public int getValue() { return this.value; }
        public int getX() { return this.x; }
        public int getY() { return this.y; }
        public Node(int value, int x, int y) {
            this.value = value;
            this.x = x;
            this.y = y;
        }
    }
    public long part1(String file) throws IOException {
        var nodes = new ArrayList<Node>();
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            var y = 0;
            while (br.ready()) {
                var line = br.readLine();
                for(var i = 0; i < line.length(); i++) {
                    nodes.add(new Node(line.charAt(i) - '0', i, y));
                }
                y++;
            }
        }

        var zeroNodes = nodes.stream().filter(n -> n.getValue() == 0).toList();

        for (Node zeroNode : zeroNodes) {
            foundPeak(nodes, zeroNode, zeroNode.getX() + "-" + zeroNode.getY());
        }

        return day10Result.size();
    }

    private void foundPeak(ArrayList<Node> nodes, Node currentNode, String zeroNode) {
        if (currentNode.getValue() == 9) {
            day10Result.add(zeroNode + "|" + currentNode.getX() + "-" + currentNode.getY());
            day10Result2++;
            return;
        }
        var needToFind = currentNode.getValue() + 1;
        var nodesToVisit = new ArrayList<Node>();
        var up = nodes.stream().filter(n -> n.getX() == currentNode.getX() && n.getY() == currentNode.getY() - 1 && n.getValue() == needToFind).findFirst();
        up.ifPresent(nodesToVisit::add);
        var down = nodes.stream().filter(n -> n.getX() == currentNode.getX() && n.getY() == currentNode.getY() + 1 && n.getValue() == needToFind).findFirst();
        down.ifPresent(nodesToVisit::add);
        var left = nodes.stream().filter(n -> n.getX() == currentNode.getX() - 1 && n.getY() == currentNode.getY() && n.getValue() == needToFind).findFirst();
        left.ifPresent(nodesToVisit::add);
        var right = nodes.stream().filter(n -> n.getX() == currentNode.getX() + 1 && n.getY() == currentNode.getY() && n.getValue() == needToFind).findFirst();
        right.ifPresent(nodesToVisit::add);
        if (nodesToVisit.isEmpty()) { return; }
        for (Node node : nodesToVisit) {
            foundPeak(nodes, node, zeroNode);
        }
    }

    public long part2(String file) throws IOException {
        var nodes = new ArrayList<Node>();
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            var y = 0;
            while (br.ready()) {
                var line = br.readLine();
                for(var i = 0; i < line.length(); i++) {
                    nodes.add(new Node(line.charAt(i) - '0', i, y));
                }
                y++;
            }
        }

        var zeroNodes = nodes.stream().filter(n -> n.getValue() == 0).toList();

        for (Node zeroNode : zeroNodes) {
            foundPeak(nodes, zeroNode, zeroNode.getX() + "-" + zeroNode.getY());
        }

        return day10Result2;
    }
}
