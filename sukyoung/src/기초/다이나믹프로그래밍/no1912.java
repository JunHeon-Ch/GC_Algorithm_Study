package 기초.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no1912 {
    public static int[] arr;
    public static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        dp[0] = arr[0];
        int max = arr[0];
        for(int i=1; i<n; i++){
            dp[i] = Math.max(dp[i-1] + arr[i] , arr[i]);
            max = Math.max(dp[i], max);
        }

        System.out.println(max);
    }
}
