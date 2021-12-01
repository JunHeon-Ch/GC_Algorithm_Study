package 프로그래머스.level3.입국심사;

import java.util.*;


/*
https://programmers.co.kr/learn/courses/30/lessons/43238
 * 알고리즘: 이분탐색
 * 최소/최대 구하는 문제: 완전탐색, DP, Heap, 이분탐색

 * 기준: n명이 모두 심사를 받는데 걸리는 시간
 * 최소: 0 / 최대: (n*가장 오래 걸리는 심사관의 심사 시간)
 * 시간복잡도: O(m * log(n^2)) n: 10억, m: 10만
*/
class Solution {
    public long solution(int n, int[] times) {
        // 가장 오래 걸리는 심사관의 심사 시간을 찾기 위함
        Arrays.sort(times);
        // 최소 총 심사 시간
        long min = 0;
        // 최대 총 심사 시간
        long max = (long) n * times[times.length - 1];
        long mid;
        long ans = Long.MAX_VALUE;
        while(min <= max) {
            mid = (min + max) / 2;
            // mid 시간 동안 심사할 수 있는 최대 수
            long sum = 0;
            for(int i = 0; i < times.length; i++) {
                sum += mid / times[i];
                if(sum >= n) break;
            }
            if(sum < n) {
                min = mid + 1;
            } else {
                max = mid - 1;
                ans = Math.min(ans, mid);
            }
        }
        return ans;
    }
}