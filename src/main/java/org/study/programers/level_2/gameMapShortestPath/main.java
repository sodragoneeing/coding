package org.study.programers.level_2.gameMapShortestPath;

public class main {
  public static void main(String[] args) {
    Solution solution = new Solution();

    int[][] arr1 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
    int[][] arr2 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};

    System.out.println(solution.solution(arr1));
    System.out.println(solution.solution(arr2));

  }
}
