package com.AdventOfCode2024;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Day3 {
    public int Part1(String file) throws IOException {
        var result = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            while (br.ready()) {
                var line = br.readLine();
                var regex = "mul\\(\\d+,\\d+\\)";
                var pattern = Pattern.compile(regex);
                var matcher = pattern.matcher(line);

                while (matcher.find()) {
                    var integerRegex = "\\d+";
                    var integerPattern = Pattern.compile(integerRegex);
                    var integerMatcher = integerPattern.matcher(matcher.group());
                    var numbers = new ArrayList<Integer>();
                    while (integerMatcher.find()) {
                        numbers.add(Integer.parseInt(integerMatcher.group(0)));
                    }
                    result += numbers.get(0) * numbers.get(1);
                }
            }
        }

        return result;
    }
    public int Part2(String file) throws IOException {
        var result = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            var disabled = false;
            while (br.ready()) {
                var line = br.readLine();
                var regex = "((don[']t|do)\\(\\))|mul\\(\\d+,\\d+\\)";
                var pattern = Pattern.compile(regex);
                var matcher = pattern.matcher(line);

                while (matcher.find()) {
                    var match = matcher.group();
//                    System.out.println("Match: " + match);
                    if (match.equals("do()")) {
                        disabled = false;
                        continue;
                    }

                    if (match.equals("don't()")) {
                        disabled = true;
                    }

                    if (!disabled) {
                        var integerRegex = "\\d+";
                        var integerPattern = Pattern.compile(integerRegex);
                        var integerMatcher = integerPattern.matcher(matcher.group());
                        var numbers = new ArrayList<Integer>();
                        while (integerMatcher.find()) {
                            numbers.add(Integer.parseInt(integerMatcher.group(0)));
                        }
                        result += numbers.get(0) * numbers.get(1);
                    }
                }
            }
        }

        return result;
    }
}
