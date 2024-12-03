package com.AdventOfCode2024;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Day2 {
    public int Part1(String file, boolean canSkip) throws IOException {
        var result = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            while (br.ready()) {
                var line = br.readLine();
                var inputs = line.split("\\s");

                int[] intArray = Arrays.stream(inputs)
                    .mapToInt(Integer::parseInt)
                    .toArray();

                // Convert int[] to ArrayList<Integer>
                ArrayList<Integer> arrayList = new ArrayList<>();
                for (int num : intArray) {
                    arrayList.add(num); // Autoboxing int to Integer
                }

                if (isValid(arrayList, canSkip)) { result++; }
            }
        }

        return result;
    }

    private boolean isValid(ArrayList<Integer> input, boolean canSkipOnce) {
        var goUp = input.get(0) < input.get(1);
        for (var i = 0; i < (input.size() - 1); i++) {
            if ((goUp && (input.get(i) >= input.get(i + 1) || input.get(i) < input.get(i + 1) - 3)) ||
                (!goUp && (input.get(i) <= input.get(i + 1) || input.get(i) > input.get(i + 1) + 3))) {
                if (canSkipOnce) {
                    for (var x = 0; x < input.size(); x++) {
                        var temp = input.get(x);
                        input.remove(x);
                        if (isValid(input, false)) { return true; }
                        input.add(x, temp);
                    }
                }
                return false;
            }
        }
        return true;
    }
}
