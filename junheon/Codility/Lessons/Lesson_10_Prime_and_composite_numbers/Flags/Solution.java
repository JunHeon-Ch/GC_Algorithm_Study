package Codility.Lessons.Lesson_10_Prime_and_composite_numbers.Flags;

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
        if(peeks.size() <= 2) return peeks.size();

        int max = (int) Math.sqrt(peeks.get(peeks.size() - 1) - peeks.get(0)) + 1;
        int ans = 0;
        for(int k = max; k > 2; k--) {
            if(peeks.get(peeks.size() - 1) - peeks.get(0) < k * (k - 1))
                continue;
            int cur = 0;
            int flag = 1;
            int i = 1;
            // k - flag -> 꽂아야되는 깃발 갯수
            // peeks.size() - i -> 남은 peek 수
            while(i < peeks.size() && k > flag && k - flag <= peeks.size() - i) {
                if(Math.abs(peeks.get(cur) - peeks.get(i)) >= k) {
                    flag++;
                    cur = i;
                }
                i++;
            }
            if(flag >= k) {
                ans = flag;
                break;
            }
        }
        return ans;
    }
}