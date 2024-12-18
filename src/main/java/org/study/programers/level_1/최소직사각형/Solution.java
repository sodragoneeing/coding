package org.study.programers.level_1.최소직사각형;

class Solution {
  public int solution(int[][] sizes) {
    int resultW = 0;
    int resultH = 0;

    for(int i = 0; i < sizes.length; i++) {
      sizes[i] = compareSwap(sizes[i][0], sizes[i][1]);
      if(sizes[i][0] >= resultW) {
        resultW = sizes[i][0];
      }

      if(sizes[i][1] >= resultH) {
        resultH = sizes[i][1];
      }
    }

    return resultW * resultH;
  }

  private int[] compareSwap(int w, int h) {
    if(w > h) {
      return new int[]{h, w};
    }
    return new int[]{w, h};
  }
}