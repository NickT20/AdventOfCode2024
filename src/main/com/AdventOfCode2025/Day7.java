package com.AdventOfCode2025;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

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

    public class TreeNode {
        String value;
        TreeNode parent;
        List<TreeNode> children = new ArrayList<>();

        public TreeNode(String value) {
            this.value = value;
        }
    }

    public long Part2(String file) throws IOException {
        var flow = new HashMap<String, List<String>>();
        var y = 0;
        String root = "";
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            while (br.ready()) {
                var line = br.readLine();
                var startIndex = line.indexOf('S');
                if (startIndex != -1) {
                    root = startIndex + "," + "0";
                    flow.put(root, new ArrayList<>());
                    y++;
                    continue;
                }

                for(var x = 0; x < line.length(); x++) {
                    var containsKey = flow.get(x + "," + (y - 1));
                    if (containsKey != null) {
                        if (line.charAt(x) == '.') {
                            var alreadyExists = flow.get(x + "," + y);
                            if (alreadyExists == null) {
                                flow.put(x + "," + y, new ArrayList<>());
                                flow.get(x + "," + (y - 1)).add(x + "," + y);
                            }
                            else {
                                flow.get(x + "," + (y - 1)).add(x + "," + y);
                            }
                        } else {
                            var parent = x + "," + (y - 1);
                            if(x + 1 <= line.length()) {
                                var alreadyExists = flow.get((x + 1) + "," + y);
                                if (alreadyExists == null) {
                                    flow.put((x + 1) + "," + y, new ArrayList<>());
                                    flow.get(parent).add((x + 1) + "," + y);
                                }
                                else {
                                    flow.get(parent).add((x + 1) + "," + y);
                                }
                            }
                            if(x - 1 >= 0) {
                                var alreadyExists = flow.get((x - 1) + "," + y);
                                if (alreadyExists == null) {
                                    flow.put((x - 1) + "," + y, new ArrayList<>());
                                    flow.get(parent).add((x - 1) + "," + y);
                                }
                                else {
                                    flow.get(parent).add((x - 1) + "," + y);
                                }
                            }
                        }
                    }
                }
                y++;
            }
        }


//        drawIt(flow, 15, 16);
//        List<List<String>> paths = getAllPaths(root);
//        System.out.println("Paths:");
//        for (List<String> path : paths) {
//            System.out.println(String.join(" -> ", path));
//        }
//        var a= findAllPaths(flow);
        return countPaths(root, flow);
    }

    private void drawIt(ArrayList<TreeNode> nodes, int maxX, int maxY) {
        for (var y = 0; y < maxY; y++) {
            final int finalY = y;
            for (var x = 0; x < maxX; x++) {
                final int finalX = x;
                if (nodes.stream().anyMatch(n -> n.value.equals(finalX + "," + finalY))) {
                    System.out.print("|");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println(" ");
        }
    }

    private int countPaths(String root, Map<String, List<String>> flow) {
        if (root == null) {
            return 0;
        }
        if (flow.get(root).isEmpty()) {
            return 1; // leaf
        }
        int total = 0;
        for (String child : flow.get(root)) {
            total += countPaths(child, flow); // no visited set
        }
        return total;
    }
    public static List<List<String>> findAllPaths(Map<String, List<String>> graph) {
        // compute parents to identify roots
        Map<String, Integer> parentCounts = new HashMap<>();

        for (String node : graph.keySet()) {
            parentCounts.putIfAbsent(node, 0);
            for (String child : graph.get(node)) {
                parentCounts.put(child, parentCounts.getOrDefault(child, 0) + 1);
            }
        }

        // roots = nodes with no parents
        List<String> roots = parentCounts.entrySet().stream()
                .filter(e -> e.getValue() == 0)
                .map(Map.Entry::getKey)
                .toList();

        List<List<String>> result = new ArrayList<>();

        for (String root : roots) {
            dfs(graph, root, new ArrayList<>(), result);
        }

        return result;
    }

    private static void dfs(Map<String, List<String>> graph,
                            String node,
                            List<String> path,
                            List<List<String>> result) {

        path.add(node);

        List<String> children = graph.get(node);

        if (children == null || children.isEmpty()) {
            // leaf
            result.add(new ArrayList<>(path));
        } else {
            for (String child : children) {
                dfs(graph, child, path, result);
            }
        }

        path.remove(path.size() - 1); // backtrack
    }
}
