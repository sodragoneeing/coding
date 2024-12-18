package org.study.programers.level_2.소수_찾기;

import java.util.HashSet;
import java.util.Set;

class Solution {
  public int solution(String numbers) {
    Set<String> result = new HashSet<>();
    dfs(null, numbers.split(""), result);

    System.out.println(convertIntegerLists(result));

    int count = 0;
    for(int num : convertIntegerLists(result)) {
      if(distinguishPrimeNum(num)) {
        count++;
      }
    }

    return count;
  }

  private void dfs(String targetNum, String[] concatNum, Set<String> result) {
    if(targetNum != null) {
      result.add(targetNum);
    }

    for(int i = 0; i < concatNum.length; i++) {
      if(concatNum[i] == null) {
        continue;
      }
      String current = concatNum[i];
      concatNum[i] = null;
      dfs(concat(targetNum, current), concatNum, result);
      concatNum[i] = current;
    }
  }

  private boolean distinguishPrimeNum(int num) {
    if(num <= 1) {
      return false;
    }

    for(int i = 2 ; i < num; i++) {
      if(num % i == 0) {
        return false;
      }
    }

    return true;
  }

  private Set<Integer> convertIntegerLists(Set<String> lists) {
    Set<Integer> integerLists = new HashSet<>();
    for(String str : lists) {
      if(str == null) {
        continue;
      }

      int num = Integer.parseInt(str);

      integerLists.add(num);
    }

    return integerLists;
  }

  private String concat(String num1, String num2) {
    String result;
    if(num1 == null) {
      result = num2;
    }
    else if (num2 == null) {
      result = num1;
    }
    else {
      result = num1 + num2;
    }

    return result;
  }
}