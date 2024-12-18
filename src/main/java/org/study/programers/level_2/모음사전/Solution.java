package org.study.programers.level_2.모음사전;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Solution {
  public int solution(String word) {
    String dictionaryWord = "AEIOU";
    String[] dictionaryWordArr = dictionaryWord.split("");

    List<String> dictionary = new LinkedList<>();
    for(int i = 0; i < dictionaryWord.length(); i++) {
      List<String> temp = new LinkedList<>();
      generateDictionary(dictionaryWordArr[i], dictionaryWordArr, temp);
      dictionary.addAll(temp);
    }

    Collections.sort(dictionary);
//    System.out.println(dictionary);

    return dictionary.indexOf(word) + 1;
  }

  private void generateDictionary(String startStr, String[] word, List<String> result) {
    if(startStr != null) {
      result.add(startStr);
    }

    for(int i = 0; i < word.length; i++) {
      String current = word[i];
      String data = concat(startStr, current);
//      result.add(data);
//      word[i] = null;

      if(data.length() > word.length) {
        continue;
      }

      generateDictionary(data, word, result);
    }
  }

  private String concat(String str1, String str2) {
    if(str1 == null) {
      return str2;
    }

    if(str2 == null) {
      return str1;
    }

    return str1 + str2;
  }
}