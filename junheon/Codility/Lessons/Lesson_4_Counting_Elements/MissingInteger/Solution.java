package Codility.Lessons.Lesson_4_Counting_Elements.MissingInteger;

import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        int ans = 1;
        Arrays.sort(A);
        for(int i = 0; i < A.length; i++) {
            if(A[i] < ans) continue;
            else if(A[i] == ans) ans++;
            else if(A[i] > ans) break;
        }
        return ans;
    }
}
