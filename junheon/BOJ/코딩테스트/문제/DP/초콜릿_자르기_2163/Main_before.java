// Bottom-up
// D(n, m) = (n, m) 크기의 초콜릿을 n * m개로 쪼개기 위한 최소 쪼개기 횟수
// d[n][m] = d[n][m - 1] + n

package BOJ.코딩테스트.문제.DP.초콜릿_자르기_2163;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_before {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] d = new int[n + 1][m + 1];
        d[1][1] = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(i == 1 && j == 1) continue;
                if(j == 1) d[i][j] = d[i - 1][j] + j;
                else d[i][j] = d[i][j - 1] + i;
            }
        }
        System.out.println(d[n][m]);
    }
}

