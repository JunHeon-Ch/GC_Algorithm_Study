package PS_2022.BOJ._05_DP.동전_9084;

import java.io.*;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/9084
 * 알고리즘: DP
 * 점화식: D[i] = D[i] + D[i - a[j]] (a[j] <= i <= m, 0 <= j < n)
 * O(t*n*m), t=10(테스트케이스 수), n=20(동전 가지 수), m=10,000(만들어야 할 금액)
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] coin = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                coin[i] = Integer.parseInt(st.nextToken());
            }

            int m = Integer.parseInt(br.readLine());
            int[] d = new int[m + 1];
            d[0] = 1;
            for(int c : coin) {
                for(int i = c; i <= m; i++) {
                    d[i] += d[i - c];
                }
            }
            bw.write(d[m] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
