package com.bogdan.kolomiiets.tasks.Task_11_Strings;


import java.io.*;
import java.util.*;

public class TextParser {
    private Map<String, Integer> listOfWords;

    public static void main(String[] args) {
        TextParser parser = new TextParser();
    }

    public TextParser() {
        initMethod();
    }

    private void initMethod(){
        initListOfWords();
        File textFile = new File(getClass().getResource("Text.txt").getFile());
        findOutMatchesCount(textFile, listOfWords);
        listOfWords = sortMatchesCount(listOfWords);
        System.out.println(listOfWords);
    }

    private void initListOfWords(){
        listOfWords = new HashMap<>();
        listOfWords.put("to", 0);
        listOfWords.put("the", 0);
        listOfWords.put("A", 0);
        listOfWords.put("I", 0);
        listOfWords.put("not", 0);
        listOfWords.put("if", 0);
        listOfWords.put("to", 0);
        listOfWords.put("him", 0);
        listOfWords.put("have", 0);
        listOfWords.put("no", 0);
    }

    public void findOutMatchesCount(File file, Map<String, Integer> listOfWords){
        BufferedReader reader = null;
        FileReader fileReader = null;

        try {
            fileReader = new FileReader(file);
            reader = new BufferedReader(fileReader);

            String tempLine = "";
            while ((tempLine = reader.readLine()) != null) {
                //Delete all punctuation. Wee need only worlds and numbers
                tempLine = tempLine.replaceAll("[^\\w &\\w]", "");

                for (Map.Entry<String, Integer> entry : listOfWords.entrySet()) {
                    for (String s : tempLine.split(" ")) {
                        if (s.toLowerCase().equals(entry.getKey().toLowerCase())) {
                            listOfWords.put(entry.getKey(), entry.getValue() + 1);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Map<String, Integer> sortMatchesCount(Map<String, Integer> listOfWords) {
        if (listOfWords != null) {
            List<Map.Entry<String, Integer>> tempList = new LinkedList(listOfWords.entrySet());
            Collections.sort(tempList, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));

            Map<String, Integer> sortedMap = new LinkedHashMap<>();
            for (Map.Entry<String, Integer> entry : tempList) {
                sortedMap.put(entry.getKey(), entry.getValue());
            }
            return sortedMap;
        } else throw new NullPointerException();
    }
}
