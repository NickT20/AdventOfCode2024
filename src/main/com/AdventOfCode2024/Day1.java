package com.AdventOfCode2024;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day1 {
    public int Part1(String file) throws IOException {
        var result = 0;
        var left = new ArrayList<Integer>();
        var right = new ArrayList<Integer>();
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            while (br.ready()) {
                var line = br.readLine();
                var inputs = line.split("\\s+");
                left.add(Integer.parseInt(inputs[0]));
                right.add(Integer.parseInt(inputs[1]));
            }
        }

        Collections.sort(left);
        Collections.sort(right);

        for(var i = 0; i < left.size(); i++) {
            result += Math.abs(right.get(i) - left.get(i));
        }

        return result;
    }
    public int Part2(String file) throws IOException {
        var result = 0;
        var left = new ArrayList<Integer>();
        var unique = new HashMap<Integer, Integer>();
        var right = new ArrayList<Integer>();
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            while (br.ready()) {
                var line = br.readLine();
                var inputs = line.split("\s+");
                left.add(Integer.parseInt(inputs[0]));
                right.add(Integer.parseInt(inputs[1]));
                unique.put(Integer.parseInt(inputs[0]), 0);
            }
        }

        for (Integer integer : right) {
            unique.compute(integer, (key, value) -> value == null ? 1 : value + 1);
        }

        for (Integer integer : left) {
            result += integer * unique.get(integer);
        }

        return result;
    }
}
