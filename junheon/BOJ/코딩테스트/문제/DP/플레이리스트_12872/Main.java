package BOJ.코딩테스트.문제.DP.플레이리스트_12872;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, P;
    static long d[][];
    static final int MOD = 1000000007;

    public static long solve(int p, int n) {
        if(p == P) {
            if(n == N) return 1;
            return 0;
        }
        if(d[p][n] != -1) return d[p][n];
        d[p][n] = 0;
        int r = N - n;
        if(r > 0) {
            d[p][n] += solve(p + 1, n + 1) * r;
        }
        if(n > M) {
            d[p][n] += solve(p + 1, n) * (n - M);
        }
        return d[p][n] %= MOD;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        d = new long[P + 1][N + 1];
        for(int i = 0; i <= P; i++) {
            for(int j = 0; j <= N; j++) {
                d[i][j] = -1;
            }
        }
        System.out.println(solve(0, 0));
    }
}
