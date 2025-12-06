package com.AdventOfCode2025;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.util.comparator.ComparableComparator;

import com.AdventOfCode2025.Models.Range;

public class Day5 {
    public long Part1(String file) throws IOException {
        long result = 0;
        var nodes = new ArrayList<Range>();
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            var process = false;
            while (br.ready()) {
                var line = br.readLine();
                if (line.trim().isEmpty()) {
                    process = true;
                    continue;
                }
                if (!process) {
                    var parts = line.split("-");
                    nodes.add(new Range(Long.parseLong(parts[0]), Long.parseLong(parts[1])));
                } else {
                    var ingredient = Long.parseLong(line);
                    if (nodes.stream().anyMatch(n -> ingredient <= n.getMax() && ingredient >= n.getMin())) {
                        result++;
                    }
                }
            }
        }

        return result;
    }

    public long Part2(String file) throws IOException {
        long result = 0;
        var nodes = new ArrayList<Range>();
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            var process = false;
            while (br.ready()) {
                var line = br.readLine();
                if (line.trim().isEmpty()) {
                    process = true;
                    continue;
                }
                if (!process) {
                    var parts = line.split("-");
                    var min = Long.parseLong(parts[0]);
                    var max = Long.parseLong(parts[1]);

                    var links = nodes.stream().filter(n -> n.getMax() == min || n.getMin() == max).toList();
                    if (links.size() == 2) {
                        nodes.removeAll(links);
                        var min1 = links.stream().filter(l -> l.getMax() == min).findFirst();
                        var max1 = links.stream().filter(l -> l.getMin() == max).findFirst();
                        nodes.add(new Range(min1.get().getMin(), max1.get().getMax()));
                    }

                    var equalMin = nodes.stream().filter(n -> n.getMin() == max).findFirst();
                    if (equalMin.isPresent()) {
                        equalMin.get().setMin(min);
                    }
                    var equalMax = nodes.stream().filter(n -> n.getMax() == min).findFirst();
                    if (equalMax.isPresent()) {
                        equalMax.get().setMax(max);
                    }

                    var encompassedNodes = nodes.stream().filter(n -> n.getMin() >= min && n.getMax() <= max).toList();
                    nodes.removeAll(encompassedNodes);

                    var existingMin = nodes.stream().filter(n -> n.getMin() <= min && n.getMax() >= min).findFirst();
                    var existingMax = nodes.stream().filter(n -> n.getMin() <= max && n.getMax() >= max).findFirst();
                    if (existingMin.isPresent() && existingMax.isPresent()) {
                        nodes.remove(existingMin.get());
                        nodes.remove(existingMax.get());
                        var newRange = new Range(existingMin.get().getMin(), existingMax.get().getMax());
                        RemoveNodes(newRange, nodes);
                        nodes.add(new Range(existingMin.get().getMin(), existingMax.get().getMax()));
                    } else if (existingMin.isPresent() && max > existingMin.get().getMax()) {
                        existingMin.get().setMax(max);
                        RemoveNodes(existingMin.get(), nodes);
                    } else if (existingMax.isPresent() && min < existingMax.get().getMin()) {
                        existingMax.get().setMin(min);
                        RemoveNodes(existingMax.get(), nodes);
                    } else {
                        var newRange2 = new Range(Long.parseLong(parts[0]), Long.parseLong(parts[1]));
                        nodes.add(newRange2);
                        RemoveNodes(newRange2, nodes);
                    }
                }
            }
        }


        for (var node: nodes) {
            result += node.getMax() - node.getMin();
            System.out.println(node.getMin() + "-" + node.getMax());
            // inclusive
            result++;
        }

        return result;
    }

    private void RemoveNodes(Range node, List<Range> nodes) {
        var nodesToEliminate = nodes.stream().filter(n -> 
        node.getMin() <= n.getMin() && 
        node.getMax() >= n.getMax() &&
        (n.getMax() != node.getMax() && n.getMin() != node.getMin())).toList();
        nodes.removeAll(nodesToEliminate);
    }

public long Part3(String file) throws IOException {
        ArrayList<Long> starts = new ArrayList<>();
        ArrayList<Long> ends = new ArrayList<>();
        ArrayList<Long> ingredients = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            while (br.ready()) {
                String lineIn = br.readLine();
                if (lineIn.indexOf("-") > -1) {
                    starts.add(Long.parseLong(lineIn.substring(0, lineIn.indexOf("-"))));
                    ends.add(Long.parseLong(lineIn.substring(lineIn.indexOf("-") + 1)));
                } else if (lineIn.length() > 0) {
                    ingredients.add(Long.parseLong(lineIn));
                }
            }
        }
        long part2 = 0;
        for (int i = starts.size()-2; i >= 0; i--) {
            for (int k = i+1; k < starts.size(); k++) {
                if (starts.get(i) <= starts.get(k) && ends.get(i) >= ends.get(k)) {
                    starts.remove(k);
                    ends.remove(k);
                    k--;
                }
                else if (starts.get(i) >= starts.get(k) && ends.get(i) <= ends.get(k)) {
                    starts.add(i,starts.get(k));
                    starts.remove(i+1);
                    ends.add(i,ends.get(k));
                    ends.remove(i+1);
                    starts.remove(k);
                    ends.remove(k);
                    k--;
                }
                else if (starts.get(i) >= starts.get(k) && starts.get(i) <= ends.get(k) && ends.get(i) >= ends.get(k)) {
                    starts.add(i,starts.get(k));
                    starts.remove(i+1);
                    starts.remove(k);
                    ends.remove(k);
                    k--;
                }
                else if (starts.get(i) <= starts.get(k) && starts.get(k) <= ends.get(i) && ends.get(i) <= ends.get(k)) {
                    starts.remove(k);
                    ends.add(i,ends.get(k));
                    ends.remove(i+1);
                    ends.remove(k);
                    k--;
                }
            }
        }

        // for (int i = 0; i < starts.size(); i++) {
        //     part2 += ends.get(i)-starts.get(i)+1;
        //     System.out.println(starts.get(i) + "-" + ends.get(i));
        // }

        for (int i = 0; i < starts.size(); i++) {
            part2 += ends.get(i)-starts.get(i)+1;
        }
        System.out.println(part2);
        return part2;
    }
}
