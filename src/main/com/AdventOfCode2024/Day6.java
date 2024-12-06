package com.AdventOfCode2024;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public class Day6 {
    private static class Coordinates {
        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
        final int x;
        final int y;
        public int getX() { return this.x; }
        public int getY() { return this.y; }
    }
    public int Part1(String file) throws IOException {
        var maxX = 0;
        var maxY = 0;
        var blocks = new ArrayList<Coordinates>();
        Coordinates guard = new Coordinates(0, 0);
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            var y = 0;
            while (br.ready()) {
                var line = br.readLine();
                maxX = line.length();

                for (var x = 0; x < line.length(); x++) {
                    if (line.charAt(x) == '#') {
                        blocks.add(new Coordinates(x, y));
                    }
                    if (line.charAt(x) == '^') {
                        guard = new Coordinates(x, y);
                    }
                }
                maxY = y;
                y++;
            }
        }

        var onMap = true;
        var direction = 'N';
        HashSet<String> spaces = new HashSet<>();
        while (onMap) {
            Coordinates finalGuard = guard;
            switch(direction) {
                case 'N':
                    var foundBlock = blocks.stream()
                        .filter(p -> p.getX() == finalGuard.getX() && p.getY() < finalGuard.getY())
                        .max(Comparator.comparingInt(p -> p.y))
                        .orElse(null);
                    if (foundBlock == null) {
                        for (var y = guard.getY(); y >= 0; y--) {
                            spaces.add(guard.getX() + "-" + y);
                        }
                        onMap = false;
                    } else {
                        for (var y = guard.getY(); y > foundBlock.getY(); y--) {
                            spaces.add(guard.getX() + "-" + y);
                        }
                        guard = new Coordinates(guard.getX(), foundBlock.getY() + 1);
                    }

                    direction = 'E';
                    break;
                case 'E':
                    var foundBlock2 = blocks.stream()
                        .filter(p -> p.getX() > finalGuard.getX() && p.getY() == finalGuard.getY())
                        .min(Comparator.comparingInt(p -> p.x))
                        .orElse(null);
                    if (foundBlock2 == null) {
                        for (var x = guard.getX(); x < maxX; x++) {
                            spaces.add(x + "-" + guard.getY());
                        }
                        onMap = false;
                    } else {
                        for (var x = guard.getX(); x < foundBlock2.getX(); x++) {
                            spaces.add(x + "-" + guard.getY());
                        }
                        guard = new Coordinates(foundBlock2.getX() - 1, guard.getY());
                    }

                    direction = 'S';
                    break;
                case 'S':
                    var foundBlock3 = blocks.stream()
                        .filter(p -> p.getX() == finalGuard.getX() && p.getY() > finalGuard.getY())
                        .min(Comparator.comparingInt(p -> p.y))
                        .orElse(null);
                    if (foundBlock3 == null) {
                        for (var y = guard.getY(); y <= maxY; y++) {
                            spaces.add(guard.getX() + "-" + y);
                        }
                        onMap = false;
                    } else {
                        for (var y = guard.getY(); y < foundBlock3.getY(); y++) {
                            spaces.add(guard.getX() + "-" + y);
                        }
                        guard = new Coordinates(guard.getX(), foundBlock3.getY() - 1);
                    }

                    direction = 'W';
                    break;
                default:
                    var foundBlock4 = blocks.stream()
                        .filter(p -> p.getX() < finalGuard.getX() && p.getY() == finalGuard.getY())
                        .max(Comparator.comparingInt(p -> p.x))
                        .orElse(null);
                    if (foundBlock4 == null) {
                        for (var x = guard.getX(); x >= 0; x--) {
                            spaces.add(x + "-" + guard.getY());
                        }
                        onMap = false;
                    } else {
                        for (var x = guard.getX(); x > foundBlock4.getX(); x--) {
                            spaces.add(x + "-" + guard.getY());
                        }
                        guard = new Coordinates(foundBlock4.getX() + 1, guard.getY());
                    }
                    direction = 'N';
                    break;
            }
        }

        return spaces.size();
    }

    public int Part2(String file) throws IOException {
        var result = 0;
        var maxX = 0;
        var maxY = 0;
        var blocks = new ArrayList<Coordinates>();
        Coordinates guard = new Coordinates(0, 0);
        Coordinates guard2 = new Coordinates(0, 0);
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            var y = 0;
            while (br.ready()) {
                var line = br.readLine();
                maxX = line.length();

                for (var x = 0; x < line.length(); x++) {
                    if (line.charAt(x) == '#') {
                        blocks.add(new Coordinates(x, y));
                    }
                    if (line.charAt(x) == '^') {
                        guard = new Coordinates(x, y);
                        guard2 = new Coordinates(x, y);
                    }
                }
                maxY = y;
                y++;
            }
        }

        var onMap = true;
        var direction = 'N';
        HashSet<String> spaces = new HashSet<>();
        while (onMap) {
            Coordinates finalGuard = guard;
            switch(direction) {
                case 'N':
                    var foundBlock = blocks.stream()
                        .filter(p -> p.getX() == finalGuard.getX() && p.getY() < finalGuard.getY())
                        .max(Comparator.comparingInt(p -> p.y))
                        .orElse(null);
                    if (foundBlock == null) {
                        for (var y = guard.getY(); y >= 0; y--) {
                            spaces.add(guard.getX() + "-" + y);
                        }
                        onMap = false;
                    } else {
                        for (var y = guard.getY(); y > foundBlock.getY(); y--) {
                            spaces.add(guard.getX() + "-" + y);
                        }
                        guard = new Coordinates(guard.getX(), foundBlock.getY() + 1);
                    }

                    direction = 'E';
                    break;
                case 'E':
                    var foundBlock2 = blocks.stream()
                        .filter(p -> p.getX() > finalGuard.getX() && p.getY() == finalGuard.getY())
                        .min(Comparator.comparingInt(p -> p.x))
                        .orElse(null);
                    if (foundBlock2 == null) {
                        for (var x = guard.getX(); x < maxX; x++) {
                            spaces.add(x + "-" + guard.getY());
                        }
                        onMap = false;
                    } else {
                        for (var x = guard.getX(); x < foundBlock2.getX(); x++) {
                            spaces.add(x + "-" + guard.getY());
                        }
                        guard = new Coordinates(foundBlock2.getX() - 1, guard.getY());
                    }

                    direction = 'S';
                    break;
                case 'S':
                    var foundBlock3 = blocks.stream()
                        .filter(p -> p.getX() == finalGuard.getX() && p.getY() > finalGuard.getY())
                        .min(Comparator.comparingInt(p -> p.y))
                        .orElse(null);
                    if (foundBlock3 == null) {
                        for (var y = guard.getY(); y <= maxY; y++) {
                            spaces.add(guard.getX() + "-" + y);
                        }
                        onMap = false;
                    } else {
                        for (var y = guard.getY(); y < foundBlock3.getY(); y++) {
                            spaces.add(guard.getX() + "-" + y);
                        }
                        guard = new Coordinates(guard.getX(), foundBlock3.getY() - 1);
                    }

                    direction = 'W';
                    break;
                default:
                    var foundBlock4 = blocks.stream()
                        .filter(p -> p.getX() < finalGuard.getX() && p.getY() == finalGuard.getY())
                        .max(Comparator.comparingInt(p -> p.x))
                        .orElse(null);
                    if (foundBlock4 == null) {
                        for (var x = guard.getX(); x >= 0; x--) {
                            spaces.add(x + "-" + guard.getY());
                        }
                        onMap = false;
                    } else {
                        for (var x = guard.getX(); x > foundBlock4.getX(); x--) {
                            spaces.add(x + "-" + guard.getY());
                        }
                        guard = new Coordinates(foundBlock4.getX() + 1, guard.getY());
                    }
                    direction = 'N';
                    break;
            }
        }

        for(String c : spaces) {
            var parts = c.split("-");
            var newBlocks = new ArrayList<>(blocks);
            newBlocks.add(new Coordinates(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])));
            if (traverseMap(guard2, newBlocks, maxX, maxY)) {
                result++;
            }
        }

        return result;
    }

    public boolean traverseMap(Coordinates guard, ArrayList<Coordinates> blocks, int maxX, int maxY) {
        var direction = 'N';
        var hitBlocks = new HashMap<String, Integer>();
        while (true) {
            Coordinates finalGuard = guard;
            switch(direction) {
                case 'N':
                    var foundBlock = blocks.stream()
                        .filter(p -> p.getX() == finalGuard.getX() && p.getY() < finalGuard.getY())
                        .max(Comparator.comparingInt(p -> p.y))
                        .orElse(null);
                    if (foundBlock == null) {
                        return false;
                    } else {
                        hitBlocks.put(foundBlock.getX() + "-" + foundBlock.getY(), hitBlocks.getOrDefault(foundBlock.getX() + "-" + foundBlock.getY(), 0) + 1);
                        if (hitBlocks.get(foundBlock.getX() + "-" + foundBlock.getY()) > 3) { return true; }
                        guard = new Coordinates(guard.getX(), foundBlock.getY() + 1);
                    }

                    direction = 'E';
                    break;
                case 'E':
                    var foundBlock2 = blocks.stream()
                        .filter(p -> p.getX() > finalGuard.getX() && p.getY() == finalGuard.getY())
                        .min(Comparator.comparingInt(p -> p.x))
                        .orElse(null);
                    if (foundBlock2 == null) {
                        return false;
                    } else {
                        hitBlocks.put(foundBlock2.getX() + "-" + foundBlock2.getY(), hitBlocks.getOrDefault(foundBlock2.getX() + "-" + foundBlock2.getY(), 0) + 1);
                        if (hitBlocks.get(foundBlock2.getX() + "-" + foundBlock2.getY()) > 3) { return true; }
                        guard = new Coordinates(foundBlock2.getX() - 1, guard.getY());
                    }

                    direction = 'S';
                    break;
                case 'S':
                    var foundBlock3 = blocks.stream()
                        .filter(p -> p.getX() == finalGuard.getX() && p.getY() > finalGuard.getY())
                        .min(Comparator.comparingInt(p -> p.y))
                        .orElse(null);
                    if (foundBlock3 == null) {
                        return false;
                    } else {
                        hitBlocks.put(foundBlock3.getX() + "-" + foundBlock3.getY(), hitBlocks.getOrDefault(foundBlock3.getX() + "-" + foundBlock3.getY(), 0) + 1);
                        if (hitBlocks.get(foundBlock3.getX() + "-" + foundBlock3.getY()) > 3) { return true; }
                        guard = new Coordinates(guard.getX(), foundBlock3.getY() - 1);
                    }

                    direction = 'W';
                    break;
                default:
                    var foundBlock4 = blocks.stream()
                        .filter(p -> p.getX() < finalGuard.getX() && p.getY() == finalGuard.getY())
                        .max(Comparator.comparingInt(p -> p.x))
                        .orElse(null);
                    if (foundBlock4 == null) {
                        return false;
                    } else {
                        hitBlocks.put(foundBlock4.getX() + "-" + foundBlock4.getY(), hitBlocks.getOrDefault(foundBlock4.getX() + "-" + foundBlock4.getY(), 0) + 1);
                        if (hitBlocks.get(foundBlock4.getX() + "-" + foundBlock4.getY()) > 3) { return true; }
                        guard = new Coordinates(foundBlock4.getX() + 1, guard.getY());

                    }
                    direction = 'N';
                    break;
            }
        }
    }
}
