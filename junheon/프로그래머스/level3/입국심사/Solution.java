package 프로그래머스.level3.입국심사;

import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long left = 0;
        long right = (long) n * times[times.length - 1];
        long mid;
        long ans = Long.MAX_VALUE;
        while(left <= right) {
            mid = (left + right) / 2;
            long sum = 0;
            for(int i = 0; i < times.length; i++) {
                sum += mid / times[i];
                if(sum >= n) break;
            }

            if(sum < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
                ans = Math.min(ans, mid);
            }
        }
        return ans;
    }
}
