package org.study.softeer.level_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class VehicleTestByCombination {
  /*
   *
   * 문제 출처 : Softeer
   * 문제 이름 : 자동차 테스트
   * 추가 설명 : 콤비네이션으로 해결
   *
   * 입력 예제
   * 5 3
   * 5 2 3 1 6
   * 1
   * 3
   * 6
   *
   * 출력 예제
   * 0
   * 4
   * 0
   *
   *********************************
   *
   * 입력 예제
   * 6 8
   * 7 4 3 2 6 1
   * 1
   * 2
   * 3
   * 4
   * 5
   * 6
   * 7
   * 1000000000
   *
   * 출력 예제
   * 0
   * 4
   * 6
   * 6
   * 0
   * 4
   * 0
   * 0
   *
   */

  public static void main(String[] args) {
    int n = 0; // 자동차 대수
    int q = 0; // 질의 개수
    String[] fuelEfficiency;
    List<List<Integer>> combinations = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);
    String[] inputNQ = scanner.nextLine().split(" ");
    String inputFuelEfficiency = scanner.nextLine();

    n = Integer.parseInt(inputNQ[0]);
    q = Integer.parseInt(inputNQ[1]);

    fuelEfficiency = inputFuelEfficiency.split(" ");
    generateCombinations(fuelEfficiency, 3, 0, new ArrayList<>(), combinations);

    // 기대값 계산
    for(int i = 0; i < q; i++) {
      int expectedValue = Integer.parseInt(scanner.nextLine());

      int count = 0;
      for (List<Integer> combination : combinations) {
        if(compareCentralValue(combination, expectedValue)) {
          count++;
        }
      }

      System.out.println(count);
    }
  }

  // 재귀적으로 조합을 생성
  private static void generateCombinations(
      String[] elements, int n, int start, List<Integer> current, List<List<Integer>> result) {
    if (current.size() == n) {
      result.add(new ArrayList<>(current)); // 조합을 저장
      return;
    }
    for (int i = start; i < elements.length; i++) {
      current.add(Integer.parseInt(elements[i])); // 원소 추가
      generateCombinations(elements, n, i + 1, current, result); // 다음 원소 선택
      current.removeLast(); // 원소 제거 (백트래킹)
    }
  }

  private static boolean compareCentralValue(List<Integer> lists, int value) {
    if(!lists.contains(value))
      return false;

    Collections.sort(lists);
    return value == lists.get(lists.size() / 2);
  }
}
