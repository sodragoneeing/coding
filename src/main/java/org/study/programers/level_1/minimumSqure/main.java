package org.study.programers.level_1.minimumSqure;

public class main {
  public static void main(String[] args) {

    Solution solution = new Solution();

    int[][] size1 = new int[][] {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
    int[][] size2 = new int[][] {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
    int[][] size3 = new int[][] {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};

    System.out.println(solution.solution(size1));
    System.out.println(solution.solution(size2));
    System.out.println(solution.solution(size3));

  }
}
