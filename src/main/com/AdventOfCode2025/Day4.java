package com.AdventOfCode2025;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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

    private boolean valid(Node node, ArrayList<Node> nodes) {
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

    private int getLargestDigitPosition(int start, int end, String line) {
        var firstDigit = 0;
        var firstDigitPosition = 0;
        for(var c = start; c < end; c++) {
            if (line.charAt(c) - '0' > firstDigit - '0') {
                firstDigit = line.charAt(c);
                firstDigitPosition = c;
            }
        }
        return firstDigitPosition;
    }

    public long Part2(String file) throws IOException {
        long result = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            while (br.ready()) {
                var line = br.readLine();
                var digitPosition1 = getLargestDigitPosition(0, line.length() - 11, line);
                var digitPosition2 = getLargestDigitPosition(digitPosition1 + 1 , line.length() - 10, line);
                var digitPosition3 = getLargestDigitPosition(digitPosition2 + 1, line.length() - 9, line);
                var digitPosition4 = getLargestDigitPosition(digitPosition3 + 1, line.length() - 8, line);
                var digitPosition5 = getLargestDigitPosition(digitPosition4 + 1, line.length() - 7, line);
                var digitPosition6 = getLargestDigitPosition(digitPosition5 + 1, line.length() - 6, line);
                var digitPosition7 = getLargestDigitPosition(digitPosition6 + 1, line.length() - 5, line);
                var digitPosition8 = getLargestDigitPosition(digitPosition7 + 1, line.length() - 4, line);
                var digitPosition9 = getLargestDigitPosition(digitPosition8 + 1, line.length() - 3, line);
                var digitPosition10 = getLargestDigitPosition(digitPosition9 + 1, line.length() - 2, line);
                var digitPosition11 = getLargestDigitPosition(digitPosition10 + 1, line.length() - 1, line);
                var digitPosition12 = getLargestDigitPosition(digitPosition11 + 1, line.length(), line);
                var joined =
                        (line.charAt(digitPosition1) - '0') * 100000000000L +
                        (line.charAt(digitPosition2) - '0') * 10000000000L +
                        (line.charAt(digitPosition3) - '0') * 1000000000L +
                        (line.charAt(digitPosition4) - '0') * 100000000L +
                        (line.charAt(digitPosition5) - '0') * 10000000L +
                        (line.charAt(digitPosition6) - '0') * 1000000L +
                        (line.charAt(digitPosition7) - '0') * 100000L +
                        (line.charAt(digitPosition8) - '0') * 10000L +
                        (line.charAt(digitPosition9) - '0') * 1000L +
                        (line.charAt(digitPosition10) - '0') * 100L +
                        (line.charAt(digitPosition11) - '0') * 10L +
                        (line.charAt(digitPosition12) - '0');
                result += joined;
            }
        }

        return result;
    }
}
