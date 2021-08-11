package Codility.Lessons.Lesson_6_Sorting.MaxProductOfThree;

import java.util.*;

class Solution {
    public int solution(int[] A) {
        Arrays.sort(A);
        int n = A.length;
        int ans = Integer.MIN_VALUE;
        for(int i = n - 3; i >= 0; i--) {
            int res = A[i] * A[i + 1] * A[i + 2];
            ans = Math.max(ans, res);
        }
        return ans;
    }
}
