package com.AdventOfCode2024;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Day16 {
    private static class Node {
        private int x;
        private int y;
        private Character direction;
        private int score;
        private boolean isEnd;
        public int getX() { return this.x; }
        public void setX(int x) { this.x = x; }
        public int getY() { return this.y; }
        public void setY(int y) { this.y = y; }
        public int getScore() { return score; }
        public void setScore(int s) { score = s; }
        private void setIsEnd(boolean s) { isEnd = s; }
        public boolean getIsEnd() { return isEnd; }
        public Character getDirection() { return direction; }
        public void setDirection(Character c) { direction = c; }
        public String getKey() {
            return this.x + "-" + this.y;
        }
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
            this.score = 0;
        }
    }

    private final HashMap<String, Node> visited = new HashMap<>();

    public long part1(String file) throws IOException {
        Node current = null;
        var availableSpaces = new ArrayList<Node>();
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            var y = 0;
            while (br.ready()) {
                var line = br.readLine();
                for(var i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == 'S') {
                        current = new Node(i, y);
                        current.setDirection('E');
                    } else if (line.charAt(i) == '.') {
                        availableSpaces.add(new Node(i, y));
                    } else if (line.charAt(i) == 'E') {
                        var node = new Node(i, y);
                        node.setIsEnd(true);
                        availableSpaces.add(node);
                    }
                }
                y++;
            }
        }

        findScore(availableSpaces, current);
        var end = availableSpaces.stream().filter(n -> n.getIsEnd()).findFirst();

        return end.get().getScore();
    }

    public void findScore(ArrayList<Node> availableSpaces, Node current) {
        visited.put(current.getKey(), current);
        if (current.getIsEnd()) {
            var end = availableSpaces.stream().filter(x -> x.getIsEnd()).findFirst();
            end.get().setScore(current.score);
            return;
        }

        // look up
        if (current.getDirection() != 'S') {
            var up = availableSpaces.stream().filter(n -> n.getX() == current.getX() && n.getY() == current.getY() - 1).findFirst();
            if (up.isPresent()) {
                var alreadyVisited = visited.get(up.get().getKey());
                var score = getScore(current, 'N');
                if (alreadyVisited == null || alreadyVisited.score > score) {
                    // keep going
                    var newCurrent = new Node(current.getX(), current.getY() - 1);
                    newCurrent.setDirection('N');
                    newCurrent.setScore(score);
                    newCurrent.setIsEnd(up.get().getIsEnd());
                    findScore(availableSpaces, newCurrent);
                }
            }
        }

        // look down
        if (current.getDirection() != 'N') {
            var down = availableSpaces.stream().filter(n -> n.getX() == current.getX() && n.getY() == current.getY() + 1).findFirst();
            if (down.isPresent()) {
                var alreadyVisited = visited.get(down.get().getKey());
                var score = getScore(current, 'S');
                if (alreadyVisited == null || alreadyVisited.score > score) {
                    // keep going
                    var newCurrent = new Node(current.getX(), current.getY() + 1);
                    newCurrent.setDirection('S');
                    newCurrent.setScore(score);
                    newCurrent.setIsEnd(down.get().getIsEnd());
                    findScore(availableSpaces, newCurrent);
                }
            }
        }

        // look left
        if (current.getDirection() != 'E') {
            var left = availableSpaces.stream().filter(n -> n.getX() == current.getX() - 1 && n.getY() == current.getY()).findFirst();
            if (left.isPresent()) {
                var alreadyVisited = visited.get(left.get().getKey());
                var score = getScore(current, 'W');
                if (alreadyVisited == null || alreadyVisited.score > score) {
                    // keep going
                    var newCurrent = new Node(current.getX() - 1, current.getY());
                    newCurrent.setDirection('W');
                    newCurrent.setScore(score);
                    newCurrent.setIsEnd(left.get().getIsEnd());
                    findScore(availableSpaces, newCurrent);
                }
            }
        }

        // look right
        if (current.getDirection() != 'W') {
            var right = availableSpaces.stream().filter(n -> n.getX() == current.getX() + 1 && n.getY() == current.getY()).findFirst();
            if (right.isPresent()) {
                var alreadyVisited = visited.get(right.get().getKey());
                var score = getScore(current, 'E');
                if (alreadyVisited == null || alreadyVisited.score > score) {
                    // keep going
                    var newCurrent = new Node(current.getX() + 1, current.getY());
                    newCurrent.setDirection('E');
                    newCurrent.setScore(score);
                    newCurrent.setIsEnd(right.get().getIsEnd());
                    findScore(availableSpaces, newCurrent);
                }
            }
        }
    }

    public int getScore(Node current, Character direction) {
        if (!Objects.equals(current.getDirection(), direction)) {
            return current.getScore() + 1001;
        }
        return current.getScore() + 1;
    }

    public long part2(String file) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            while (br.ready()) {
                var line = br.readLine();
            }
        }

        return 0;
    }
}
