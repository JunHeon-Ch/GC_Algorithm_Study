package BOJ.코딩테스트.문제.브루트포스.미로_탈출하기_17090;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static char[][] board;
    static boolean[][] visit, success;

    public static boolean solve(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= M) return true;
        if (visit[x][y]) {
            if(success[x][y]) return true;
            else return false;
        }
        visit[x][y] = true;
        if (board[x][y] == 'R') {
            if (solve(x, y + 1)) success[x][y] = true;
        } else if (board[x][y] == 'L') {
            if (solve(x, y - 1)) success[x][y] = true;
        } else if (board[x][y] == 'U') {
            if (solve(x - 1, y)) success[x][y] = true;
        } else if (board[x][y] == 'D') {
            if (solve(x + 1, y)) success[x][y] = true;
        }
        return success[x][y];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            int j = 0;
            for (char c : br.readLine().toCharArray()) {
                board[i][j++] = c;
            }
        }
        visit = new boolean[N][M];
        success = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visit[i][j]) continue;
                boolean a = solve(i, j);
            }
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(success[i][j]) ans++;
            }
        }
        System.out.println(ans);
    }
}
