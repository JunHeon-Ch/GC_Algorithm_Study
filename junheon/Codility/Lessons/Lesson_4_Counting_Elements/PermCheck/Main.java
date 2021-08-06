package Codility.Lessons.Lesson_4_Counting_Elements.PermCheck;

import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        Arrays.sort(A);
        int ans = 1;
        for(int i = 0; i < A.length; i++) {
            if(A[i] != i + 1) {
                ans = 0;
                break;
            }
        }
        return ans;
    }
}
