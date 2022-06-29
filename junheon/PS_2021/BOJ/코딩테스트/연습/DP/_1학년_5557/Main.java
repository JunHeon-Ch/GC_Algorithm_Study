// D(n) = N개의 수가 주어졌을 때, 올바른 등식을 만들 수 있는 등식의 개수
// d[i][j] = d[i - 1][k] +- a[i] = j (0 <= k, j <= 20, 1 <= i <= n)

package PS_2021.BOJ.코딩테스트.연습.DP._1학년_5557;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;i < n - 1; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        int last = Integer.parseInt(st.nextToken());

        long[][] d = new long[n - 1][21];
        d[0][num[0]] = 1;
        for(int i = 1; i < n - 1; i++) {
            for(int j = 0; j <= 20; j++) {
                if(d[i - 1][j] > 0) {
                    int n1 = j + num[i];
                    int n2 = j - num[i];
                    if(n1 >= 0 && n1 <= 20) {
                        d[i][n1] += d[i - 1][j];
                    }
                    if(n2 >= 0 && n2 <= 20) {
                        d[i][n2] += d[i - 1][j];
                    }
                }
            }
        }
        System.out.println(d[n - 2][last]);
        br.close();
    }
}
