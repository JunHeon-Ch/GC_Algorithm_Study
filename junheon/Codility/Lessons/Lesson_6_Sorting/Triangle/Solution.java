package Codility.Lessons.Lesson_6_Sorting.Triangle;

import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        if(A.length < 3) return 0;
        Arrays.sort(A);
        int ans = 0;
        for(int i = 2; i < A.length; i++) {
            if((long) A[i - 2] + A[i - 1] <= A[i]) continue;
            if((long) A[i - 2] + A[i] <= A[i - 1]) continue;
            if((long) A[i - 1] + A[i] <= A[i - 2]) continue;
            ans = 1;
            break;
        }
        return ans;
    }
}