package com.AdventOfCode2024;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Day8 {
    class Coordinates {
        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
        final int x;
        final int y;
        public int getX() { return this.x; }
        public int getY() { return this.y; }
    }
    public int part1(String file) throws IOException {
        var y = 0;
        var maxX = 0;
        var antennas = new HashMap<Character, ArrayList<Coordinates>>();
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            while (br.ready()) {
                var line = br.readLine();
                maxX = line.length();
                for(var i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    if (c != '.') {
                        if (!antennas.containsKey(c)) {
                            antennas.put(c, new ArrayList<>());
                        }
                        antennas.get(c).add(new Coordinates(i, y));
                    }
                }
                y++;
            }
        }

        HashSet<String> anti = new HashSet<>();

        for (var value : antennas.values()) {
            for (var a = 0; a < value.size(); a++) {
                for (var b = 0; b < value.size(); b++) {
                    if (a == b) { continue; }
                    var xDif = value.get(a).getX() - value.get(b).getX();
                    var yDif = value.get(a).getY() - value.get(b).getY();
                    var newX = value.get(a).getX() + xDif;
                    var newY = value.get(a).getY() + yDif;
                    if (newX >= 0 && newY >= 0 && newX < maxX && newY < y){
                        anti.add(newX + "-" + newY);
                    }

                    var xDif2 = value.get(b).getX() - value.get(a).getX();
                    var yDif2 = value.get(b).getY() - value.get(a).getY();

                    var newX2 = value.get(b).getX() + xDif2;
                    var newY2 = value.get(b).getY() + yDif2;
                    if (newX2 >= 0 && newY2 >= 0 && newX2 < maxX && newY2 < y) {
                        anti.add(newX2 + "-" + newY2);
                    }
                }
            }
        }

        return anti.size();
    }

    public long part2(String file) throws IOException {
        var y = 0;
        var maxX = 0;
        var antennas = new HashMap<Character, ArrayList<Coordinates>>();
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            while (br.ready()) {
                var line = br.readLine();
                maxX = line.length();
                for(var i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    if (c != '.') {
                        if (!antennas.containsKey(c)) {
                            antennas.put(c, new ArrayList<>());
                        }
                        antennas.get(c).add(new Coordinates(i, y));
                    }
                }
                y++;
            }
        }

        HashSet<String> anti = new HashSet<>();

        for (var value : antennas.values()) {
            for (var a = 0; a < value.size(); a++) {
                for (var b = 0; b < value.size(); b++) {
                    if (a == b) { continue; }
                    var valid = true;
                    var xDif = value.get(a).getX() - value.get(b).getX();
                    var yDif = value.get(a).getY() - value.get(b).getY();
                    var xx = value.get(a).getX();
                    var yy = value.get(a).getY();
                    while(valid) {
                        var newX = xx + xDif;
                        var newY = yy + yDif;
                        if (newX >= 0 && newY >= 0 && newX < maxX && newY < y){
                            anti.add(newX + "-" + newY);
                            xx = newX;
                            yy = newY;
                        } else {
                            valid = false;
                        }
                    }

                    valid = true;
                    var xDif2 = value.get(b).getX() - value.get(a).getX();
                    var yDif2 = value.get(b).getY() - value.get(a).getY();
                    while(valid) {
                        var newX2 = xx + xDif2;
                        var newY2 = yy + yDif2;
                        if (newX2 >= 0 && newY2 >= 0 && newX2 < maxX && newY2 < y) {
                            anti.add(newX2 + "-" + newY2);
                            xx = newX2;
                            yy = newY2;
                        } else {
                            valid = false;
                        }
                    }
                }
            }
        }

        return anti.size();
    }
}
