package org.study.backjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No_10974 {

  /*
   *
   * 입력 정보
   * 3
   *
   * 결과 정보
   * 1 2 3
   * 1 3 2
   * 2 1 3
   * 2 3 1
   * 3 1 2
   * 3 2 1
   *
   */

  static int n;
  static int[] elements;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    n = Integer.parseInt(scanner.nextLine());
    elements = createElement(n);

    List<List<Integer>> result = new ArrayList<>();
    generatePermutations(elements, n, n, new boolean[n], new ArrayList<>(), result);

    for(List<Integer> list : result) {
      for(int element : list) {
        System.out.print(element + " ");
      }
      System.out.println();
    }
  }

  static int[] createElement(int n) {
    int[] arr = new int[n];
    for(int i = 0; i < arr.length; i++) {
      arr[i] = i + 1;
    }

    return arr;
  }

  private static void generatePermutations(int[] elements, int n, int r, boolean[] visited,
      List<Integer> current, List<List<Integer>> permutations) {
    if (current.size() == r) {
      // 순열 완성
      permutations.add(new ArrayList<>(current));
      return;
    }

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        visited[i] = true;
        current.add(elements[i]);

        // 재귀 호출
        generatePermutations(elements, n, r, visited, current, permutations);

        // 백트래킹
        visited[i] = false;
        current.remove(current.size() - 1);
      }
    }
  }
}