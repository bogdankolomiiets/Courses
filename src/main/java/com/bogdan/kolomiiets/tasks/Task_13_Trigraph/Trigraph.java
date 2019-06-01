package com.bogdan.kolomiiets.tasks.Task_13_Trigraph;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Trigraph {
    private static Map<String, Integer> trigraphMap = new HashMap<>();
    private static File sourceFile = new File("TrigraphSource.txt");
    private static File fileToSaveResults = new File("TrigraphResults.txt");

    public static void main(String[] args) {
        saveResultsToFileAndDisplay(readFileAndPutToMap(sourceFile), fileToSaveResults);
    }

    public static Map<String, Integer> readFileAndPutToMap(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file));) {
            Pattern pattern = Pattern.compile("\\w{3}");
            Matcher matcher;
            String temp;
            while ((temp = reader.readLine()) != null) {
                temp = temp.replaceAll("[^\\w &\\w]", "").toUpperCase();
                System.out.println(temp + "\n");
                matcher = pattern.matcher(temp);
                int startAt = 0;
                while (matcher.find(startAt)) {
                    String s = matcher.group();
                    startAt = matcher.start() + 1;
                    trigraphMap.put(s, trigraphMap.containsKey(s) ? trigraphMap.get(s).intValue() + 1 : 1);
                }
            }
            return trigraphMap;
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }

    //Method saves result to file and displays it.
    public static boolean saveResultsToFileAndDisplay(Map<String, Integer> mapForSaving, File fileToSaveResults) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSaveResults, false))) {
            mapForSaving.entrySet().stream()
                    .sorted((o1, o2) -> o1.getKey().compareTo(o2.getKey()))
                    .forEach(entry -> {
                        try {
                            writer.write(entry.getKey() + " = " + entry.getValue() + "\n");
                            System.out.println(entry.getKey() + " = " + entry.getValue());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
            return true;
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }
}
