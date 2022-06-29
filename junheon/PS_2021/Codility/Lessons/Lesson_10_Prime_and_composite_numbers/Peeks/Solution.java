package PS_2021.Codility.Lessons.Lesson_10_Prime_and_composite_numbers.Peeks;

import java.util.*;

class Solution {
    public int solution(int[] A) {
        if(A.length < 3) return 0;

        List<Integer> peeks = new ArrayList<>();
        for(int i = 1; i < A.length - 1; i++) {
            if(A[i] > A[i - 1] && A[i] > A[i + 1]) {
                peeks.add(i);
            }
        }
        if(peeks.size() < 2) return 1;

        int max = peeks.get(0) + 1;
        max = Math.max(max, A.length - peeks.get(peeks.size() - 1));
        int ans = 1;
        for(int k = max; k <= A.length / 2; k++) {
            if(A.length % k != 0) continue;
            int minIdx = 0;
            int maxIdx = k;
            int j = 0;
            while(maxIdx <= A.length) {
                while(j < peeks.size() && peeks.get(j) >= minIdx && peeks.get(j) < maxIdx)
                    j++;
                if(j == peeks.size()) break;
                minIdx = maxIdx;
                maxIdx += k;
            }
            if(maxIdx == A.length && j == peeks.size()) {
                ans = A.length / k;
                break;
            }
        }
        return ans;
    }
}
