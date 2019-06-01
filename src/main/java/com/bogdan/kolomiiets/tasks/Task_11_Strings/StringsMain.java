package com.bogdan.kolomiiets.tasks.Task_11_Strings;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StringsMain {
    private String[] listOfWords;
    private List<String> textCollection = new ArrayList<>();
    private Map<String, Integer> mapOfWords;
    private File textFile = new File(getClass().getResource("Text.txt").getFile());
    private BufferedReader reader;
    private FileReader fileReader;

    public static void main(String[] args) {
        StringsMain stringsMain = new StringsMain();
        stringsMain.makeAllChecking();
    }

    public StringsMain() {
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
        System.out.println("\nText sorted by the count of chars specified - descending...");
        System.out.println(textCollection = DescCharacterSort.sortListByDescCharacter('T', textCollection));

        //find out palindrome which has max length
        System.out.println("\nFind out palindrome which has max length...");
        System.out.println(FindPalindrome.getMaxLengthPalindrome(textCollection));

        //find out and change specific length words
        System.out.println("\nFind out and change specific length words...");
        System.out.println(textCollection = ReplaceWords.replaceSpecificLengthWords(3, "NEW", textCollection));
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
}