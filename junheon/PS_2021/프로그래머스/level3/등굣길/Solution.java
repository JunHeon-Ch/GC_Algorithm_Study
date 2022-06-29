package PS_2021.프로그래머스.level3.등굣길;

/*
https://programmers.co.kr/learn/courses/30/lessons/42898
 * 알고리즘: DP
 * D(i, j): (i, j)까지 올 수 있는 경우의 수
 * d[i][j] = d[i - 1][j] + d[i][j - 1], 1<=i<=n, 1<=j<=n
 * 시간복잡도: O(n*m), n=100, m=100
 */

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] d = new int[n+1][m+1];
        int MOD = 1000000007;
        for(int[] p : puddles) {
            d[p[1]][p[0]] = -1;
        }
        d[1][1] = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(i == 1 && j == 1) continue;
                if(d[i][j] == -1) {
                    d[i][j] = 0;
                    continue;
                }
                d[i][j] = d[i - 1][j] + d[i][j - 1];
                d[i][j] %= MOD;
            }
        }
        return d[n][m];
    }
}