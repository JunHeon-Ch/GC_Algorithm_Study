package PS_2021.NHN커머스_공채_2021._3;

import java.io.*;
import java.util.StringTokenizer;

class Main {

    static int n, m, k;
    static int[][] block;
    static boolean[][] visit;
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        block = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                block[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visit = new boolean[n][k + 1];
        solve(0, 0, 0);
        System.out.println(ans);
    }

    public static void solve(int index, int sum, int res) {
        if(sum > k) return;
        if (index == n) {
            ans = Math.max(ans, res);
            return;
        }
        for (int val = 0; val <= k; val++) {
            if (!visit[index][val]) {
                visit[index][val] = true;
                int now = res;
                if(val > 0 && val <= m) {
                    now += block[index][m - val];
                }
                solve(index + 1, sum + val, now);
                visit[index][val] = false;
            }
        }
    }
}