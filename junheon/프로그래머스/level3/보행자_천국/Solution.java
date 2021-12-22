package 프로그래머스.level3.보행자_천국;

/*
https://programmers.co.kr/learn/courses/30/lessons/1832
 * 알고리즘: DP
 * D(i, j): (i-1, j)에서 아래로 올 수 있는 경로 + (i, j-1)에서 오른쪽으로 올 수 있는 경로
 * d[i][j][0] = d[i][j][1] = d[i - 1][j][0] + d[i][j - 1][1] (1<=i<=m, 1<=j<=n, 0:아래 방향, 1:오른쪽 방향)
 * 시간복잡도: O(n*m), n=500, m=500
 */

class Solution {
    int MOD = 20170805;

    public int solution(int m, int n, int[][] cityMap) {
        // 0 -> 아래, 1 -> 오른
        int[][][] d = new int[m + 1][n + 1][2];
        d[1][1][0] = d[1][1][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (cityMap[i - 1][j - 1] == 0) {
                    // d[i - 1][j][0] -> 위에서 아래방향
                    // d[i][j - 1][1] -> 왼쪽에서 오른쪽 방향
                    d[i][j][0] += (d[i - 1][j][0] + d[i][j - 1][1]) % MOD;
                    d[i][j][1] += (d[i - 1][j][0] + d[i][j - 1][1]) % MOD;
                } else if (cityMap[i - 1][j - 1] == 1) {
                    d[i][j][0] = d[i][j][1] = 0;
                } else if (cityMap[i - 1][j - 1] == 2) {
                    d[i][j][0] = d[i - 1][j][0];
                    d[i][j][1] = d[i][j - 1][1];
                }
            }
        }
        return d[m][n][0];
    }
}