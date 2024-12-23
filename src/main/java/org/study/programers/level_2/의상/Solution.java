package org.study.programers.level_2.의상;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
  public int solution(String[][] clothes) {
    Set<String> typeSet = new HashSet<>();

    // 의상 종류 생성
    for(String[] cloth : clothes) {
      typeSet.add(cloth[1]);
    }

    List<List<String[]>> clothesSortSet = new ArrayList<>();
    for(String clothesType : typeSet) {
      List<String[]> clothesTypeSet = new ArrayList<>();
      for(String[] cloth : clothes) {
        if(clothesType.equals(cloth[1])) {
          clothesTypeSet.add(cloth);
        }
      }
      clothesSortSet.add(clothesTypeSet);
    }

    return clothCombinationCount(clothesSortSet);
  }

  private int clothCombinationCount(List<List<String[]>> lists) {
    int result = 1;
    for(List<String[]> list : lists) {
      result = result * (list.size() + 1);
    }

    // 전부 선택하지 않은 경우의 수 1을 뺀다
    return result - 1;
  }
}