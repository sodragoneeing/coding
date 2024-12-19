package org.study.programers.level_1.폰켓몬;

import java.util.HashSet;
import java.util.Set;

class Solution {
  public int solution(int[] nums) {
    int selectPocketMonCount = nums.length / 2;

    return Math.min(convertHashSet(nums).size(), selectPocketMonCount);
  }

  private Set<Integer> convertHashSet(int[] num) {
    Set<Integer> set = new HashSet<>();

    for(int element : num) {
      set.add(element);
    }

    return set;
  }
}