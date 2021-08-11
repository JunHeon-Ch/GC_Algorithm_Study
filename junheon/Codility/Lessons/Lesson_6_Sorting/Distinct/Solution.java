package Codility.Lessons.Lesson_6_Sorting.Distinct;

import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        Arrays.sort(A);
        if(A.length == 0) return 0;
        int ans = 1;
        int prev = A[0];
        for(int i = 1; i < A.length; i++) {
            if(prev == A[i]) continue;
            else {
                ans++;
                prev = A[i];
            }
        }
        return ans;
    }
}
