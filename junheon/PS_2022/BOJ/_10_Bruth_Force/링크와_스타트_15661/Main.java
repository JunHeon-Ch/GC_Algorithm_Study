package PS_2022.BOJ._10_Bruth_Force.링크와_스타트_15661;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/15661
 * 알고리즘: 완전탐색
 * 시간복잡도: O(2^n), n=20(선수의 수)
 */

public class Main {

    static int n;
    static int[][] performance;
    static int[] team1, team2;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        performance = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                performance[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        team1 = new int[n];
        team2 = new int[n];
        solve(1, 0, 0);
        System.out.println(ans);
    }

    static void solve(int idx, int l, int r) {
        if(idx == n + 1) {
            if(l == 0 || r == 0) return;
            int val1 = 0, val2 = 0;
            for(int i = 0; i < l; i++) {
                for(int j = i + 1; j < l; j++) {
                    val1 += performance[team1[i]][team1[j]] + performance[team1[j]][team1[i]];
                }
            }
            for(int i = 0; i < r; i++) {
                for(int j = i + 1; j < r; j++) {
                    val2 += performance[team2[i]][team2[j]] + performance[team2[j]][team2[i]];
                }
            }
            ans = Math.min(ans, Math.abs(val1 - val2));
            return;
        }
        team1[l] = idx;
        solve(idx + 1, l + 1, r);
        team2[r] = idx;
        solve(idx + 1, l, r + 1);
    }
}
