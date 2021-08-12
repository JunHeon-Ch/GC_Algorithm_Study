package Codility.Lessons.Lesson_6_Sorting.NumberOfDiscIntersections;

import java.util.*;

class Solution {
    public int solution(int[] A) {
        long[] lower = new long[A.length];
        long[] upper = new long[A.length];
        for(int i = 0; i < A.length; i++) {
            lower[i] = (long) i - A[i];
            upper[i] = (long) i + A[i];
        }
        Arrays.sort(lower);
        Arrays.sort(upper);
        int ans = 0;
        int j = 0;
        for(int i = 0; i < A.length; i++) {
            while(j < A.length && lower[j] <= upper[i]) {
                ans += j;
                ans -= i;
                j++;
            }
        }
        if(ans > 10000000) return -1;
        return ans;
    }
}
