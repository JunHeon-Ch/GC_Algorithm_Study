package PS_2021.Codility.Lessons.Lesson_3_Time_Complexity.PremMissingElem;

import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        int n = A.length;
        Arrays.sort(A);
        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(A[i] != i + 1) {
                ans = i + 1;
                break;
            }
        }
        if(ans == 0) ans = n + 1;
        return ans;
    }
}
