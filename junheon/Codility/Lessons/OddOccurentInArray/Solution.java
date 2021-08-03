package Codility.Lessons.OddOccurentInArray;

import java.util.*;

class Solution {
    public int solution(int[] A) {
        Arrays.sort(A);
        int ans = 0;
        for(int i = 0; i + 1 < A.length - 1; i += 2) {
            if(A[i] != A[i + 1]) {
                ans = A[i];
                break;
            }
        }
        if(ans == 0) ans = A[A.length - 1];
        return ans;
    }
}