// Bottom-up
// 박스들 사이에 사이클이 이뤄진다면 사이클 내에 있는 모든 박스를 열 수 있다.
// n번째 박스를 열기 위해서는 n - 1개의 열쇠를 얻은 기존 사이클에 들어가거나, 혼자서 새로운 사이클을 구성하거나 2가지의 경우의 수가 생긴다.
// D(n, m) = n개의 열쇠를 m개의 폭탄을 사용하여 모두 얻을 수 있는 경우의 수
// d[i][j] = sum((i - 1) * d[i - 1][j] + d[i - 1][j - 1] 1 <= j <= i) (1 <= i <= n)
// (i - 1) * d[i - 1][j] -> 기존 사이클에 들어가는 경우
// d[i - 1][j - 1] -> 혼자 새로운 사이클을 구성하는 경우

package PS_2021.BOJ.코딩테스트.문제.DP.박스_안의_열쇠_1413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[][] d = new long[n + 1][n + 1];
        d[1][1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (i == 1 && j == 1) continue;
                d[i][j] = (i - 1) * d[i - 1][j] + d[i - 1][j - 1];
            }
        }

        for (int i = 1; i <= n; i++) {
            d[n][i] += d[n][i - 1];
        }
        long gcdn = gcd(d[n][m], d[n][n]);
        System.out.println(d[n][m] / gcdn + "/" + d[n][n] / gcdn);
    }
}
