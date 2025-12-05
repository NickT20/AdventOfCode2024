package com.AdventOfCode2025;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

import com.AdventOfCode2025.Models.Node;

public class Day4 {
    public long Part1(String file) throws IOException {
        long result = 0;
        var nodes = new ArrayList<Node>();
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            var y = 0;
            while (br.ready()) {
                var line = br.readLine();
                for(var x = 0; x < line.length(); x++) {
                    if (line.charAt(x) == '@') {
                        nodes.add(new Node(x, y));
                    }
                }
                y++;
            }
        }

        for (var node : nodes) {
            if (valid(node, nodes)) {
                result++;
            }
        }

        return result;
    }

    private boolean valid(Node node, ArrayList<? extends Node> nodes) {
        var rolls = 0;
        if(nodes.stream().anyMatch(n -> n.getX() == node.getX() - 1 && n.getY() == node.getY() - 1)) {
            rolls++;
        }
        if(nodes.stream().anyMatch(n -> n.getX() == node.getX() && n.getY() == node.getY() - 1)) {
            rolls++;
        }
        if(nodes.stream().anyMatch(n -> n.getX() == node.getX() + 1 && n.getY() == node.getY() - 1)) {
            rolls++;
        }
        if(nodes.stream().anyMatch(n -> n.getX() == node.getX() - 1 && n.getY() == node.getY() + 1)) {
            rolls++;
        }
        if(nodes.stream().anyMatch(n -> n.getX() == node.getX() && n.getY() == node.getY() + 1)) {
            rolls++;
        }
        if(nodes.stream().anyMatch(n -> n.getX() == node.getX() + 1 && n.getY() == node.getY() + 1)) {
            rolls++;
        }
        if(nodes.stream().anyMatch(n -> n.getX() == node.getX() + 1 && n.getY() == node.getY())) {
            rolls++;
        }
        if(nodes.stream().anyMatch(n -> n.getX() == node.getX() - 1 && n.getY() == node.getY())) {
            rolls++;
        }

        return rolls < 4;
    }

    public long Part2(String file) throws IOException {
        long result = 0;
        var nodes = new ArrayList<NodeWithDelete>();
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            var y = 0;
            while (br.ready()) {
                var line = br.readLine();
                for(var x = 0; x < line.length(); x++) {
                    if (line.charAt(x) == '@') {
                        nodes.add(new NodeWithDelete(x, y));
                    }
                }
                y++;
            }
        }

        var keepGoing = false;
        do {
            keepGoing = false;
            nodes = nodes.stream().filter(n -> !n.getToDelete()).collect(Collectors.toCollection(ArrayList::new));
            for (var node : nodes) {
                if (valid(node, nodes)) {
                    node.setToBeDeleted();
                    result++;
                    keepGoing = true;
                }
            }
        } while (keepGoing);

        return result;
    }

    public class NodeWithDelete extends  Node {
        private boolean toDelete;
        public void setToBeDeleted() {
            toDelete = true;
        }
        public boolean getToDelete() {
            return toDelete;
        }
        public NodeWithDelete(int x, int y) {
            super(x, y);
        }
    }
}
