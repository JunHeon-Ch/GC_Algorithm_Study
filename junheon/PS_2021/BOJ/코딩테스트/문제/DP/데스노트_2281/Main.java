// Top-down
// D(n) = N개의 단어를 채울 때 남은 칸수의 최솟값
// 현재 줄에 이어 붙이냐, 다음 줄에 새로 쓰냐 나눠서 생각

package PS_2021.BOJ.코딩테스트.문제.DP.데스노트_2281;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int n, m;
    public static int[][] d;
    public static int[] word;

    public static int solve(int i, int c) {
        if (i == n) return 0;
        if (d[i][c] != -1) return d[i][c];
        // 다음 줄에 쓰는 경우
        d[i][c] = solve(i + 1, word[i]) + (int) Math.pow(m - c, 2);
        // 현재 줄에 이어 쓰는 경우
        if (c + word[i] + 1 <= m) d[i][c] = Math.min(d[i][c], solve(i + 1, c + word[i] + 1));
        return d[i][c];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        word = new int[n];
        for (int i = 0; i < n; i++) {
            word[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        d = new int[n][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                d[i][j] = -1;
            }
        }
        System.out.println(solve(1, word[0]));
    }
}
