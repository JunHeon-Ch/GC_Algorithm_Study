package PS_2021.Codility.Lessons.Lesson_2_Arrays.CyclicRotation;

import java.util.*;

class Solution {
    public int[] solution(int[] A, int K) {
        int n = A.length;
        if(n == 0) return new int[0];
        int[] ans = Arrays.copyOf(A, A.length);

        for(int t = 0; t < K; t++) {
            int prev = ans[0], next;
            for(int i = 0; i < n; i++) {
                next = ans[(i + 1) % n];
                ans[(i + 1) % n] = prev;
                prev = next;
            }
        }

        return ans;
    }
}