package org.study.programers.level_1.mockTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
  public int[] solution(int[] answers) {
    int[] arr1 = {1, 2, 3, 4, 5};
    int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
    int[] arr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    int score1 = gradeStudent(answers, arr1);
    int score2 = gradeStudent(answers, arr2);
    int score3 = gradeStudent(answers, arr3);

    List<Integer> lists = new ArrayList<>();
    lists.add(score1);
    lists.add(score2);
    lists.add(score3);

    return findMaxScoreIndex(lists);

  }

  private int[] findMaxScoreIndex(List<Integer> lists) {
    int max = Collections.max(lists);

    List<Integer> orderLists = new ArrayList<>();

    for(int i = 0; i < lists.size(); i++) {
      if(max == lists.get(i)) {
        orderLists.add(i + 1);
      }
    }

    Collections.sort(orderLists);

    int[] arr = new int[orderLists.size()];
    for(int i = 0; i < orderLists.size(); i++) {
      arr[i] = orderLists.get(i);
    }

    return arr;
  }



  private int gradeStudent(int[] answers, int[] arr) {
    int grade = 0;

    for(int i = 0; i < answers.length; i++) {
      if(answers[i] == arr[i % arr.length]) {
        grade++;
      }
    }

    return grade;
  }
}