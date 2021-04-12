package algo_12869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // 9, 3, 1
    static int[] dx = {9, 3, 1};
    static int[][][] d = new int[61][61][61];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] scv = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            scv[i] = Integer.parseInt(st.nextToken());
        }
        for (int k[][] : d) {
            for (int[] z : k) {
                Arrays.fill(z, -1);
            }
        }
        System.out.println(dp(scv[0], scv[1], scv[2]));

    }

    static int dp(int a, int b, int c) {
        if (a < 0) return dp(0, b, c);
        if (b < 0) return dp(a, 0, c);
        if (c < 0) return dp(a, b, 0);
        if (a == 0 && b == 0 && c == 0) return 0;
        if (d[a][b][c] != -1) return d[a][b][c];
        int ans = 10000000;

        if (ans > dp(a - 1, b - 3, c - 9)) {
            ans = dp(a - 1, b - 3, c - 9);
        }
        if (ans > dp(a - 1, b - 9, c - 3)) {
            ans = dp(a - 1, b - 9, c - 3);
        }
        if (ans > dp(a - 3, b - 1, c - 9)) {
            ans = dp(a - 3, b - 1, c - 9);
        }
        if (ans > dp(a - 3, b - 9, c - 1)) {
            ans = dp(a - 3, b - 9, c - 1);
        }
        if (ans > dp(a - 9, b - 3, c - 1)) {
            ans = dp(a - 9, b - 3, c - 1);
        }
        if (ans > dp(a - 9, b - 1, c - 3)) {
            ans = dp(a - 9, b - 1, c - 3);
        }
        ans++;
        d[a][b][c] = ans;
        return d[a][b][c];

    }
}
