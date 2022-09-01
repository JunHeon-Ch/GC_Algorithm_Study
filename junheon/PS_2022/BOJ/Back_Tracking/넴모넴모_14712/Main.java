package PS_2022.BOJ.Back_Tracking.넴모넴모_14712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/14712
 * 알고리즘: 완전탐색
 * 시간복잡도: O(n^2), n=25(행의 개수, 열의 개수)
 */

public class Main {

    static int n, m;
    static boolean[][] board;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new boolean[n][m];

        solve(0, 0);
        System.out.println(ans);
    }

    static void solve(int r, int c) {
        if(c == m) {
            r++;
            c = 0;
        }
        if(r == n) {
            ans++;
            return;
        }
        if (r <= 0 || c <= 0 || !board[r - 1][c] || !board[r][c - 1] || !board[r - 1][c - 1]) {
            board[r][c] = true;
            solve(r, c + 1);
        }
        board[r][c] = false;
        solve(r, c + 1);
    }
}
