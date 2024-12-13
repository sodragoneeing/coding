package org.study.programers.level_3.network;

public class main {
  public static void main(String[] args) {
    Solution solution = new Solution();

    int[][] computer1 = {{1,1,0}, {1,1,0}, {0,0,1}};
    System.out.println(solution.solution(3, computer1));

    int[][] computer2 = {{1,1,0}, {1,1,1}, {0,1,1}};
    solution.solution(3, computer1);
    System.out.println(solution.solution(3, computer2));

  }
}
