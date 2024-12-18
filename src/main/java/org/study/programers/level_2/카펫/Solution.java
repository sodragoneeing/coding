package org.study.programers.level_2.카펫;

class Solution {
  public int[] solution(int brown, int yellow) {
    int[] yellowGrid = findMinimunYelloSquareLength(yellow, brown);

    return new int[]{yellowGrid[0] + 2, yellowGrid[1] + 2};
  }

  private int[] findMinimunYelloSquareLength(int yellow, int brown) {
    int perimeter = yellow  * 2 + 2; // 최대 둘레
    int w = 0;
    int h = 0;
    for(int i = 1; i <= yellow; i++) {
      int varX = yellow / i;
      int varY = i;

      if(varX * varY != yellow) {
        continue;
      }

      if(perimeter >= varX * 2 + varY * 2) {
        perimeter = varX * 2 + varY * 2;

        if(brown - 4 == perimeter) {
          w = varX;
          h = varY;
        }
      }
    }

    if(w >= h) {
      return new int[]{w, h};
    }
    else {
      return new int[]{h, w};
    }
  }
}