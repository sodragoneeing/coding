package org.study.programers.level_2.타겟_넘버;

public class main {
  static int[] numbers;
  static int target;
  public static void main(String[] args) {


    Solution_DFS solutionDFS = new Solution_DFS();
    Solution_BFS solutionBfs = new Solution_BFS();

    numbers = new int[] {1, 1, 1, 1, 1};
    target = 3;

    System.out.printf("DFS : %d", solutionDFS.solution(numbers, 3));
    System.out.printf("BFS : %d", solutionBfs.solution(numbers, 3));

  }
}
