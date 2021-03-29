package algo_2294;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] num = new int[n];

        int[] dp = new int[100001]; // dp[i] = i를 만들기 위해 사용한 코인의 최소 개수
        Arrays.fill(dp, 100001);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(br.readLine());
            for (int j = num[i]; j <= k; j++) {
                dp[j] = Math.min(dp[j], dp[j - num[i]] + 1);
            }
        }


        if (dp[k] == 100001) System.out.println(-1);
        else System.out.println(dp[k]);


    }
}
