package 기초.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no1309 {
    public static int[][] lion;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        lion = new int[n+1][3];
        lion[1][0] = lion[1][1] = lion[1][2] = 1;
        for(int i=2; i<=n; i++){
            lion[i][0] = lion[i-1][0] + lion[i-1][1] + lion[i-1][2];
            lion[i][1] = lion[i-1][0] + lion[i-1][2];
            lion[i][2] = lion[i-1][0] + lion[i-1][1];

            lion[i][0] %= 9901;
            lion[i][1] %= 9901;
            lion[i][2] %= 9901;
        }

        int sum = 0;
        for(int i=0; i<3; i++)
            sum += lion[n][i];
        System.out.println(sum % 9901);
    }
}
