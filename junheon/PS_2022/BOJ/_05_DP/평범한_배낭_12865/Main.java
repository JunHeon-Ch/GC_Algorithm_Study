package PS_2022.BOJ._05_DP.평범한_배낭_12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/12865
 * 알고리즘: DP
 * 점화식: D[i][j] = max(D[i - 1][j], D[i - 1][j - w[i]] + v[i]), 1 <= i <= n, 1 <= j <= k
 * 시간복잡도: O(nk), n=100(물품 수), k=100,000(버틸 수 있는 무게)
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] w = new int[n + 1];
        int[] v = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        int[][] d = new int[n + 1][k + 1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= k; j++) {
                d[i][j] =  d[i - 1][j];
                if(j - w[i] >= 0) d[i][j] = Math.max(d[i - 1][j], d[i - 1][j - w[i]] + v[i]);
            }
        }
        System.out.println(d[n][k]);
    }
}
