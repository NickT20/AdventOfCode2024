package com.AdventOfCode2025;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day6 {
    public class Column {
        int column;
        List<Long> values = new ArrayList<>();
        boolean multiply = false;

        public Column(int column) {
            this.column = column;
        }
    }
    public class ColumnPart2 {
        int column;
        String value;

        public ColumnPart2(int column) {
            this.column = column;
        }
    }

    public long Part1(String file) throws IOException {
        long result = 0;
        var columns = new ArrayList<Column>();
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            while (br.ready()) {
                var line = br.readLine();
                var parts = line.trim().split("\\s+");
                for(var x = 0; x < parts.length; x++) {
                    final int xx = x;
                    var existingColumn = columns.stream().filter(c -> c.column == xx).findFirst();
                    var valueToAdd = parts[xx];
                    if (valueToAdd.equals("*") || valueToAdd.equals("+")) {
                        existingColumn.get().multiply = valueToAdd.equals("*");
                        continue;
                    }
                    if (existingColumn.isEmpty()) {
                        var columnToAdd = new Column(x);
                        columnToAdd.values.add(Long.valueOf(parts[xx]));
                        columns.add(columnToAdd);
                    } else {
                        existingColumn.get().values.add(Long.valueOf(parts[xx]));
                    }
                }
            }
        }

        for(var column: columns) {
            if (column.multiply) {
                result += column.values.stream().reduce(1L, (a, b) -> a * b);
            } else {
                result += column.values.stream().reduce(0L, Long::sum);
            }
        }

        return result;
    }
    public static String reverseString(String originalString) {
        StringBuilder stringBuilder = new StringBuilder(originalString);
        stringBuilder.reverse();
        return stringBuilder.toString();
    }

    public long Part2(String file) throws IOException {
        long result = 0;
        var columns = new ArrayList<ColumnPart2>();
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            while (br.ready()) {
                var line = br.readLine();
                for(var x = 0; x < line.length(); x++) {
                    var valueToAdd = line.charAt(x);
                    if (valueToAdd == ' ') {
                        continue;
                    }
                    
                    final int xx = x;
                    if (valueToAdd == '*' || valueToAdd == '+') {
                        var nextMulti = line.indexOf('*', x+1);
                        if (nextMulti == -1) {
                            nextMulti = Integer.MAX_VALUE;
                        }
                        var nextAdd = line.indexOf('+', x+1);
                        if (nextAdd == -1) {
                            nextAdd = Integer.MAX_VALUE;
                        }
                        if (nextMulti == Integer.MAX_VALUE && nextAdd == Integer.MAX_VALUE) {
                            nextMulti = line.length();
                            nextAdd = line.length();
                        } {
                            var iterateResult = 0L;
                            for (var columnsToUpdate = x; columnsToUpdate < Math.min(nextMulti, nextAdd); columnsToUpdate++) {
                                final int cctu = columnsToUpdate;
                                var existing = columns.stream().filter(c -> c.column == cctu).findFirst();
                                if (existing.isEmpty()) {
                                    continue;
                                }
                                if (valueToAdd == '*') {
                                    if (iterateResult == 0) {
                                        iterateResult = Long.parseLong(existing.get().value); 
                                    } else {
                                        iterateResult *= Long.parseLong(existing.get().value); 
                                    }
                                    continue;
                                }
                                iterateResult += Long.parseLong(existing.get().value); 
                            }
                            result += iterateResult;
                        }
                        continue;
                    }
                    var existingColumn = columns.stream().filter(c -> c.column == xx).findFirst();
                    if (existingColumn.isPresent()) {
                        existingColumn.get().value = existingColumn.get().value + valueToAdd;
                    } else {
                        var columnToAdd = new ColumnPart2(xx);
                        columnToAdd.value = valueToAdd + "";
                        columns.add(columnToAdd);
                    }
                }
            }
        }

        return result;
    }
}
