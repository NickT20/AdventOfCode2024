package com.AdventOfCode2024;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Day15 {
    private static class Node {
        private int x;
        private int y;
        private final boolean canMove;
        public int getX() { return this.x; }
        public int getY() { return this.y; }
        public String getKey() {
            return this.x + "-" + this.y;
        }
        public boolean canMove() { return this.canMove; }
        public void moveUp() {
            this.y--;
        }
        public void moveDown() {
            this.y++;
        }
        public void moveRight() {
            this.x++;
        }
        public void moveLeft() {
            this.x--;
        }
        public Node(int x, int y, boolean canMove) {
            this.x = x;
            this.y = y;
            this.canMove = canMove;
        }
    }
    public long part1(String file) throws IOException {
        var nodes = new ArrayList<Node>();
        var directions = new ArrayList<Character>();
        var y = 0;
        var width = 0;
        Node current = null;
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            var moves = false;
            while (br.ready()) {
                var line = br.readLine();
                if (line.isEmpty()) { moves = true; continue; }
                if (!moves) {
                    width = line.length();
                    for(var i = 0; i < line.length(); i++) {
                        switch (line.charAt(i)) {
                            case '#':
                                nodes.add(new Node(i, y, false));
                                break;
                            case 'O':
                                nodes.add(new Node(i, y, true));
                                break;
                            case '@':
                                current = new Node(i, y, true);
                                break;
                            default:
                                break;
                        }
                    }
                    y++;
                } else {
                    for(var i = 0; i < line.length(); i++) {
                        directions.add(line.charAt(i));
                    }
                }
            }
        }

        for(Character c : directions) {
            switch (c) {
                case '^':
                    moveUp(nodes, current);
                    break;
                case 'v':
                    moveDown(nodes, current);
                    break;
                case '<':
                    moveLeft(nodes, current);
                    break;
                case '>':
                    moveRight(nodes, current);
                    break;
                default:
                    break;
            }
        }
        return print(nodes, width, y);
    }

    public boolean moveUp(ArrayList<Node> nodes, Node current) {
        var found = nodes.stream().filter(n -> n.getX() == current.getX() && n.getY() == current.getY() - 1).findFirst();
        if (found.isPresent()) {
            if (!found.get().canMove) { return false; }
            var result = moveUp(nodes, found.get());
            if (result) {
                current.moveUp();
                return true;
            } else {
                return false;
            }
        } else {
            current.moveUp();
            return true;
        }
    }

    public boolean moveDown(ArrayList<Node> nodes, Node current) {
        var found = nodes.stream().filter(n -> n.getX() == current.getX() && n.getY() == current.getY() + 1).findFirst();
        if (found.isPresent()) {
            if (!found.get().canMove) { return false; }
            var result = moveDown(nodes, found.get());
            if (result) {
                current.moveDown();
                return true;
            } else {
                return false;
            }
        } else {
            current.moveDown();
            return true;
        }
    }

    public boolean moveLeft(ArrayList<Node> nodes, Node current) {
        var found = nodes.stream().filter(n -> n.getX() == current.getX() - 1 && n.getY() == current.getY()).findFirst();
        if (found.isPresent()) {
            if (!found.get().canMove) { return false; }
            var result = moveLeft(nodes, found.get());
            if (result) {
                current.moveLeft();
                return true;
            } else {
                return false;
            }
        } else {
            current.moveLeft();
            return true;
        }
    }

    public boolean moveRight(ArrayList<Node> nodes, Node current) {
        var found = nodes.stream().filter(n -> n.getX() == current.getX() + 1 && n.getY() == current.getY()).findFirst();
        if (found.isPresent()) {
            if (!found.get().canMove) { return false; }
            var result = moveRight(nodes, found.get());
            if (result) {
                current.moveRight();
                return true;
            } else {
                return false;
            }
        } else {
            current.moveRight();
            return true;
        }
    }

    private int print(ArrayList<Node> nodes, int maxX, int maxY) {
        var result = 0;
        for (var y = 0; y < maxY; y++) {
            for (var x = 0; x < maxX; x++) {
                int finalX = x;
                int finalY = y;
                var node = nodes.stream().filter(n -> n.getX() == finalX && n.getY() == finalY).findFirst();
                if (node.isEmpty()) {
                    System.out.print('.');
                } else if (node.get().canMove()) {
                    result += 100 * y + x;
                    System.out.print('O');
                } else {
                    System.out.print('#');
                }
            }
            System.out.println();
        }
        return result;
    }


    private static class Node2 {
        private double x;
        private double y;
        private final boolean canMove;
        public double getX() {
            return this.x;
        }
        public double getY() {
            return this.y;
        }
        public boolean canMove() { return this.canMove; }
        public void moveUp() {
            this.y -= 1;
        }
        public void moveDown() {
            this.y += 1;
        }
        public void moveRight() {
            this.x += .5;
        }
        public void moveLeft() {
            this.x -= .5;
        }
        public Node2(int x, int y, boolean canMove) {
            this.x = x;
            this.y = y;
            this.canMove = canMove;
        }
    }

    public long part2(String file) throws IOException {
        var nodes = new ArrayList<Node2>();
        var directions = new ArrayList<Character>();
        var y = 0;
        var width = 0;
        Node2 current = null;
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            var moves = false;
            while (br.ready()) {
                var line = br.readLine();
                if (line.isEmpty()) { moves = true; continue; }
                if (!moves) {
                    width = line.length();
                    for(var i = 0; i < line.length(); i++) {
                        switch (line.charAt(i)) {
                            case '#':
                                nodes.add(new Node2(i, y, false));
                                break;
                            case 'O':
                                nodes.add(new Node2(i, y, true));
                                break;
                            case '@':
                                current = new Node2(i, y, true);
                                break;
                            default:
                                break;
                        }
                    }
                    y++;
                } else {
                    for(var i = 0; i < line.length(); i++) {
                        directions.add(line.charAt(i));
                    }
                }
            }
        }

        for(Character c : directions) {
//            System.out.println(c);
            switch (c) {
                case '^':
                    if (moveUp2(nodes, current, true)) {
                        moveUp3(nodes, current, true);
                        current.moveUp();
                    }
                    break;
                case 'v':
                    if (moveDown2(nodes, current, true)) {
                        moveDown3(nodes, current, true);
                        current.moveDown();
                    }
                    break;
                case '<':
                    moveLeft2(nodes, current);
                    break;
                case '>':
                    moveRight2(nodes, current, true);
                    break;
                default:
                    break;
            }
//            print3(nodes, width, y, current);
        }
//        print2(nodes, width, y);
        return print2b(nodes, width, y);
    }

    public boolean moveUp2(List<Node2> nodes, Node2 current, boolean initial) {
        List<Node2> foundNodes = null;
        if (initial) {
            foundNodes = nodes.stream().filter(n -> (n.getX() == current.getX() || n.getX() == current.getX() - .5) && n.getY() == current.getY() - 1).toList();
        } else {
            foundNodes = nodes.stream().filter(n -> (n.getX() == current.getX() -.5 || n.getX() == current.getX() || n.getX() == current.getX() + .5) && n.getY() == current.getY() - 1).toList();
        }

        if (!foundNodes.isEmpty()) {
            var cont = true;
            for (Node2 node : foundNodes) {
                if (!node.canMove) { return false; }
                var result = moveUp2(nodes, node, false);
                if (!result) {
                    cont = false;
                }
            }
            return cont;
        } else {
            return true;
        }
    }

    public void moveUp3(List<Node2> nodes, Node2 current, boolean initial) {
        List<Node2> foundNodes = null;
        if (initial) {
            foundNodes = nodes.stream().filter(n -> (n.getX() == current.getX() || n.getX() == current.getX() - .5) && n.getY() == current.getY() - 1).toList();
        } else {
            foundNodes = nodes.stream().filter(n -> (n.getX() == current.getX() -.5 || n.getX() == current.getX() || n.getX() == current.getX() + .5) && n.getY() == current.getY() - 1).toList();
        }

        if (!foundNodes.isEmpty()) {
            for (Node2 node : foundNodes) {
                moveUp3(nodes, node, false);
                node.moveUp();
            }
        }
    }

    public boolean moveDown2(ArrayList<Node2> nodes, Node2 current, boolean initial) {
        List<Node2> foundNodes = null;
        if (initial) {
            foundNodes = nodes.stream().filter(n -> (n.getX() == current.getX() || n.getX() == current.getX() - .5) && n.getY() == current.getY() + 1).toList();
        } else {
            foundNodes = nodes.stream().filter(n -> (n.getX() == current.getX() -.5 || n.getX() == current.getX() || n.getX() == current.getX() + .5) && n.getY() == current.getY() + 1).toList();
        }

        if (!foundNodes.isEmpty()) {
            var cont = true;
            for (Node2 node : foundNodes) {
                if (!node.canMove) { return false; }
                var result = moveDown2(nodes, node, false);
                if (!result) {
                    cont = false;
                }
            }
            return cont;
        } else {
            return true;
        }
    }

    public void moveDown3(ArrayList<Node2> nodes, Node2 current, boolean initial) {
        List<Node2> foundNodes = null;
        if (initial) {
            foundNodes = nodes.stream().filter(n -> (n.getX() == current.getX() || n.getX() == current.getX() - .5) && n.getY() == current.getY() + 1).toList();
        } else {
            foundNodes = nodes.stream().filter(n -> (n.getX() == current.getX() -.5 || n.getX() == current.getX() || n.getX() == current.getX() + .5) && n.getY() == current.getY() + 1).toList();
        }

        if (!foundNodes.isEmpty()) {
            for (Node2 node : foundNodes) {
                moveDown3(nodes, node, false);
                node.moveDown();
            }
        }
    }

    public boolean moveLeft2(ArrayList<Node2> nodes, Node2 current) {
        var found = nodes.stream().filter(n -> (n.getX() == current.getX() - 1) && n.getY() == current.getY()).findFirst();
        if (found.isPresent()) {
            if (!found.get().canMove) { return false; }
            var result = moveLeft2(nodes, found.get());
            if (result) {
                current.moveLeft();
                return true;
            } else {
                return false;
            }
        } else {
            current.moveLeft();
            return true;
        }
    }

    public boolean moveRight2(ArrayList<Node2> nodes, Node2 current, boolean initial) {
        Optional<Node2> found = null;
        if (initial) {
            found = nodes.stream().filter(n -> (n.getX() == current.getX() + .5) && n.getY() == current.getY()).findFirst();
        } else {
            found = nodes.stream().filter(n -> (n.getX() == current.getX() + .5 || n.getX() == current.getX() + 1) && n.getY() == current.getY()).findFirst();
        }

        if (found.isPresent()) {
            if (!found.get().canMove) { return false; }
            var result = moveRight2(nodes, found.get(), false);
            if (result) {
                current.moveRight();
                return true;
            } else {
                return false;
            }
        } else {
            current.moveRight();
            return true;
        }
    }

    private int print2(ArrayList<Node2> nodes, int maxX, int maxY) {
        var result = 0;
        for (var y = 0; y < maxY; y++) {
            for (var x = 0.0; x < maxX; x += .5) {
                double finalX = x;
                int finalY = y;
                var node = nodes.stream().filter(n -> n.getX() == finalX && n.getY() == finalY).findFirst();
                if (node.isEmpty()) {
                    node = nodes.stream().filter(n -> n.getX() == finalX - .5 && n.getY() == finalY).findFirst();
                }
                if (node.isEmpty()) {
                    System.out.print('.');
                } else if (node.get().canMove()) {
                    result += 100 * y + x;
                    System.out.print('O');
                } else {
                    System.out.print('#');
                }
            }
            System.out.println();
        }
        return result;
    }

    private int print3(ArrayList<Node2> nodes, int maxX, int maxY, Node2 current) {
        var result = 0;
        for (var y = 0; y < maxY; y++) {
            for (var x = 0.0; x < maxX; x += .5) {
                if (current.getX() == x && current.getY() == y) {
                    System.out.print('@');
                    continue;
                }
                double finalX = x;
                int finalY = y;
                var node = nodes.stream().filter(n -> n.getX() == finalX && n.getY() == finalY).findFirst();
                if (node.isEmpty()) {
                    node = nodes.stream().filter(n -> n.getX() == finalX - .5 && n.getY() == finalY).findFirst();
                }
                if (node.isEmpty()) {
                    System.out.print('.');
                } else if (node.get().canMove()) {
                    result += 100 * y + x;
                    System.out.print('O');
                } else {
                    System.out.print('#');
                }
            }
            System.out.println();
        }
        return result;
    }

    private int print2b(ArrayList<Node2> nodes, int maxX, int maxY) {
        var result = 0;
        for (var y = 0; y < maxY; y++) {
            for (var x = 0.0; x < maxX; x += .5) {
                double finalX = x;
                int finalY = y;
                var node = nodes.stream().filter(n -> n.getX() == finalX && n.getY() == finalY).findFirst();
                if (node.isPresent() && node.get().canMove()) {
                    result += (int) (100 * y + (x * 2));
                }
            }
        }
        return result;
    }
}
