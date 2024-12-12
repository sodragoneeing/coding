package org.study.backjoon;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class No_4963_DFS_2 {
  /*
   * DFS를 이용하여 모든 섬의 좌표를 찾아 내는 코드
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

  static int w;
  static int h;
  static int[][] grid;
  static int[][] DIRECTION = {
      {1, 0}, {-1, 0}, {0, 1}, {0, -1},   // 동서남북 방향 이동
      {-1, 1}, {-1, -1}, {1, 1}, {1, -1}, // 대각선 방향 이동
  };

  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);

    while (true) {
      // w, h 입력
      w = scanner.nextInt();
      h = scanner.nextInt();

      // 마지막 줄 인지 확인
      if (w == 0 && h == 0) {
        break;
      }

      // grid 생성
      grid = new int[h][w];
      for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
          grid[i][j] = scanner.nextInt();
        }
      }

      List<boolean[][]> islandGridLists = new ArrayList<>();
      for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
          boolean[][] visited = new boolean[h][w];

          dfs(grid, visited, j, i);

          if(checkRedundantElement(islandGridLists, visited)) {
            islandGridLists.add(visited);
          }
        }
      }

      System.out.println(islandGridLists.size());
    }
  }

  static void printGridInfo(int[][] grid) {
    System.out.println("-----------------------------");
    System.out.printf("col : %d\n", grid.length);
    System.out.printf("row : %d\n", grid[0].length);

    for (int[] row : grid) {
      for (int element : row) {
        System.out.printf("%d ", element);
      }
      System.out.printf("\n");
    }
  }

  static void dfs(int[][] grid, boolean[][] visited, int startX, int startY) {
    // 좌표 검증
    if (!validateValue(startX, startY, grid)) {
      return;
    }

    // 방문 여부 확인 (방문 한 좌표면 종료
    if (visited[startY][startX]) {
      return;
    }

    // 좌표 내 방문 할 수 없는 좌표면 종료
    if (grid[startY][startX] == 0) {
      return;
    }

    visited[startY][startX] = true;
    for (int[] coordinate : DIRECTION) {
      int dx = startX + coordinate[0];
      int dy = startY + coordinate[1];

      dfs(grid, visited, dx, dy);
    }
  }

  static boolean validateValue(int w, int h, int[][] grid) {

    if(w < 0 || h < 0) {
      return false;
    }

    if(w > 50 || h > 50) {
      return false;
    }

    if(h > grid.length - 1) {
      return false;
    }

    if(w > grid[0].length - 1) {
      return false;
    }

    return true;
  }

  static List<String> findStartCoordinate(int[][] grid) {
    List<String> lists = new ArrayList<>();
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          lists.add(String.format("%d,%d", j, i));
        }
      }
    }
    return lists;
  }

  static boolean checkRedundantElement(List<boolean[][]> lists, boolean[][] visited) {
    boolean[][] temp = new boolean[visited.length][visited[0].length];
    if(Arrays.deepEquals(temp, visited)) {
      return false;
    }

    for(boolean[][] arr : lists) {
      if(Arrays.deepEquals(arr, visited)) {
        return false;
      }
    }
    return true;
  }

  static int[][] convertBooleanArrayToIntgerArray(boolean[][] booleanArr) {
    int[][] intArr = new int[booleanArr.length][booleanArr[0].length];
    for (int i = 0; i < booleanArr.length; i++) {
      for (int j = 0; j < booleanArr.length; j++) {
        if (booleanArr[i][j]) {
          intArr[i][j] = 1;
        }
      }
    }
    return intArr;
  }
}
