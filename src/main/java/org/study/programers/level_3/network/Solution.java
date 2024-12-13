package org.study.programers.level_3.network;

import java.util.ArrayList;
import java.util.List;
import jdk.jshell.spi.ExecutionControlProvider;

class Solution {

  /*
    백준 섬의 개수 문제와 비슷
   */

  public int solution(int n, int[][] computers) {
    int answer = 0;

    boolean[] visited = new boolean[computers.length];

      for(int i = 0; i < computers[0].length; i++) {
        if(!visited[i]) {
          dfs(computers, visited, i);
          answer++;
        }
      }

    return answer;
  }

  private void dfs(int[][] computers, boolean[] visited, int depth) {

    visited[depth] = true;

    for (int i = 0; i < computers[0].length; i++) {
      if (validateDepth(computers, depth) && !visited[i] && computers[depth][i] == 1) {
        dfs(computers, visited, i);
      }
    }
  }

  private boolean validateDepth(int[][] arr, int depth) {
    return depth >= 0 && depth < arr.length;
  }
}