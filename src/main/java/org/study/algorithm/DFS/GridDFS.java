package org.study.algorithm.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class GridDFS {

  /*
   *
   * 입력 정보
   *
   * 4 5
   * 1 1 0 0 0
   * 1 0 1 0 0
   * 0 1 1 0 0
   * 0 0 0 1 0
   *
   * 결과 정보
   * 0, 0
   * 1, 0
   * 0, 1
   *
   */

  static int row;
  static int column;
  static int[][] grid;
  static boolean[][] visited;
  static int[][] result;
  static List<String> directionOrder;
  static int[] DIRECTION_X = {-1, 1, 0, 0};
  static int[] DIRECTION_Y = {0, 0, 1, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    // 그리드 크기 입력
    row = Integer.parseInt(stringTokenizer.nextToken());
    column = Integer.parseInt(stringTokenizer.nextToken());

    // 그리드 입력
    grid = new int[row][column];
    for(int i = 0; i < row; i++) {
      stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      for(int j = 0; j < column; j++) {
        grid[i][j] = Integer.parseInt(stringTokenizer.nextToken());
      }
    }

    printGrid(row, column, grid);

    visited = new boolean[row][column];
    result = new int[row][column];
    directionOrder = new ArrayList<String>();
    dfs(grid, visited, 0, 0, result, directionOrder);

    printGrid(result.length, result[0].length, result);

    System.out.println("\n");
    for(String str : directionOrder) {
      System.out.println(str);
    }
  }

  static void dfs(int[][] grid, boolean[][] visited, int startX, int startY, int[][] result, List<String> order) {
    // x,y 범위 체크
    if(!validateCoordinate(startX, startY, grid)) {
      return;
    }

    // 방문 여부 확인 (방문 한 좌표면 종료
    if(visited[startX][startY]) {
      return;
    }

    // 좌표 내 방문 할 수 없는 좌표면 종료
    if(grid[startX][startY] == 0) {
      return;
    }

    // 좌표 경로 탐색 시작
    visited[startX][startY] = true;
    result[startX][startY] = 1;
    directionOrder.add(String.format("%d, %d", startX, startY));

    for(int i = 0; i < DIRECTION_X.length; i++) {
      int dx = startX + DIRECTION_X[i];
      int dy = startY + DIRECTION_Y[i];

      dfs(grid, visited, dx, dy, result, directionOrder);
    }
  }

  static void printGrid(int row, int column, int[][] grid) {
    System.out.println(String.format("row : %d", row));
    System.out.println(String.format("colum : %d", column));
    for(int i = 0; i < row; i++) {
      for(int j = 0; j < column; j++) {
        System.out.print(grid[i][j] + " ");
      }
      System.out.print("\n");
    }
  }

  static boolean validateCoordinate(int x, int y, int[][] grid) {
    if(x < 0 || y < 0) {
      return false;
    }

    if(x >= grid.length - 1 || y > grid[0].length - 1) {
      return false;
    }

    return true;
  }
}
