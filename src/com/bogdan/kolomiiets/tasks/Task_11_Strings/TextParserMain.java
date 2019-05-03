package com.bogdan.kolomiiets.tasks.Task_11_Strings;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TextParserMain {
    private String[] listOfWords;
    private List<String> textCollection = new ArrayList<>();
    private Map<String, Integer> mapOfWords;
    private File textFile = new File(getClass().getResource("Text.txt").getFile());
    private BufferedReader reader;
    private FileReader fileReader;

    public static void main(String[] args) {
        TextParserMain textParser = new TextParserMain();
        textParser.makeAllChecking();
    }

    public TextParserMain() {
        String[] words = {"to", "do", "I", "no", "not", "the"};
        initListOfWords(words);
        setTextCollection(textFile);
    }

    public void makeAllChecking(){
        System.out.println("Initial list...");
        System.out.println(mapOfWords = CountOfMatchAndSorting.findOutMatchesCount(textCollection, listOfWords));

        //sort mapOfWords by count of matches - desc
        //display mapOfWords after sorting
        System.out.println("\nList after sorting...");
        System.out.println(mapOfWords = CountOfMatchAndSorting.sortMatchesCount(mapOfWords));

        //sorting text by count of chars specified - desc
        DescCharacterSort descCharacterSort = new DescCharacterSort();
        System.out.println("\nText sorted by the count of chars specified - descending...");
        System.out.println(textCollection = descCharacterSort.sortListByDescCharacter('t', textCollection));

        //find out palindrome which has max length
        System.out.println("\nFind out palindrome which has max length...");
        getMaxLengthPalindrome(textCollection);

        //find out and change specific length words
        System.out.println("\nFind out and change specific length words...");
        System.out.println(textCollection = ReplaceWords.replaceSpecificLengthWords(4, "LLL", textCollection));
    }

    private void initListOfWords(String[] listOfWords) {
        if (listOfWords != null) {
            this.listOfWords = listOfWords;
        } else throw new NullPointerException();
    }

    private void setTextCollection(File textFile) {
        if (textFile != null && textFile.getName().contains(".txt")) {
            try {
                fileReader = new FileReader(textFile);
                reader = new BufferedReader(fileReader);
                String tempString = "";
                while ((tempString = reader.readLine()) != null) {
                    //Delete all punctuation. Wee need only worlds and numbers and fill textCollection
                    for (String s : tempString.replaceAll("[^\\w &\\w]", "").split(" ")){
                        textCollection.add(s);
                    }
                }
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
        } else throw new NullPointerException();
    }

    public void getMaxLengthPalindrome(List<String> textCollection) {
        if (textCollection != null) {
            String palindrome = "";
            for (String s : textCollection){
                if (s.equalsIgnoreCase(new StringBuffer(s).reverse().toString())){
                    palindrome = s.length() > palindrome.length() ? s : palindrome;
                }
            }
            System.out.println(palindrome.length() > 0 ? "MAX length palindrome is: " + palindrome : "This text has no palindrome");
        } else throw new NullPointerException();
    }
}