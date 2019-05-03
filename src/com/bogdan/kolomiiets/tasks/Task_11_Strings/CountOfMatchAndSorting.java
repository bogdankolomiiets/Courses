package com.bogdan.kolomiiets.tasks.Task_11_Strings;

import java.util.*;

public class CountOfMatchAndSorting {

    public Map<String, Integer> findOutMatchesCount(List<String> textCollection, String[] listOfWords) {
        if(textCollection != null && listOfWords != null) {
            //creating Map<String, Integer> with list of words
            Map<String, Integer> mapOfWords = new HashMap<>();
            for (String s : listOfWords) {
                mapOfWords.put(s, 0);
            }

            //counting matching of words
            for (Map.Entry<String, Integer> entry : mapOfWords.entrySet()) {
                for (int i = 0; i < textCollection.size(); i++) {
                    if (entry.getKey().equalsIgnoreCase(textCollection.get(i))) {
                        mapOfWords.put(entry.getKey(), entry.getValue() + 1);
                    }
                }
            }
            return mapOfWords;
        } else throw new NullPointerException();
    }

    public Map<String, Integer> sortMatchesCount(Map<String, Integer> mapOfWords) {
        if (mapOfWords != null) {
            List<Map.Entry<String, Integer>> tempList = new LinkedList(mapOfWords.entrySet());
            Collections.sort(tempList, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

            Map<String, Integer> sortedMap = new LinkedHashMap<>();
            for (Map.Entry<String, Integer> entry : tempList) {
                sortedMap.put(entry.getKey(), entry.getValue());
            }
            return sortedMap;
        } else throw new NullPointerException();
    }
}
