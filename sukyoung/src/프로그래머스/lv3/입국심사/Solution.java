package 프로그래머스.lv3.입국심사;

import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = binarySearch(n, times);
        return answer;
    }
    public long binarySearch(int n, int[] times){
        long left = 1, right = (long) times[times.length-1] * n;
        long ans = Long.MAX_VALUE;

        while(left <= right){
            long mid = (left + right) / 2;

            if(isOkay(times, n, mid)){
                if(ans > mid)
                    ans = mid;
                right = mid - 1;

            }
            else{
                left = mid + 1;
            }
        }
        return ans;
    }
    public boolean isOkay(int[] times, int n, long mid){
        long amount = 0;

        for(int i = 0 ; i < times.length ; ++i){
            amount += mid / times[i];
        }

        if(amount >= n) return true;
        else return false;
    }
}
