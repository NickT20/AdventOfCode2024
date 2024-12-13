package com.AdventOfCode2024;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Day11 {
    public long part1(String file) throws IOException {
        var stones = new ArrayList<Long>();
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            while (br.ready()) {
                var line = br.readLine();
                var inputs = Arrays.stream(line.split("\\s+")).mapToLong(Long::parseLong).toArray();
                for (long i: inputs) {
                    stones.add(i);
                }

            }
        }

        for (var x = 0; x < 25; x++) {
            System.out.println(x + "-" + stones.size());
            for (var i = 0; i < stones.size(); i++) {
                var stone = stones.get(i);
                if (stone == 0) {
                    stones.set(i, 1L);
                    continue;
                }

                var digits = stone.toString();
                if (digits.length() % 2 == 0) {
                    var first = digits.substring(0, (digits.length() / 2));
                    var second = digits.substring((digits.length() / 2));
                    stones.set(i, Long.parseLong(first));
                    stones.add(i + 1, Long.parseLong(second));
                    i++;
                    continue;
                }

                stones.set(i, stone * 2024);
            }
        }

        return stones.size();
    }

    public long part2(String file) throws IOException {
        var hashMap = new HashMap<Long, Long>();
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            while (br.ready()) {
                var line = br.readLine();
                var inputs = Arrays.stream(line.split("\\s+")).mapToLong(Long::parseLong).toArray();
                for (long i: inputs) {
                    hashMap.put(i,hashMap.getOrDefault(i, 0L) + 1);
                }

            }
        }

        for (var x = 0; x < 75; x++) {
            var newStones = new HashMap<Long, Long>();
            for (Long key : hashMap.keySet()) {
                if (key == 0) {
                    newStones.put(1L, newStones.getOrDefault(1L, 0L) + hashMap.get(key));
                    continue;
                }

                var digits = key.toString();
                if (digits.length() % 2 == 0) {
                    var first = digits.substring(0, (digits.length() / 2));
                    var second = digits.substring((digits.length() / 2));
                    newStones.put(Long.parseLong(first), newStones.getOrDefault(Long.parseLong(first), 0L) + hashMap.get(key));
                    newStones.put(Long.parseLong(second), newStones.getOrDefault(Long.parseLong(second), 0L) + hashMap.get(key));
                    continue;
                }

                newStones.put(key * 2024, newStones.getOrDefault(key * 2024, 0L) + hashMap.get(key));
            }
            hashMap = new HashMap<>(newStones);
        }
        long sum = 0L;
        for (long value : hashMap.values()) {
            sum += value;
        }

        return sum;
    }
}
