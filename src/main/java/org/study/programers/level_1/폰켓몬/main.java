package org.study.programers.level_1.폰켓몬;

import java.util.Arrays;

public class main {
  public static void main(String[] args) {

    Solution solution = new Solution();

    int[] arr1 = new int[] {3, 1, 2, 3};
    int[] arr2 = new int[] {3, 3, 3, 2, 2, 4};
    int[] arr3 = new int[] {3, 3, 3, 2, 2, 2};

    System.out.println(solution.solution(arr1));
    System.out.println(solution.solution(arr2));
    System.out.println(solution.solution(arr3));
  }
}
