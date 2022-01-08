package 프로그래머스.level3.외벽_점검;

/*
https://programmers.co.kr/learn/courses/30/lessons/60062
 * 알고리즘: 완전탄색
 * 시간복잡도: 구하기 귀찮음
 */

class Solution {

    int[] dist; // 기존 dist 배열
    int[] weak; // 기존 weak 배열
    int[][] totalWeak; // 한 칸씩 옮긴 weak 배열
    int[] seq; // 취약 지점으로 이동할 친구들의 순서를 저장한 배열 (각 친구가 1시간 동안 이동할 수 있는 거리가 들어있음 -> dist)
    boolean[] visit;
    int ans = -1, N;

    public int solution(int n, int[] weak, int[] dist) {
        this.dist = dist;
        this.weak = weak;
        N = n;
        setWeak(); // totalWeak 만드는 함수

        for(int i =  1; i <= dist.length; i++) {
            seq = new int[i];
            visit = new boolean[dist.length];
            // 1. 취약 지점으로 이동할 친구들의 순서를 만들고
            // 2. 그 친구들이 전체 외벽을 커버할 수 있는지 확인한다.
            solve(0, i);
        }
        return ans;
    }

    public void setWeak() {
        int n = weak.length;
        totalWeak = new int[n][n];
        for(int i = 0; i < n; i++) {
            int k = i;
            for(int j = 0; j < n; j++) {
                if(k >= n) totalWeak[i][j] = weak[k - n] + N;
                else totalWeak[i][j] = weak[k];
                k++;
            }
        }
    }

    //
    public boolean solve(int index, int n) {
        if(index == n) {
            if(check()) {
                if(ans == -1 || seq.length < ans) {
                    ans = seq.length;
                    return true;
                }
            }
            return false;
        }
        for(int i = 0; i < dist.length; i++) {
            if(visit[i]) continue;
            seq[index] = dist[i];
            visit[i] = true;
            if(solve(index + 1, n)) return true;
            visit[i] = false;
        }
        return false;
    }

    public boolean check() {
        for(int[] weak : totalWeak) {
            int start = 0;
            int cnt = 0;
            for(int k = 0; k < seq.length; k++) {
                int i = start;
                for(int j = start; j < weak.length; j++) {
                    if(weak[j] > weak[i] + seq[k]) break;
                    start++;
                    cnt++;
                }
            }
            if(cnt == weak.length) return true;
        }
        return false;
    }
}