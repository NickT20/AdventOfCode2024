package com.AdventOfCode2024;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Day4 {
    class Coordinaties {
        public Coordinaties(int x, int y) {
            this.x = x;
            this.y = y;
        }
        final int x;
        final int y;
        public int getX() { return this.x; }
        public int getY() { return this.y; }
    }
    public int Part1(String file) throws IOException {
        var result = 0;
        var y = 0;
        var charX = new ArrayList<Coordinaties>();
        var charM = new ArrayList<Coordinaties>();
        var charA = new ArrayList<Coordinaties>();
        var charS = new ArrayList<Coordinaties>();
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            while (br.ready()) {
                var line = br.readLine();
                for (var x = 0; x < line.length(); x++) {
                    switch (line.charAt(x)) {
                        case 'X':
                            charX.add(new Coordinaties(x, y));
                            break;
                        case 'M':
                            charM.add(new Coordinaties(x, y));
                            break;
                        case 'A':
                            charA.add(new Coordinaties(x, y));
                            break;
                        case 'S':
                            charS.add(new Coordinaties(x, y));
                            break;
                        default:
                            break;
                    }
                }
                y++;
            }

            for(Coordinaties xCoor : charX) {
                // Diagonal up left
                if (
                    charM.stream().anyMatch(pred -> pred.getX() == xCoor.getX() - 1 && pred.getY() == xCoor.getY() - 1) &&
                    charA.stream().anyMatch(pred -> pred.getX() == xCoor.getX() - 2 && pred.getY() == xCoor.getY() - 2) &&
                    charS.stream().anyMatch(pred -> pred.getX() == xCoor.getX() - 3 && pred.getY() == xCoor.getY() - 3)
                ) {
                    result++;
                }

                // up
                if (
                    charM.stream().anyMatch(pred -> pred.getX() == xCoor.getX() && pred.getY() == xCoor.getY() - 1) &&
                    charA.stream().anyMatch(pred -> pred.getX() == xCoor.getX() && pred.getY() == xCoor.getY() - 2) &&
                    charS.stream().anyMatch(pred -> pred.getX() == xCoor.getX() && pred.getY() == xCoor.getY() - 3)
                ) {
                    result++;
                }

                // diag up right
                if (
                    charM.stream().anyMatch(pred -> pred.getX() == xCoor.getX() + 1 && pred.getY() == xCoor.getY() - 1) &&
                    charA.stream().anyMatch(pred -> pred.getX() == xCoor.getX() + 2 && pred.getY() == xCoor.getY() - 2) &&
                    charS.stream().anyMatch(pred -> pred.getX() == xCoor.getX() + 3 && pred.getY() == xCoor.getY() - 3)
                ) {
                    result++;
                }

                // left
                if (
                    charM.stream().anyMatch(pred -> pred.getX() == xCoor.getX() - 1 && pred.getY() == xCoor.getY()) &&
                    charA.stream().anyMatch(pred -> pred.getX() == xCoor.getX() - 2 && pred.getY() == xCoor.getY()) &&
                    charS.stream().anyMatch(pred -> pred.getX() == xCoor.getX() - 3 && pred.getY() == xCoor.getY())
                ) {
                    result++;
                }

                // right
                if (
                    charM.stream().anyMatch(pred -> pred.getX() == xCoor.getX() + 1 && pred.getY() == xCoor.getY()) &&
                    charA.stream().anyMatch(pred -> pred.getX() == xCoor.getX() + 2 && pred.getY() == xCoor.getY()) &&
                    charS.stream().anyMatch(pred -> pred.getX() == xCoor.getX() + 3 && pred.getY() == xCoor.getY())
                ) {
                    result++;
                }

                // Diagonal down left
                if (
                    charM.stream().anyMatch(pred -> pred.getX() == xCoor.getX() - 1 && pred.getY() == xCoor.getY() + 1) &&
                    charA.stream().anyMatch(pred -> pred.getX() == xCoor.getX() - 2 && pred.getY() == xCoor.getY() + 2) &&
                    charS.stream().anyMatch(pred -> pred.getX() == xCoor.getX() - 3 && pred.getY() == xCoor.getY() + 3)
                ) {
                    result++;
                }

                // down
                if (
                    charM.stream().anyMatch(pred -> pred.getX() == xCoor.getX() && pred.getY() == xCoor.getY() + 1) &&
                    charA.stream().anyMatch(pred -> pred.getX() == xCoor.getX() && pred.getY() == xCoor.getY() + 2) &&
                    charS.stream().anyMatch(pred -> pred.getX() == xCoor.getX() && pred.getY() == xCoor.getY() + 3)
                ) {
                    result++;
                }

                // diag down right
                if (
                    charM.stream().anyMatch(pred -> pred.getX() == xCoor.getX() + 1 && pred.getY() == xCoor.getY() + 1) &&
                    charA.stream().anyMatch(pred -> pred.getX() == xCoor.getX() + 2 && pred.getY() == xCoor.getY() + 2) &&
                    charS.stream().anyMatch(pred -> pred.getX() == xCoor.getX() + 3 && pred.getY() == xCoor.getY() + 3)
                ) {
                    result++;
                }
            }
        }

        return result;
    }
    public int Part2(String file) throws IOException {
        var result = 0;
        var y = 0;
        var charM = new ArrayList<Coordinaties>();
        var charA = new ArrayList<Coordinaties>();
        var charS = new ArrayList<Coordinaties>();
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            while (br.ready()) {
                var line = br.readLine();
                for (var x = 0; x < line.length(); x++) {
                    switch (line.charAt(x)) {
                        case 'M':
                            charM.add(new Coordinaties(x, y));
                            break;
                        case 'A':
                            charA.add(new Coordinaties(x, y));
                            break;
                        case 'S':
                            charS.add(new Coordinaties(x, y));
                            break;
                        default:
                            break;
                    }
                }
                y++;
            }

            for(Coordinaties aCoor : charA) {
                // M.M
                // .A.
                // S.S
                if (
                    charM.stream().anyMatch(pred -> pred.getX() == aCoor.getX() - 1 && pred.getY() == aCoor.getY() - 1) &&
                    charM.stream().anyMatch(pred -> pred.getX() == aCoor.getX() + 1 && pred.getY() == aCoor.getY() - 1) &&
                    charS.stream().anyMatch(pred -> pred.getX() == aCoor.getX() - 1 && pred.getY() == aCoor.getY() + 1) &&
                    charS.stream().anyMatch(pred -> pred.getX() == aCoor.getX() + 1 && pred.getY() == aCoor.getY() + 1)
                ) {
                    result++;
                }

                // S.S
                // .A.
                // M.M
                if (
                    charM.stream().anyMatch(pred -> pred.getX() == aCoor.getX() - 1 && pred.getY() == aCoor.getY() + 1) &&
                    charM.stream().anyMatch(pred -> pred.getX() == aCoor.getX() + 1 && pred.getY() == aCoor.getY() + 1) &&
                    charS.stream().anyMatch(pred -> pred.getX() == aCoor.getX() - 1 && pred.getY() == aCoor.getY() - 1) &&
                    charS.stream().anyMatch(pred -> pred.getX() == aCoor.getX() + 1 && pred.getY() == aCoor.getY() - 1)
                ) {
                    result++;
                }

                // M.S
                // .A.
                // M.S
                if (
                    charM.stream().anyMatch(pred -> pred.getX() == aCoor.getX() - 1 && pred.getY() == aCoor.getY() - 1) &&
                    charM.stream().anyMatch(pred -> pred.getX() == aCoor.getX() - 1 && pred.getY() == aCoor.getY() + 1) &&
                    charS.stream().anyMatch(pred -> pred.getX() == aCoor.getX() + 1 && pred.getY() == aCoor.getY() - 1) &&
                    charS.stream().anyMatch(pred -> pred.getX() == aCoor.getX() + 1 && pred.getY() == aCoor.getY() + 1)
                ) {
                    result++;
                }

                // S.M
                // .A.
                // S.M
                if (
                    charM.stream().anyMatch(pred -> pred.getX() == aCoor.getX() + 1 && pred.getY() == aCoor.getY() - 1) &&
                    charM.stream().anyMatch(pred -> pred.getX() == aCoor.getX() + 1 && pred.getY() == aCoor.getY() + 1) &&
                    charS.stream().anyMatch(pred -> pred.getX() == aCoor.getX() - 1 && pred.getY() == aCoor.getY() - 1) &&
                    charS.stream().anyMatch(pred -> pred.getX() == aCoor.getX() - 1 && pred.getY() == aCoor.getY() + 1)
                ) {
                    result++;
                }
            }
        }

        return result;
    }
}
