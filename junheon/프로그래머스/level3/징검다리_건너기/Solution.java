package 프로그래머스.level3.징검다리_건너기;

/*
https://programmers.co.kr/learn/courses/30/lessons/64062
 * 알고리즘: 이분탐색
 * 시간복잡도: O(m*logn), n=200,000,000(친구들의 수), m=200,000(stones 배열의 길이)
 */

class Solution {
    public int solution(int[] stones, int k) {
        int left = 1; // 최소 친구들의 수
        int right = 200000000; // 최대 친구들의 수
        int ans = 0;
        while(left <= right) {
            int mid = (left + right) / 2; // 현재 건너려고 하는 친구들의 수
            if (possible(stones, k, mid)) { // 건널 수 있는지 확인
                left = mid + 1;
                ans = Math.max(ans, mid);
            } else right = mid - 1;
        }
        return ans;
    }

    // 연속된 k개 디딤돌이 mid보다 작으면 건널 수 없음
    public boolean possible(int[] stones, int k, int n) {
        int cnt = 0;
        for(int s : stones) {
            if(s - n >= 0) cnt = 0;
            else cnt++;
            if(cnt == k) return false;
        }
        return true;
    }
}