package PS_2021.BOJ.코딩테스트.문제.브루트포스.파이프_옮기기2_17069;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] house = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][][] d = new long[n + 1][n + 1][3];
        d[1][2][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 3; j <= n; j++) {
                if (house[i][j] != 0) continue;
                d[i][j][0] = d[i][j - 1][0] + d[i][j - 1][2];
                if (i - 1 > 0) {
                    d[i][j][1] = d[i - 1][j][1] + d[i - 1][j][2];
                    if (house[i - 1][j] == 0 && house[i][j - 1] == 0) {
                        d[i][j][2] = d[i - 1][j - 1][0] + d[i - 1][j - 1][1] + d[i - 1][j - 1][2];
                    }
                }
            }
        }
        System.out.println(d[n][n][0] + d[n][n][1] + d[n][n][2]);
    }
}
