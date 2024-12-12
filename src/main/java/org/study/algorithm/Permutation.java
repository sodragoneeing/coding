package org.study.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Permutation {

  // Permutation : 순열 (nPr)
  // 문제) 1,2,3 중 3개 뽑기 (3P2)
  // ※ 순열 (중복 X) : 3P2 = 3!/(3-2)! = 6
  // ※ 순열 (중복 O) : 3ㅠ2 = 3^2 = 9
  // ※ 0! (0 팩토리알) = 1


  /*
   * 입력 :
   * 3 3
   * 1 2 3
   *
   *
   * 출력 :
   * 1 2 3
   * 1 3 2
   * 2 1 3
   * 2 3 1
   * 3 1 2
   * 3 2 1
   */


  static int n;
  static int r;
  static int[] elements;
  static boolean[] visited;
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    n = Integer.parseInt(stringTokenizer.nextToken());
    r = Integer.parseInt(stringTokenizer.nextToken());

    elements = new int[n];
    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    for(int i = 0; i < n; i++) {
      elements[i] = Integer.parseInt(stringTokenizer.nextToken());
    }

    List<List<Integer>> result = new ArrayList<>();
    generatePermutations(elements, n, r, new boolean[n], new ArrayList<>(), result);

    // 결과 출력
    for (List<Integer> permutation : result) {
      System.out.println(permutation);
    }
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
        current.removeLast();
      }
    }
  }
}