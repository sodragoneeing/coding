package org.study.programers.level_2.targetNumber;

import java.util.ArrayList;
import java.util.List;

class Solution_DFS {
  //DFS 이용 풀이
  public int solution(int[] numbers, int target) {
    int answer = 0;

    List<Integer> lists = new ArrayList<>();

    dfs(numbers, 0, lists, target, 0);
    for(int result : lists) {
      if(result == target) {
        answer++;
      }
    }

    return answer;
  }

  private void dfs(int[] arr, int depth, List<Integer> lists, int expectedValue, int realValue) {
    if(depth == arr.length) {
      lists.add(realValue);
    }
    else {
      dfs(arr, depth + 1, lists, expectedValue, realValue + arr[depth]);
      dfs(arr, depth + 1, lists, expectedValue, realValue - arr[depth]);
    }
  }
}

