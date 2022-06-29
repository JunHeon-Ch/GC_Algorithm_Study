package PS_2021.프로그래머스.level3.정수_삼각형;

/*
https://programmers.co.kr/learn/courses/30/lessons/43105
 * 알고리즘: DP
 * 점화식: D[i][j] = max(D[i - 1][j - 1], D[i - 1][j]) + triangle[i][j]
 * 시간복잡도: O(n^2) n: 500
 */
class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        int[][] d = new int[n][n];
        d[0][0] = triangle[0][0];
        int answer = 0;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                // 가장 좌측
                if(j == 0) d[i][j] = d[i - 1][j];
                // 가장 우측
                else if(j == i) d[i][j] = d[i - 1][j - 1];
                else d[i][j] = Math.max(d[i - 1][j - 1], d[i - 1][j]);
                d[i][j] += triangle[i][j];
                if(i == n - 1) answer = Math.max(answer, d[i][j]);
            }
        }
        return answer;
    }
}