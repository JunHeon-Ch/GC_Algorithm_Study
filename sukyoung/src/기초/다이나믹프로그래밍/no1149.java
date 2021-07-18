package 기초.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no1149 {
    public static int n;
    public static int[][] house;
    public static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        house = new int[n][3];
        dp = new int[n][3];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++)
                house[i][j] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<3; i++) {
            dp[0][i] = house[0][i];
        }

        System.out.println(Math.min(coloring(n-1, 0), Math.min(coloring(n-1, 1), coloring(n-1, 2))));
    }
    public static int coloring(int n, int color){

        if(dp[n][color] == 0){
            if(color == 0)
                dp[n][0] = Math.min(coloring(n-1, 1), coloring(n-1, 2)) + house[n][0];
            else if(color == 1)
                dp[n][1] = Math.min(coloring(n-1, 0), coloring(n-1, 2)) + house[n][1];
            else
                dp[n][2] = Math.min(coloring(n-1, 0), coloring(n-1, 1)) + house[n][2];
        }
        return dp[n][color];
    }
}

