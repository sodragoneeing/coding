package org.study.programers.level_3.wordConvert;


public class main {
  public static void main(String[] args) {
    Solution solution = new Solution();

    String begin = "hit";
    String target = "cog";

    String[] words_1 = {"hot", "dot", "dog", "lot", "log", "cog"};
    String[] words_2 = {"hot", "dot", "dog", "lot", "log"};

    System.out.println(solution.solution(begin, target, words_1));
    System.out.println(solution.solution(begin, target, words_2));
  }
}
