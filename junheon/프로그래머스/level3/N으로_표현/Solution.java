package 프로그래머스.level3.N으로_표현;


/*
https://programmers.co.kr/learn/courses/30/lessons/42895
 * 알고리즘: 완전탐색
 * 시간복잡도: 4^8
 */

class Solution {

    int ans = -1;

    public void solve(int res, int depth, int N, int number) {
        if (depth > 8) return;
        if (res == number) {
            if (ans == -1 || ans > depth) {
                ans = depth;
                return;
            }
        }
        int n = 0;
        for (int i = 1; i <= 8; i++) {
            n = n * 10 + N;
            solve(res + n, depth + i, N, number);
            solve(res - n, depth + i, N, number);
            solve(res * n, depth + i, N, number);
            solve(res / n, depth + i, N, number);
        }
    }

    // N -> 사칙연산에 사용되는 수
    // number -> 표현할 수
    public int solution(int N, int number) {
        solve(0, 0, N, number);
        return ans;
    }
}