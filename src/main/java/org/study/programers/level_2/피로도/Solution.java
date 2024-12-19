package org.study.programers.level_2.피로도;

import java.util.ArrayList;
import java.util.List;

class Solution {
  int count = 0;
//  List<List<Integer>> resultList;

  public int solution(int k, int[][] dungeons) {

//    resultList = new ArrayList<>();
    dfs(0, k, dungeons, new boolean[dungeons.length]);
//    System.out.println(resultList);

    return count;
  }

  private void dfs(int index, int startFatigue, int[][] dungeons, boolean[] visited) {
    List<Integer> lists = new ArrayList<>();
    for(int i = 0; i < dungeons.length; i++) {
      int requiredFatigue = dungeons[i][0];
      int minusFatigue = dungeons[i][1];

      if(visited[i] || startFatigue < requiredFatigue) {
        continue;
      }

      visited[i] = true;
      lists.add(i);
      dfs(index + 1, startFatigue - minusFatigue, dungeons, visited);
      visited[i] = false;

    }

//    resultList.add(lists);
    count = Math.max(count, index);
  }
}