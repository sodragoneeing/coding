package org.study.programers.level_3.단어_변환;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
  public int solution(String begin, String target, String[] words) {
    if(!validate(target, begin, words)) {
      return 0;
    }

    return bfs(0, begin, target, words);
  }

  private int bfs(int start, String begin, String target, String[] words) {
    int count = 0;
    Queue<String> queue = new LinkedList<>();
    boolean[] visited = new boolean[words.length];

    queue.offer(begin);

    while(!queue.isEmpty()) {
      for(int j = 0; j < queue.size(); j++) {
        String current = queue.poll();

        if(current.equals(target)) {
          return count;
        }

        for(int i = 0; i < words.length; i++) {
          if(!visited[i]) {
            if(countCompareWord(current, words[i])) {
              visited[i] = true;
              queue.offer(words[i]);
            }
          }
        }
      }
      count++;
    }

    return count;
  }

  private boolean validateLowerCaseAndLength(String word) {
    // 소문자만 허용
    for(int i = 0 ; i < word.length(); i++) {
      if(!Character.isLowerCase(word.charAt(i))) {
        return false;
      }
    }

    // 문자열 길이 확인
    if(!(word.length() >= 3 && word.length() <= 10)) {
      return false;
    }

    return true;
  }
  private boolean validate(String target, String begin, String[] words) {
    //begin validation
    if(!validateLowerCaseAndLength(begin)) {
      return false;
    }

    if(!validateLowerCaseAndLength(target)) {
      return false;
    }

    for(String word : words) {
      if(!validateLowerCaseAndLength(word)) {
        return false;
      }
    }

    int targetCount = 0;
    for(String word : words) {
      if(word.equals(target)) {
        targetCount++;
      }
    }
    if(targetCount == 0) {
      return false;
    }

    if(!(words.length >= 3 && words.length < 50)) {
      return false;
    }

    if(begin.equals(target)) {
      return false;
    }

    return true;
  }
  private boolean countCompareWord(String target, String begin) {
    int count = 0;
    for(int i = 0; i < target.length(); i++) {
      if(target.charAt(i) != begin.charAt(i)) {
        count++;
      }
    }

    return count == 1;
  }
}