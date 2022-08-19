package PS_2022.BOJ.Bruth_Force.꽃길_14620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/14620
 * 알고리즘: 완전탐색
 * 시간복잡도: O(n^3), n=10(화단의 한 변의 길이)
 */

public class Main {

    static int n;
    static int[][] cost;
    static boolean[][] visit;
    static int ans = Integer.MAX_VALUE;
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        cost = new int[n][n];
        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, 0);
        System.out.println(ans);
    }

    static void solve(int res, int cnt) {
        if (cnt == 3) {
            ans = Math.min(ans, res);
            return;
        }

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                int k;
                for(k = 0; k < 5; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(visit[nx][ny]) break;

                }
                if(k != 5) continue;

                int val = 0;
                for(k = 0; k < 5; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    visit[nx][ny] = true;
                    val += cost[nx][ny];
                }
                solve(res + val, cnt + 1);
                for(k = 0; k < 5; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    visit[nx][ny] = false;
                }
            }
        }
    }
}
