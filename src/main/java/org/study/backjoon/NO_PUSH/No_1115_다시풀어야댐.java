package org.study.backjoon.NO_PUSH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class No_1115_다시풀어야댐 {
  /*
    입력
    5
    2 0 1 4 3
    출력
    2
    -----------------------------

    입력
    3
    2 0 1
    출력
    0
    -----------------------------

    입력
    4
    2 3 0 1
    출력
    2
    -----------------------------

    입력
    6
    0 5 3 2 1 4
    출력
    3
   -----------------------------

    입력
    10
    4 2 6 0 3 5 9 7 8 1
    출력
    5

   */

  static int elementSize;
  static int[] elements;

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    // 순열 크기
    elementSize = Integer.parseInt(stringTokenizer.nextToken());

    // 순열 입력
    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    elements = new int[elementSize];
    for(int i = 0; i < elementSize; i++) {
      elements[i] = Integer.parseInt(stringTokenizer.nextToken());
    }

    List<List<Integer>> permutationResults = new ArrayList<>();
    generatePermutation(elements, new boolean[elementSize], new ArrayList<>(), permutationResults);

    int count = 0;
    for(List<Integer> lists : permutationResults) {
      if(compareParentAndChild(lists)) {
        count++;
      }
    }

    System.out.println(count);
  }

  static void printPermutationInfo(int[] arr) {
    System.out.printf("arr size : %d\n", arr.length);
    for (int element : arr) {
      System.out.printf("%d ", element);
    }
    System.out.printf("\n");
  }

  static int[] createdChildPermutation(int[] parent) {
    int[] child = new int[parent.length];

    // 자식 배열의 첫 번째는 무조건 0 이다.
    child[0] = 0;

    for(int i = 1; i < child.length; i++) {
      child[i] = parent[child[i - 1]];
    }

    return child;
  }

  static void generatePermutation(int[] elements, boolean[] visited, List<Integer> current,
      List<List<Integer>> resultPermutation) {

    // 순열 완성
    if(current.size() == elements.length) {

      // 완전 순열이 아닐 경우 종료
      for(int i = 0; i < current.size(); i++) {
        if(current.get(i) == i) {
//          resultPermutation.clear();
          return;
        }
      }

      resultPermutation.add(new ArrayList<>(current));
      return;
    }

    for(int i = 0; i < elements.length; i++) {
      if(!visited[i]) { // 방문 하지 않았으면
        visited[i] = true;
        current.add(elements[i]);

        //재귀 호출
        generatePermutation(elements, visited, current, resultPermutation);

        // 백트래킹
        visited[i] = false;
        current.removeLast();
      }
    }
  }

  static boolean compareParentAndChild(List<Integer> list) {
    int[] arr = list.stream().mapToInt(i->i).toArray();
    int[] arrChild = createdChildPermutation(arr);

    System.out.printf("parent : %s\t", Arrays.toString(arr));
    Arrays.sort(arr);
    System.out.printf("%s\n", Arrays.toString(arr));

    System.out.printf("child  : %s\t", Arrays.toString(arrChild));
    Arrays.sort(arrChild);
    System.out.printf("%s\t", Arrays.toString(arrChild));

//    Arrays.sort(arr);
//    Arrays.sort(arrChild);

    if(Arrays.equals(arr, arrChild)) {
      System.out.println("equal");
    }
    else {
      System.out.println("false");
    }

    return Arrays.equals(arr, arrChild);
  }
}
