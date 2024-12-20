package org.study.programers.level_1.완주하지_못한_선수;

import java.util.Arrays;

class Solution {
  public String solution(String[] participant, String[] completion) {

//    List<String> listParticipant = new LinkedList<>(List.of(participant));
//
//    for(String name : completion) {
//      listParticipant.remove(name);
//    }

    Arrays.sort(participant);
    Arrays.sort(completion);

    for(int i = 0; i < completion.length; i++) {
      if (!participant[i].equals(completion[i])) {
        return participant[i];
      }
    }

    // 여기까지 왔으면 제일 participant 배열의 제일 마지막 엘리먼트
    return participant[participant.length - 1];
  }
}