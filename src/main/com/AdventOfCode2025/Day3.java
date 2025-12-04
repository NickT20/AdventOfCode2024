package com.AdventOfCode2025;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day3 {
    public long Part1(String file) throws IOException {
        long result = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            while (br.ready()) {
                var line = br.readLine();
                var firstDigit = 0;
                var firstDigitPosition = 0;
                var lastDigit = 0;
                for(var c = 0; c < line.length() - 1; c++) {
                    if (line.charAt(c) - '0' > firstDigit - '0') {
                        firstDigit = line.charAt(c);
                        firstDigitPosition = c;
                    }
                }
                for(var c = firstDigitPosition + 1; c < line.length(); c++) {
                    var digit = line.charAt(c) - '0';
                    if (digit > lastDigit - '0') {
                        lastDigit = line.charAt(c);
                    }
                }
                var joined = (firstDigit - '0') * 10 + (lastDigit - '0');
                result += joined;
            }
        }

        return result;
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
