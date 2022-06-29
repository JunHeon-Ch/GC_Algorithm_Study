// Top-down
// D(n) = 행렬 n개의 크기가 주어졌을 때, 모든 행렬을 곱하는데 필요한 최소 곱셈 연산 수
// d[i][j] = min(d[i + 1][j], d[i][j - 1]) + r[i] * c[i] * c[j] (0 <= i < j < n)

package PS_2021.BOJ.코딩테스트.문제.DP.행렬_곱셈_순서_11049;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_fail {

    static int[] r;
    static int[] c;
    static long[][] d;

    public static long solve(int s, int e) {
        if(d[s][e] != 0) return d[s][e];
        if (e - s == 1) return d[s][e] = r[s] * c[s] * c[e];
        long min = Math.min(solve(s + 1, e) + r[s] * c[s] * c[e], solve(s, e - 1) + r[s] * r[e] * c[e]);
        if (d[s][e] == 0) return d[s][e] = min;
        else return d[s][e] = Math.min(d[s][e], min);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        r = new int[n];
        c = new int[n];
        d = new long[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            r[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        long ans = solve(0, n - 1);
        System.out.println(ans);
    }
}
