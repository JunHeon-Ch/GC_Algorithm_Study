// Top-down
// D(s, a, b, c) : 곡이 s개 남고 A, B. C가 각각 a, b, c 곡 남았을 때의 경우의 수

package PS_2021.BOJ.코딩테스트.문제.DP.Acka_12996;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int MOD = 1000000007;
    static long[][][][] d;
    static int S;

    public static long solve(int s, int a, int b, int c) {
        if (s == S) {
            if (a == 0 && b == 0 && c == 0) return 1;
            else return 0;
        }
        if (d[s][a][b][c] != -1) return d[s][a][b][c];
        d[s][a][b][c] = 0;
        if (a > 0) d[s][a][b][c] += solve(s + 1, a - 1, b, c);
        if (b > 0) d[s][a][b][c] += solve(s + 1, a, b - 1, c);
        if (c > 0) d[s][a][b][c] += solve(s + 1, a, b, c - 1);
        if (a > 0 && b > 0) d[s][a][b][c] += solve(s + 1, a - 1, b - 1, c);
        if (a > 0 && c > 0) d[s][a][b][c] += solve(s + 1, a - 1, b, c - 1);
        if (b > 0 && c > 0) d[s][a][b][c] += solve(s + 1, a, b - 1, c - 1);
        if (a > 0 && b > 0 && c > 0) d[s][a][b][c] += solve(s + 1, a - 1, b - 1, c - 1);
        return d[s][a][b][c] %= MOD;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        d = new long[S + 1][S + 1][S + 1][S + 1];
        for (int i = 0; i <= S; i++) {
            for (int j = 0; j <= S; j++) {
                for (int k = 0; k <= S; k++) {
                    for (int l = 0; l <= S; l++) {
                        d[i][j][k][l] = -1;
                    }
                }
            }
        }
        long ans = solve(0, A, B, C);
        System.out.println(ans);
    }
}
