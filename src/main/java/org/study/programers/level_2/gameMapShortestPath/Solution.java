package org.study.programers.level_2.gameMapShortestPath;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
  public int solution(int[][] maps) {
    int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    return bfs(maps, direction);
  }

  private int bfs(int[][] grids, int[][] direction) {

    Queue<int[]> queue = new LinkedList<>();
    boolean[][] visited = new boolean[grids.length][grids[0].length];
    int[][] distance = new int[grids.length][grids[0].length];

    // 최초 시작 위치 queue 삽입 삽입
    dataInsert(queue, visited, 0, 0);
    distance[0][0] = 1;

    while(!queue.isEmpty()) {
      int[] current = queue.poll();
      int curX = current[0];
      int curY = current[1];

      if(curX == grids[0].length - 1 && curY == grids.length - 1) {
        return distance[curY][curX];
      }

      for(int i = 0; i < direction.length; i++) {
         int dx = curX + direction[i][0];
         int dy = curY + direction[i][1];

        if(validatePosition(grids, visited, dx, dy)) {
          dataInsert(queue, visited, dx, dy);
          distance[dy][dx] = distance[curY][curX] + 1;
        }
      }
    }
    return -1;
  }

  private void dataInsert(Queue<int[]> queue, boolean[][] visited, int x, int y) {
    queue.add(new int[]{x, y});
    visited[y][x] = true;
  }

  private boolean validatePosition(int[][] grid, boolean[][] visited, int x, int y) {
    if(x < 0 || y < 0 || x > 100 || y > 100) {
      return false;
    }

    if(x > grid[0].length - 1 || y > grid.length - 1) {
      return false;
    }

    if(grid[y][x] == 0 || visited[y][x]) {
      return false;
    }

    return true;
  }
}
