package com.AdventOfCode2024;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;

public class Day9 {
    public long part1(String file) throws IOException {
        var fileId = 0;
        var charList = new LinkedList<Integer>();
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            while (br.ready()) {
                var line = br.readLine();
                for (var x = 0; x < line.length(); x++) {
                    var isFile = x % 2 == 0;
                    if (isFile) {
                        var numberOfSpaces = line.charAt(x) - '0';
                        while (numberOfSpaces > 0) {
                            charList.add(fileId);
                            numberOfSpaces--;
                        }
                        ++fileId;
                    } else {
                        var numberOfSpaces = line.charAt(x) - '0';
                        while (numberOfSpaces > 0) {
                            charList.add(-1);
                            numberOfSpaces--;
                        }
                    }
                }
            }
        }

        for (var i = 0; i < charList.size(); i++) {
            if (charList.get(i) == -1) {
                charList.remove(i);
                int toAdd = -1;
                do {
                    toAdd = charList.removeLast();
                } while (toAdd == -1);
                charList.add(i, toAdd);
            }
        }

        long checkSum = 0;
        for (var i = 0; i < charList.size(); i++) {
            checkSum += charList.get(i) * i;
        }


        return checkSum;
    }

    public long part2(String file) throws IOException {
        var fileId = 0;
        var charList = new ArrayList<Integer>();
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            while (br.ready()) {
                var line = br.readLine();
                for (var x = 0; x < line.length(); x++) {
                    var isFile = x % 2 == 0;
                    if (isFile) {
                        var numberOfSpaces = line.charAt(x) - '0';
                        while (numberOfSpaces > 0) {
                            charList.add(fileId);
                            numberOfSpaces--;
                        }
                        ++fileId;
                    } else {
                        var numberOfSpaces = line.charAt(x) - '0';
                        while (numberOfSpaces > 0) {
                            charList.add(-1);
                            numberOfSpaces--;
                        }
                    }
                }
            }
        }
        for (var i = charList.size() - 1; i > 0; i--) {
            var x = charList.get(i);
            var startOfFileId = -1;
            if (x != -1) {
                startOfFileId = i;
                var size = 1;
                var decIndex = 1;
                while ((i - decIndex) >= 0 && Objects.equals(x, charList.get(i - decIndex))) {
                    size++;
                    decIndex++;
                }
                var free = 0;
                var startIndex = 0;
                for (var ii = 0; ii < startOfFileId && size != 0; ii++) {
                    if (charList.get(ii) == -1) {
                        if (startIndex == 0) { startIndex = ii; }
                        free++;

                        var iter = 0;
                        if (free == size) {
                            while (free > 0) {
                                charList.set(startOfFileId - iter, -1);
                                charList.set(startIndex + iter, x);
                                iter++;
                                free--;
                            }
                            size = 0;
                        }
                    } else {
                        free = 0;
                        startIndex = 0;
                    }
                }

                if (size > 0) {
                    i -= size;
                    i++;
                }
            }
        }

        long checkSum = 0;
        for (var i = 0; i < charList.size(); i++) {
            if(charList.get(i) == -1) { continue; }
            checkSum += charList.get(i) * i;
        }


        return checkSum;
    }
}
