package PS_2022.BOJ.Prefix_Sum.구간_합_구하기5_11660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/11660
 * 알고리즘: 누적합
 * 시간복잡도: O(m*n), m=100,000(합을 구해야 하는 횟수), n=1,024(표의 크기)
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                board[i][j] += board[i][j - 1];
            }
        }

        StringBuilder sb = new StringBuilder();
        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            int res = 0;
            for(int i = r1; i <= r2; i++) {
                res += board[i][c2] - board[i][c1 - 1];
            }
            sb.append(res + "\n");
        }
        System.out.println(sb.toString());
    }
}
