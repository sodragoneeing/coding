package org.study.programers.level_1.mockTest;

import java.util.Arrays;

public class main {
  public static void main(String[] args) {

    Solution solution = new Solution();

    int[] size1 = new int[] {1,2};
    int[] size2 = new int[] {1,3,2,4,2};

    System.out.println(Arrays.toString(solution.solution(size1)));
    System.out.println(Arrays.toString(solution.solution(size2)));

  }
}
