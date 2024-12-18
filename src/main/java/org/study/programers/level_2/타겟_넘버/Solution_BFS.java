package org.study.programers.level_2.타겟_넘버;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution_BFS {
  //DFS 이용 풀이
  public int solution(int[] numbers, int target) {
    int answer = 0;

    List<Integer> lists = new ArrayList<>();
    bfs(numbers, lists);

    for(int sum : lists) {
      if(sum == target) {
        answer++;
      }
    }

    return answer;
  }

  private void bfs(int[] arr, List<Integer> result) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(0);

    for(int i = 0; i < arr.length; i++) {
      int queueSize = queue.size();
      for(int j = 0; j < queueSize; j++) {
        int sum = queue.poll();
        queue.add(sum + arr[i]);
        queue.add(sum - arr[i]);
      }
    }

    while(!queue.isEmpty()) {
      result.add(queue.poll());
    }
  }
}

