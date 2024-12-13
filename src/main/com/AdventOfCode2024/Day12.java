package com.AdventOfCode2024;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Day12 {
    private class Node {
        public UUID id;
        private final int x;
        private final int y;
        public int getX() { return this.x; }
        public int getY() { return this.y; }
        public UUID getId() { return this.id; }
        public void setId(UUID id) { this.id = id; }
        public String getKey() {
            return this.x + "-" + this.y;
        }
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public long part1(String file) throws IOException {
        var map = new HashMap<Character, List<Node>>();
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            var y = 0;
            while (br.ready()) {
                var line = br.readLine();
                for (var x = 0; x < line.length(); x++) {
                    var c = line.charAt(x);
                    if (!map.containsKey(line.charAt(x))) {
                        map.put(c, new ArrayList<>());
                    }
                    map.get(c).add(new Node(x, y));
                }
                y++;
            }
        }
        for(Character fenceValue: map.keySet()) {
            var fenceNodes = map.get(fenceValue);
            for (Node n : fenceNodes) {
                if (n.getId() == null) {
                    var idToUse = findId(n, fenceNodes, new HashSet<>());
                    n.setId(idToUse.orElseGet(UUID::randomUUID));
                }
            }
        }

        var fences = 0L;
        for(Character fenceValue: map.keySet()) {
            var sideMap = new HashMap<UUID, Integer>();
            var fenceNodes = map.get(fenceValue);
            for(Node n : fenceNodes) {
                // up
                if (fenceNodes.stream().noneMatch(f -> f.getX() == n.getX() && f.getY() == n.getY() + 1)) {
                    sideMap.put(n.getId(), sideMap.getOrDefault(n.getId(), 0) + 1);
                }
                // down
                if (fenceNodes.stream().noneMatch(f -> f.getX() == n.getX() && f.getY() == n.getY() - 1)) {
                    sideMap.put(n.getId(), sideMap.getOrDefault(n.getId(), 0) + 1);
                }
                // right
                if (fenceNodes.stream().noneMatch(f -> f.getX() == n.getX() + 1 && f.getY() == n.getY())) {
                    sideMap.put(n.getId(), sideMap.getOrDefault(n.getId(), 0) + 1);
                }
                // left
                if (fenceNodes.stream().noneMatch(f -> f.getX() == n.getX() - 1 && f.getY() == n.getY())) {
                    sideMap.put(n.getId(), sideMap.getOrDefault(n.getId(), 0) + 1);
                }
            }
            for (UUID key : sideMap.keySet()) {
                fences += sideMap.get(key) * map.get(fenceValue).stream().filter(f -> f.getId() == key).count();
            }
        }

        return fences;
    }

    private Optional<UUID> findId(Node current, List<Node> availableNodes, HashSet<String> visitedNodes) {
        visitedNodes.add(current.getKey());
        // up
        var up = availableNodes.stream().filter(f -> !visitedNodes.contains(f.getKey()) && f.getX() == current.getX() && f.getY() == current.getY() + 1).findFirst();
        if (up.isPresent()) {
            if (up.get().getId() != null) {
                return Optional.of(up.get().getId());
            }
            var result = findId(up.get(), availableNodes, visitedNodes);
            if (result.isPresent()) { return result; }
        }
        // down
        var down = availableNodes.stream().filter(f -> !visitedNodes.contains(f.getKey()) && f.getX() == current.getX() && f.getY() == current.getY() - 1).findFirst();
        if (down.isPresent()) {
            if (down.get().getId() != null) {
                return Optional.of(down.get().getId());
            }
            var result = findId(down.get(), availableNodes, visitedNodes);
            if (result.isPresent()) { return result; }
        }
        // right
        var right = availableNodes.stream().filter(f -> !visitedNodes.contains(f.getKey()) && f.getX() == current.getX() + 1 && f.getY() == current.getY()).findFirst();
        if (right.isPresent()) {
            if (right.get().getId() != null) {
                return Optional.of(right.get().getId());
            }
            var result = findId(right.get(), availableNodes, visitedNodes);
            if (result.isPresent()) { return result; }
        }
        // left
        var left = availableNodes.stream().filter(f -> !visitedNodes.contains(f.getKey()) && f.getX() == current.getX() - 1 && f.getY() == current.getY()).findFirst();
        if (left.isPresent()) {
            if (left.get().getId() != null) {
                return Optional.of(left.get().getId());
            }
            var result = findId(left.get(), availableNodes, visitedNodes);
            if (result.isPresent()) { return result; }
        }
        return Optional.empty();
    }

    public long part2(String file) throws IOException {
        var map = new HashMap<Character, List<Node>>();
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            var y = 0;
            while (br.ready()) {
                var line = br.readLine();
                for (var x = 0; x < line.length(); x++) {
                    var c = line.charAt(x);
                    if (!map.containsKey(line.charAt(x))) {
                        map.put(c, new ArrayList<>());
                    }
                    map.get(c).add(new Node(x, y));
                }
                y++;
            }
        }
        for(Character fenceValue: map.keySet()) {
            var fenceNodes = map.get(fenceValue);
            for (Node n : fenceNodes) {
                if (n.getId() == null) {
                    var idToUse = findId(n, fenceNodes, new HashSet<>());
                    n.setId(idToUse.orElseGet(UUID::randomUUID));
                }
            }
        }

        var corners = 0;
//        for(Character fenceValue: map.keySet()) {
//            var fenceNodes = map.get(fenceValue);
//            var xFence = new HashSet<String>();
//            var yFence = new HashSet<String>();
//            for(Node n : fenceNodes) {
//                // up
//                if (fenceNodes.stream().noneMatch(f -> f.getX() == n.getX() && f.getY() == n.getY() - 1)) {
//                    yFence.add(n.getId() + "|" + n.getY());
//                }
//                // down
//                if (fenceNodes.stream().noneMatch(f -> f.getX() == n.getX() && f.getY() == n.getY() + 1)) {
//                    yFence.add(n.getId() + "|" + (n.getY() + 1));
//                }
//                // right
//                if (fenceNodes.stream().noneMatch(f -> f.getX() == n.getX() + 1 && f.getY() == n.getY())) {
//                    xFence.add(n.getId() + "|" + n.getX() + 1);
//                }
//                // left
//                if (fenceNodes.stream().noneMatch(f -> f.getX() == n.getX() - 1 && f.getY() == n.getY())) {
//                    xFence.add(n.getId() + "|" + (n.getX()));
//                }
//            }
//            var ids = new HashSet<String>();
//            var t = xFence.stream().map(f -> f.split("\\|")[0]).collect(Collectors.toCollection(HashSet::new));
//            var u = yFence.stream().map(f -> f.split("\\|")[0]).collect(Collectors.toCollection(HashSet::new));
//            ids.addAll(t);
//            ids.addAll(u);
//            for(String id: ids) {
//                var sides = yFence.stream().filter(f -> f.startsWith(id)).count() + xFence.stream().filter(f -> f.startsWith(id)).count();
//                var area = map.get(fenceValue).stream().filter(f -> f.getId().equals(UUID.fromString(id))).count();
//                fences += sides * area;
//            }
//        }
        var result = 0;
        for(Character fenceValue: map.keySet()) {
            var cornerMap = new HashMap<UUID, Integer>();
            var fenceNodes = map.get(fenceValue);
            for(Node n : fenceNodes) {
                // up
                if (fenceNodes.stream().noneMatch(f -> f.getX() == n.getX() && f.getY() == n.getY() - 1)) {
                    // right
                    if (fenceNodes.stream().noneMatch(f -> f.getX() == n.getX() + 1 && f.getY() == n.getY())) {
                        cornerMap.put(n.getId(), cornerMap.getOrDefault(n.getId(), 0) + 1);
                    }
                    // left
                    if (fenceNodes.stream().noneMatch(f -> f.getX() == n.getX() - 1 && f.getY() == n.getY())) {
                        cornerMap.put(n.getId(), cornerMap.getOrDefault(n.getId(), 0) + 1);
                    }
                }
                // down
                if (fenceNodes.stream().noneMatch(f -> f.getX() == n.getX() && f.getY() == n.getY() + 1)) {
                    // right
                    if (fenceNodes.stream().noneMatch(f -> f.getX() == n.getX() + 1 && f.getY() == n.getY())) {
                        cornerMap.put(n.getId(), cornerMap.getOrDefault(n.getId(), 0) + 1);
                    }
                    // left
                    if (fenceNodes.stream().noneMatch(f -> f.getX() == n.getX() - 1 && f.getY() == n.getY())) {
                        cornerMap.put(n.getId(), cornerMap.getOrDefault(n.getId(), 0) + 1);
                    }
                }
                // right
                if (fenceNodes.stream().noneMatch(f -> f.getX() == n.getX() + 1 && f.getY() == n.getY())) {
                    if (fenceNodes.stream().anyMatch(f -> f.getX() == n.getX() && f.getY() == n.getY() + 1) &&
                        fenceNodes.stream().anyMatch(f -> f.getX() == n.getX() + 1 && f.getY() == n.getY() + 1)) {
                        cornerMap.put(n.getId(), cornerMap.getOrDefault(n.getId(), 0) + 1);
                    }
                    if (fenceNodes.stream().anyMatch(f -> f.getX() == n.getX() && f.getY() == n.getY() - 1) &&
                        fenceNodes.stream().anyMatch(f -> f.getX() == n.getX() + 1 && f.getY() == n.getY() - 1)) {
                        cornerMap.put(n.getId(), cornerMap.getOrDefault(n.getId(), 0) + 1);
                    }
                }
                // left
                if (fenceNodes.stream().noneMatch(f -> f.getX() == n.getX() - 1 && f.getY() == n.getY())) {
                    if (fenceNodes.stream().anyMatch(f -> f.getX() == n.getX() && f.getY() == n.getY() + 1) &&
                        fenceNodes.stream().anyMatch(f -> f.getX() == n.getX() - 1 && f.getY() == n.getY() + 1)) {
                        cornerMap.put(n.getId(), cornerMap.getOrDefault(n.getId(), 0) + 1);
                    }
                    if (fenceNodes.stream().anyMatch(f -> f.getX() == n.getX() && f.getY() == n.getY() - 1) &&
                        fenceNodes.stream().anyMatch(f -> f.getX() == n.getX() - 1 && f.getY() == n.getY() - 1)) {
                        cornerMap.put(n.getId(), cornerMap.getOrDefault(n.getId(), 0) + 1);
                    }
                }
            }
            for(UUID id: cornerMap.keySet()) {
                var area = map.get(fenceValue).stream().filter(f -> f.getId().equals(id)).count();
                result += cornerMap.get(id) * area;
            }
        }

        return result;
    }
}
