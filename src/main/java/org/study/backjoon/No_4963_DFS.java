package org.study.backjoon;


import java.util.Scanner;

public class No_4963_DFS {

  /*
   * DFS를 이용하여 모든 섬의 개수를 count만 하는 소스 코드
   *
   * 입력 정보
   * 1 1
   * 0
   * 2 2
   * 0 1
   * 1 0
   * 3 2
   * 1 1 1
   * 1 1 1
   * 5 4
   * 1 0 1 0 0
   * 1 0 0 0 0
   * 1 0 1 0 1
   * 1 0 0 1 0
   * 5 4
   * 1 1 1 0 1
   * 1 0 1 0 1
   * 1 0 1 0 1
   * 1 0 1 1 1
   * 5 5
   * 1 0 1 0 1
   * 0 0 0 0 0
   * 1 0 1 0 1
   * 0 0 0 0 0
   * 1 0 1 0 1
   * 0 0
   *
   * 결과 정보
   * 0
   * 1
   * 1
   * 3
   * 1
   * 9
   *
   */


  static int w, h;
  static int[][] grid;
  static int[][] DIRECTION = {
      {1, 0}, {-1, 0}, {0, 1}, {0, -1},
      {-1, 1}, {-1, -1}, {1, 1}, {1, -1}
  };

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    while (true) {
      w = scanner.nextInt();
      h = scanner.nextInt();

      if (w == 0 && h == 0) break;

      grid = new int[h][w];
      for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
          grid[i][j] = scanner.nextInt();
        }
      }

      boolean[][] visited = new boolean[h][w];
      int islandCount = 0;

      for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
          if (grid[i][j] == 1 && !visited[i][j]) {
            dfs(j, i, visited);
            islandCount++;
          }
        }
      }

      System.out.println(islandCount);
    }
  }

  static void dfs(int x, int y, boolean[][] visited) {
    visited[y][x] = true;

    for (int[] dir : DIRECTION) {
      int dx = x + dir[0];
      int dy = y + dir[1];

      if (validateValue(dx, dy) && grid[dy][dx] == 1 && !visited[dy][dx]) {
        dfs(dx, dy, visited);
      }
    }
  }

  static boolean validateValue(int x, int y) {
    return x >= 0 && x < w && y >= 0 && y < h;
  }
}