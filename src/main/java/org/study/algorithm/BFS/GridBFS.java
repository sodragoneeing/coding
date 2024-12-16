package org.study.algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class GridBFS {
  /*
   *
   * 입력 정보
   *
   * 5 5
   * 1 0 1 1 1
   * 1 0 1 0 1
   * 1 1 1 0 1
   * 0 0 1 1 1
   * 1 1 1 0 1
   * 0 0
   * 4 4
   *
   * ※ 첫번 째 줄 외의 입력은 모두 간선 정보
   *
   * 결과 정보
   * BFS -> [1, 2, 3, 4]
   *
   */

  static int xSize;
  static int ySize;
  static int[][] grid;
  static int[] start;
  static int[] end;

  static int[][] DIRECTION = {{1,0}, {-1,0}, {0,1}, {0,-1}};

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    xSize = Integer.parseInt(stringTokenizer.nextToken());
    ySize = Integer.parseInt(stringTokenizer.nextToken());

    grid = new int[xSize][ySize];
    for(int i = 0; i < xSize; i++) {
      stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      for(int j = 0; j < ySize; j++) {
        grid[i][j] = Integer.parseInt(stringTokenizer.nextToken());
      }
    }

    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    start = new int[]{Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken())};

    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    end = new int[]{Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken())};

    List<int[]> lists = new ArrayList<>();
    int[][] dist = new int[grid[0].length][grid.length];
    bfsShortestPath(grid, start, end, lists, dist);

    int count = 0;
    for(int[] arr : lists) {
      System.out.println(count + " : " + Arrays.toString(arr) + " ");
      count++;
    }

    for(int i = 0; i < dist.length; i++) {
      for(int j = 0; j < dist[0].length; j++) {
        System.out.print(dist[i][j] + " ");
      }
      System.out.println();
    }


  }

  static void bfsShortestPath(int[][] grid, int[] start, int[] end, List<int[]> result, int[][] dist) {
    Queue<int[]> queue = new LinkedList<>();
    boolean[][] visited = new boolean[grid.length][grid[0].length];

    // 최초 시작 위치 큐에 넣기
    queue.add(new int[]{start[0], start[1]}); // {x, y, distance}
    result.add(new int[]{start[0], start[1]});
    visited[start[0]][start[1]] = true;

    while(!queue.isEmpty()) {
      int[] current = queue.poll();
      result.add(current);

      int curX = current[0];
      int curY = current[1];

      if(validatePosition(grid, visited, curX, curY)) {
        visited[curY][curX] = true;
      }


      if(curX == end[0] && curY == end[1]) {
        return;
      }

      for(int[] direction : DIRECTION) {
        int dx = curX + direction[0];
        int dy = curY + direction[1];

        if(validatePosition(grid, visited, dx, dy)) {
          queue.add(new int[]{dx, dy});
          dist[dy][dx] = dist[curY][curX] + 1;
          visited[dx][dy] = true;
        }
      }
    }
  }

  static boolean validatePosition(int[][] grid, boolean[][] visited, int x, int y) {
    if(x < 0 || y < 0 || x > grid[0].length - 1 || y > grid.length - 1) {
      return false;
    }

    if(grid[y][x] == 0 || visited[y][x]) {
      return false;
    }

    return true;
  }
}
