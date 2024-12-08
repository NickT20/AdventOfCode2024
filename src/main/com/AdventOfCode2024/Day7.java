package com.AdventOfCode2024;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;

public class Day7 {
    public BigInteger Part1(String file) throws IOException {
        BigInteger result = BigInteger.ZERO;
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            while (br.ready()) {
                var line = br.readLine();
                var part1 = line.split(":");
                var part2 = part1[1].split("\\s+");
                BigInteger total = new BigInteger(part1[0]);
                int[] intParts = Arrays.stream(part2).filter(s -> !s.isEmpty()).mapToInt(Integer::parseInt).toArray();
                if (backtrack(total, intParts,  BigInteger.ZERO, 0)) {
                    result = result.add(total);
                }
            }
        }

        return result;
    }

    private boolean backtrack(BigInteger target, int[] set, BigInteger currentTotal, int index) {
        if (index == set.length) {
            return currentTotal.equals(target);
        }

        // addition
        if (backtrack(target, set, currentTotal.add(BigInteger.valueOf(set[index])), index + 1)) {
            return true;
        }

        // multiplication
        return backtrack(target, set, currentTotal.multiply(BigInteger.valueOf(set[index])), index + 1);
    }


//    public static boolean isValid(int[] numbers, int target) {
//        if (numbers == null || numbers.length == 0) {
//            return false;
//        }
//        return backtrack(numbers, target, numbers[0], 1);
//    }
//
//    private static boolean backtrack(int[] numbers, int target, int currentTotal, int index) {
//        // Base case: If we've used all numbers, check if we reached the target
//        if (index == numbers.length) {
//            return currentTotal == target;
//        }
//
//        // Add the next number
//        if (backtrack(numbers, target, currentTotal + numbers[index], index + 1)) {
//            return true;
//        }
//
//        // Multiply the next number
//        if (backtrack(numbers, target, currentTotal * numbers[index], index + 1)) {
//            return true;
//        }
//
//        // If neither addition nor multiplication worked, return false
//        return false;
//    }

    public int Part2(String file) throws IOException {
        var result = 0;


        return result;
    }
}
