package algo_1912;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[100000];
        int[] dp = new int[100000];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = num[0];
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            int temp = dp[i - 1] + num[i];
            if (temp >= num[i]) {
                dp[i] = temp;
            } else {
                dp[i] = num[i];
            }
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        bw.write(max+"\n");
        bw.flush();
        bw.close();


    }
}
