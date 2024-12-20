package org.study.programers.level_1.완주하지_못한_선수;

public class Main {
  public static void main(String[] args) {

    Solution solution = new Solution();

    String[] participant1 = {"leo", "kiki", "eden"};
    String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
    String[] participant3 = {"mislav", "stanko", "mislav", "ana"};

    String[] completion1 = {"eden", "kiki"};
    String[] completion2 = {"josipa", "filipa", "marina", "nikola"};
    String[] completion3 = {"stanko", "ana", "mislav"};

    System.out.println(solution.solution(participant1, completion1));
    System.out.println(solution.solution(participant2, completion2));
    System.out.println(solution.solution(participant3, completion3));

  }
}
