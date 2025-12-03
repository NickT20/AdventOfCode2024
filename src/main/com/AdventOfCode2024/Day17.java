//package com.AdventOfCode2024;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.Date;
//import java.sql.Date;
//
//public class Day17 {
//    private long _registerA;
//    private long _registerB;
//    private long _registerC;
//    private String _part2;
//    private int _length = 0;
//    public long part1(long a, int b, int c, String program) {
//        _registerA = a;
//        _registerB = b;
//        _registerC = c;
//        var code = program.split(",");
//
//        for (var x = 0; x < code.length; x = x + 2) {
//            switch (code[x]) {
//                case "0":
//                    var numerator = _registerA;
//                    var denominator = Math.pow(2, getValue(code[x + 1]));
//                    _registerA = (long) (numerator / denominator);
//                    break;
//                case "1":
//                    _registerB = _registerB ^ Integer.parseInt(code[x + 1]);
//                    break;
//                case "2":
//                    _registerB = (long) getValue(code[x + 1]) % 8;
//                    break;
//                case "3":
//                    if (_registerA == 0) { break; }
//                    x = Integer.parseInt(code[x + 1]) - 2;
//                    break;
//                case "4":
//                    _registerB = _registerB ^ _registerC;
//                    break;
//                case "5":
//                    System.out.print((int) getValue(code[x + 1]) % 8);
//                    System.out.print(",");
//                    break;
//                case "6":
//                    var numerator2 = _registerA;
//                    var denominator2 = Math.pow(2, getValue(code[x + 1]));
//                    _registerB = (int) (numerator2 / denominator2);
//                    break;
//                case "7":
//                    var numerator3 = _registerA;
//                    var denominator3 = Math.pow(2, getValue(code[x + 1]));
//                    _registerC = (int) (numerator3 / denominator3);
//                    break;
//                default:
//                    System.out.println("Bad opcode");
//                    break;
//            }
//        }
//
//        return 0;
//    }
//
//    private double getValue(String operand) {
//        return switch (Integer.parseInt(operand)) {
//            case 0, 1, 2, 3 -> Integer.parseInt(operand);
//            case 4 -> _registerA;
//            case 5 -> _registerB;
//            case 6 -> _registerC;
//            default -> {
//                System.out.println("Bad Value");
//                yield 0;
//            }
//        };
//    }
//
//    public long part2(int a, int b, int c, String program) {
//        // length increases by powers of 8
//        // 2 - 8
//        // 3 - 64
//        // 4 - 512
//        // Thus 13 begins at 68719476736
//        // Ends with 0 beginning at 343597383680
//        // Next number at 412316860416 so between there
//        var power = 14;
//        long iteration = 0L;
////        long iteration = 175921860444160L;
//        _registerB = b;
//        _registerC = c;
//        var notFound = true;
//        var sb = new StringBuilder();
//
//        while(notFound) {
////            iteration+=8;
////            if (iteration % 1000000 == 0) { System.out.println(iteration); }
//            _registerA = iteration;
//            var code = program.split(",");
//            for (var x = 0; x < code.length; x = x + 2) {
//                switch (code[x]) {
//                    case "0":
//                        var numerator = _registerA;
//                        var denominator = Math.pow(2, getValue(code[x + 1]));
//                        _registerA = (long) (numerator / denominator);
//                        break;
//                    case "1":
//                        _registerB = _registerB ^ Integer.parseInt(code[x + 1]);
//                        break;
//                    case "2":
//                        _registerB = (long) getValue(code[x + 1]) % 8;
//                        break;
//                    case "3":
//                        if (_registerA == 0) {
//                            break;
//                        }
//                        x = Integer.parseInt(code[x + 1]) - 2;
//                        break;
//                    case "4":
//                        _registerB = _registerB ^ _registerC;
//                        break;
//                    case "5":
//                        sb.append((int) getValue(code[x + 1]) % 8);
////                        var test = sb.toString();
////                        if (!test.equals(program.substring(0, test.length()))) { x = code.length; }
//                        sb.append(",");
//                        break;
//                    case "6":
//                        var numerator2 = _registerA;
//                        var denominator2 = Math.pow(2, getValue(code[x + 1]));
//                        _registerB = (int) (numerator2 / denominator2);
//                        break;
//                    case "7":
//                        var numerator3 = _registerA;
//                        var denominator3 = Math.pow(2, getValue(code[x + 1]));
//                        _registerC = (int) (numerator3 / denominator3);
//                        break;
//                    default:
//                        System.out.println("Bad opcode");
//                        break;
//                }
//            }
//            _part2 = sb.toString();
//            sb = new StringBuilder();
//            System.out.println(iteration + ":" + _part2 + ":" + power);
////            var p =_part2.substring(0, _part2.length() - 1).split(",");
////            while(power > 0 && p[power].equals(code[power])) {
////                power--;
////                System.out.println(iteration + ":" + _part2 + ":" + power);
////            }
////            if (power + 1 < p.length - 1 && !p[power + 1].equals(code[power + 1])) {
////                power++;
////            }
////            if (_part2.substring(0, _part2.length() - 1).equals(program)) {
////                notFound = false;
////            }
////            iteration += Math.pow(8, power);
//            iteration++;
//        }
//
//        return iteration - 1;
//    }
//}
