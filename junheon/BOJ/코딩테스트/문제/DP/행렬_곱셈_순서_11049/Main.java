// Bottom-up
// D(n) = 행렬 n개의 크기가 주어졌을 때, 모든 행렬을 곱하는데 필요한 최소 곱셈 연산 수
// d[i][j] = min(d[i][k] + d[k + 1][j] + r[i] * c[k] * c[j] (i <= k < j)) (0 <= i < j < n)

package BOJ.코딩테스트.문제.DP.행렬_곱셈_순서_11049;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] r = new int[n];
        int[] c = new int[n];
        long[][] d = new long[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            r[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        for (int k = 1; k < n; k++) {
            for (int i = 0; i + k < n; i++) {
                for (int j = i; j < i + k; j++) {
                    long mul = r[i] * c[j] * c[i + k];
                    if (d[i][i + k] == 0) {
                        d[i][i + k] = d[i][j] + d[j + 1][i + k] + mul;
                    } else {
                        d[i][i + k] = Math.min(d[i][i + k], d[i][j] + d[j + 1][i + k] + mul);
                    }
                }
            }
        }
        System.out.println(d[0][n - 1]);
    }
}
