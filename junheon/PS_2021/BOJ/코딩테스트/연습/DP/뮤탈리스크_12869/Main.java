// 정의: dp[i][j][k] : SCV의 체력이 i, j, k인 상태에서 모든 SCV를 파괴하기 위해 필요한 최소 공격 횟수
// 점화식: dp[i][j][k] = min( dp[i - 9][j - 3][k - 1], dp[i - 9][j - 1][k - 3], ... , dp[i - 1][j - 3][k - 9]) + 1

package PS_2021.BOJ.코딩테스트.연습.DP.뮤탈리스크_12869;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    // 0 -> 1, 2, 3
    // 1 -> 1, 3, 2
    // 2 -> 2, 1, 3
    // 3 -> 2, 3, 1
    // 4 -> 3, 1, 2
    // 5 -> 3, 2, 1
    static int[] h1 = new int[]{9, 9, 3, 3, 1, 1};
    static int[] h2 = new int[]{3, 1, 9, 1, 9, 3};
    static int[] h3 = new int[]{1, 3, 1, 9, 3, 9};
    static int[][][] d = new int[61][61][61];

    public static int attack(int i1, int i2, int i3) {
        if (i1 < 0) i1 = 0;
        if (i2 < 0) i2 = 0;
        if (i3 < 0) i3 = 0;

        if (d[i1][i2][i3] != -1) return d[i1][i2][i3];

        for (int i = 0; i < 6; i++) {
            if (i1 <= h1[i] && i2 <= h2[i] && i3 <= h3[i]) return d[i1][i2][i3] = 1;
        }

        d[i1][i2][i3] = 7 * 7 * 7;
        for (int i = 0; i < 6; i++) {
            d[i1][i2][i3] = Math.min(d[i1][i2][i3], attack(i1 - h1[i], i2 - h2[i], i3 - h3[i]) + 1);
        }
        return d[i1][i2][i3];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] scv = new int[3];
        for (int i = 0; i < n; i++) {
            scv[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        for (int i = 0; i <= 60; i++) {
            for (int j = 0; j <= 60; j++) {
                for (int k = 0; k <= 60; k++) {
                    d[i][j][k] = -1;
                }
            }
        }

        int ans = attack(scv[0], scv[1], scv[2]);
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}
