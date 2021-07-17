package 기초.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no14501 {
    public static int n;
    public static int[] T;
    public static int[] P;
    public static int[] dp;
    public static int maxBene;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        T = new int[n+1];
        P = new int[n+1];
        dp = new int[n+1];

        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        maxBene = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            maxBenefit(i, 0);
        }
        System.out.println(maxBene);
    }
    public static void maxBenefit(int start, int sum) {

        if(start >= n){
            maxBene = Math.max(sum, maxBene);
            return;
        }
        if(start + T[start] <= n)
            maxBenefit(start+T[start], sum + P[start]);
        else
            maxBenefit(start+T[start], sum);

        maxBenefit(start+1, sum);
    }
}
