package PS_2022.BOJ._05_DP.스티커_9465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/9465
 * 알고리즘: DP
 * 시간복잡도: O(n), n=100,000(스티커의 수)
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] num = new int[2][n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                num[0][i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                num[1][i] = Integer.parseInt(st.nextToken());
            }
            int[][] d = new int[2][n + 1];
            d[0][1] = num[0][1];
            d[1][1] = num[1][1];
            for(int i = 2; i <= n; i++) {
                d[0][i] = Math.max(d[1][i - 2], d[1][i - 1]) + num[0][i];
                d[1][i] = Math.max(d[0][i - 2], d[0][i - 1]) + num[1][i];
            }
            sb.append(Math.max(d[0][n], d[1][n]) + "\n");
        }
        System.out.println(sb.toString());
    }
}
