package PS_2021.BOJ.코딩테스트.문제.브루트포스.게리맨더링2_17779;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, total = 0;
    static int[][] city;
    static int ans = Integer.MAX_VALUE;

    public static int solve(int d1, int d2, int x, int y) {
        int[] zone = new int[5];
        int[][] board = new int[N + 1][N + 1];
        for (int i = x, j = y; i <= x + d1 && j >= y - d1; i++, j--) {
            board[i][j] = 5;
        }
        for (int i = x, j = y; i <= x + d2 && j <= y + d2; i++, j++) {
            board[i][j] = 5;
        }
        for (int i = x + d1, j = y - d1; i <= x + d1 + d2 && j <= y - d1 + d2; i++, j++) {
            board[i][j] = 5;
        }
        for (int i = x + d2, j = y + d2; i <= x + d2 + d1 && j >= y + d2 - d1; i++, j--) {
            board[i][j] = 5;
        }
        for (int i = x + 1; i < x + d2 + d1; i++) {
            int j = 1;
            while (board[i][j] != 5) j++;
            while (board[i][++j] != 5) board[i][j] = 5;
        }

        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                if (board[r][c] == 5) continue;
                if (r < x + d1 && c <= y) {
                    zone[0] += city[r][c];
                } else if (r <= x + d2 && y < c) {
                    zone[1] += city[r][c];
                } else if (x + d1 <= r && c < y - d1 + d2) {
                    zone[2] += city[r][c];
                } else if (x + d2 < r && y - d1 + d2 <= c) {
                    zone[3] += city[r][c];
                }
            }
        }

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += zone[i];
            if(i == 4) zone[i] = total - sum;
            if (zone[i] < min) min = zone[i];
            if (zone[i] > max) max = zone[i];
        }
        return max - min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        city = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                total += city[i][j];
            }
        }

        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                for(int d1 = 1; d1 <= N; d1++) {
                    for(int d2 = 1; d2 <= N; d2++) {
                        if(r + d1 + d2 > N) continue;
                        if(c - d1 < 1 || c + d2 > N) continue;
                        int res = solve(d1, d2, r, c);
                        ans = Math.min(ans ,res);
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
