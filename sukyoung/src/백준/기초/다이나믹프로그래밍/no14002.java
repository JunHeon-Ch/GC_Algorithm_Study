package 기초.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no14002 {
    public static int n;
    public static int[] arr;
    public static int[] dp;
    public static int[] index;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        index = new int [n + 1];
        dp = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        int max = -1;
        for (int i = 0; i < n; i++) {
            if (max < dp[i])
                max = dp[i];
        }
        sb.append(max);
        sb.append('\n');
        for(int i=n-1; i>=0; i--) {
            if (dp[i] == max) {
                index[i] = arr[i];
                max--;
            }
        }
        Arrays.sort(index);
        for(int i=0; i<=n; i++)
            if(index[i] != 0)
                sb.append(index[i]+" ");
        System.out.println(sb);
    }
}
