// Bottom-up
// D(n) = n개의 객차 중 3대의 소형 기관차로 운송할 수 있는 최대 손님 수
// i: 소형 기관차의 수, j: i번째 소형기관차가 끌려는 마지막 객차 번호
// d[i][j] = max(d[i][j - 1], d[i - 1][j - m] + sum[j] - sum[j - m])

package PS_2021.BOJ.코딩테스트.문제.DP.소형기관차_2616;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] p = new int[n + 1];
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + p[i];
        }
        int m = Integer.parseInt(br.readLine());

        int[][] d = new int[4][n + 1];
        for (int i = 1; i <= 3; i++) {
            for (int j = i * m; j <= n; j++) {
                d[i][j] = Math.max(d[i][j - 1], d[i - 1][j - m] + sum[j] - sum[j - m]);
            }
        }
        System.out.println(d[3][n]);
    }
}
