package com.AdventOfCode2025;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Day8 {
    class JunctionBox {
        int x;
        int y;
        int z;

        public JunctionBox(String input) {
            var parts = input.split(",");
            x = Integer.parseInt(parts[0]);
            y = Integer.parseInt(parts[1]);
            z = Integer.parseInt(parts[2]);
        }
    }

    class Distance {
        JunctionBox boxA;
        JunctionBox boxB;
        double distance;
        public Distance(JunctionBox boxA, JunctionBox boxB, Double distance) {
            this.boxA = boxA;
            this.boxB = boxB;
            this.distance = distance;
        }
    }

    class Circuit {
        HashSet<JunctionBox> boxes;

        public Circuit() {
            boxes = new HashSet<>();
        }
    }

    public long Part1(String file) throws IOException {
        var boxes = new ArrayList<JunctionBox>();
        var distances = new ArrayList<Distance>();
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            while (br.ready()) {
                var line = br.readLine();
               boxes.add(new JunctionBox(line));
            }
        }

        for(var initial = 0; initial < boxes.size(); initial++) {
            var box = boxes.get(initial);
            for (var next = initial + 1; next < boxes.size(); next++) {
                var nextBox = boxes.get(next);
                var distance = findDistance(box, boxes.get(next));
                distances.add(new Distance(box, nextBox, distance));
            }
        }

        var shortest = distances.stream().sorted(Comparator.comparing(d -> d.distance)).toList();

        var circuits = new ArrayList<Circuit>();
        for(var iteration = 0; iteration < 1000; iteration++) {
            var connection = shortest.get(iteration);
            if (circuits.isEmpty()) {
                var newCircuit = new Circuit();
                newCircuit.boxes.add(connection.boxA);
                newCircuit.boxes.add(connection.boxB);
                circuits.add(newCircuit);
                continue;
            }

            var found = circuits.stream().filter(c -> c.boxes.contains(connection.boxA) || c.boxes.contains(connection.boxB)).toList();
            if (found.size() == 1) {
                found.get(0).boxes.add(connection.boxA);
                found.get(0).boxes.add(connection.boxB);
            } else if (found.size() == 2) {
                var boxesToMove = found.get(0).boxes;
                found.get(1).boxes.addAll(boxesToMove);
                circuits.remove(found.get(0));
            } else {
                var newCircuit = new Circuit();
                newCircuit.boxes.add(connection.boxA);
                newCircuit.boxes.add(connection.boxB);
                circuits.add(newCircuit);
            }
        }

        var top3 = circuits.stream()
                .sorted((a, b) -> Integer.compare(b.boxes.size(), a.boxes.size())) // descending by size
                .limit(3)
                .toList();

        return (long) top3.get(0).boxes.size() * top3.get(1).boxes.size() * top3.get(2).boxes.size();
    }

    private double findDistance(JunctionBox box1, JunctionBox box2) {
        var x = Math.pow((box2.x - box1.x), 2);
        var y = Math.pow((box2.y - box1.y), 2);
        var z = Math.pow((box2.z - box1.z), 2);
        return Math.sqrt(x + y + z);
    }

    public long Part2(String file) throws IOException {
        var boxes = new ArrayList<JunctionBox>();
        var distances = new ArrayList<Distance>();
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            while (br.ready()) {
                var line = br.readLine();
                boxes.add(new JunctionBox(line));
            }
        }

        for(var initial = 0; initial < boxes.size(); initial++) {
            var box = boxes.get(initial);
            for (var next = initial + 1; next < boxes.size(); next++) {
                var nextBox = boxes.get(next);
                var distance = findDistance(box, boxes.get(next));
                distances.add(new Distance(box, nextBox, distance));
            }
        }

        var shortest = distances.stream().sorted(Comparator.comparing(d -> d.distance)).toList();

        var circuits = new ArrayList<Circuit>();
        var iteration = 0;
        do {
            var connection = shortest.get(iteration);
            if (circuits.isEmpty()) {
                var newCircuit = new Circuit();
                newCircuit.boxes.add(connection.boxA);
                newCircuit.boxes.add(connection.boxB);
                circuits.add(newCircuit);
                continue;
            }

            var found = circuits.stream().filter(c -> c.boxes.contains(connection.boxA) || c.boxes.contains(connection.boxB)).toList();
            if (found.size() == 1) {
                found.get(0).boxes.add(connection.boxA);
                found.get(0).boxes.add(connection.boxB);
            } else if (found.size() == 2) {
                var boxesToMove = found.get(0).boxes;
                found.get(1).boxes.addAll(boxesToMove);
                circuits.remove(found.get(0));
            } else {
                var newCircuit = new Circuit();
                newCircuit.boxes.add(connection.boxA);
                newCircuit.boxes.add(connection.boxB);
                circuits.add(newCircuit);
            }
        } while(circuits.get(0).boxes.size() != boxes.size());


        return 0;
    }
}
