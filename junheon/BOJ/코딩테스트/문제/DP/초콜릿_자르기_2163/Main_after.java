// Bottom-up
// D(n, m) = (n, m) 크기의 초콜릿을 n * m개로 쪼개기 위한 최소 쪼개기 횟수
// d[n][m] = d[n][m - 1] + n

package BOJ.코딩테스트.문제.DP.초콜릿_자르기_2163;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_after {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        System.out.println(n * m - 1);
    }
}

