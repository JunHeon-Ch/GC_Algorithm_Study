// Top-down
// D(s, e) = s부터 e까지 올바른 괄호 문자열의 수

package PS_2021.BOJ.코딩테스트.문제.DP.올바른_괄호_문자열_3012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final long MOD = 100000L;
    public static char[] input;
    public static long[][] d;
    public static boolean[][] c;

    public static long solve(int s, int e) {
        if (s > e) return 1;
        if (c[s][e]) return d[s][e];

        char[] open = "({[".toCharArray();
        char[] close = ")}]".toCharArray();
        for (int k = s + 1; k <= e; k += 2) {
            for (int i = 0; i < 3; i++) {
                if (input[s] == open[i] || input[s] == '?') {
                    if (input[k] == close[i] || input[k] == '?') {
                        d[s][e] += solve(s + 1, k - 1) * solve(k + 1, e);
                        if (d[s][e] >= MOD) d[s][e] = MOD + d[s][e] % MOD;
                        c[s][e] = true;
                    }
                }
            }
        }
        return d[s][e];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        input = str.toCharArray();
        d = new long[n][n];
        c = new boolean[n][n];
        long ans = solve(0, n - 1);
        if (ans >= MOD) System.out.println(String.format("%05d", ans - MOD));
        else System.out.println(ans);
    }
}
