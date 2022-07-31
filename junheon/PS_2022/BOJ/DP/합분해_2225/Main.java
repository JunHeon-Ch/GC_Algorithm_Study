package PS_2022.BOJ.DP.합분해_2225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/2225
 * 알고리즘: DP
 * 점화식: d[i][j] += sum(d[i - 1][m], 0 <= m <= n), (1 <= i <= k, 1 <= j <= n)
 * 시간복잡도: O(nk), n=200, k=200
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] d = new int[n + 1];
        d[0] = 1;
        for(int j = 1; j <= k; j++) {
            for(int i = 1; i <= n; i++) {
                d[i] = (d[i] + d[i - 1]) % 1000000000;
            }
        }
        System.out.println(d[n]);
    }
}
