package 기초.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no11722 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[n];
        for(int i=n-1; i>=0; i--){
            dp[i] = 1;
            for(int j=n-1; j>i; j--){
                if(arr[i] > arr[j] && dp[j]+1 > dp[i]){
                    dp[i] = dp[j] + 1;
                }
            }
        }
        Arrays.sort(dp);
        System.out.println(dp[n-1]);
    }
}
