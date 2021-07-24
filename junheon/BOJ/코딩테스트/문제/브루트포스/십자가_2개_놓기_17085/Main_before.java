package BOJ.코딩테스트.문제.브루트포스.십자가_2개_놓기_17085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_before {

    static int N, M;
    static char[][] board;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int ans = 0;

    public static void solve(int x, int y, int cnt, int area) {
        if (cnt == 2) {
            ans = Math.max(ans, area);
            return;
        }

        if(x == N) return;
        if (visit[x][y] || board[x][y] == '.') {
            if (y + 1 == M) solve(x + 1, 0, cnt, area);
            else solve(x, y + 1, cnt, area);
        }

        int size = 0;
        while (true) {
            int i;
            for (i = 0; i < 4; i++) {
                int nx = x + dx[i] * size;
                int ny = y + dy[i] * size;
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) break;
                if(visit[nx][ny]) break;
                if(board[nx][ny] != '#') break;
            }
            if (i == 4) {
                for(int k = 0; k <= size; k++) {
                    for(int j = 0; j < 4; j++) {
                        int nx = x + dx[j] * k;
                        int ny = y + dy[j] * k;
                        visit[nx][ny] = true;
                    }
                }
                if (y + 1 == M) solve(x + 1, 0, cnt + 1, area * (1 + 4 * size));
                else solve(x, y + 1, cnt + 1, area * (1 + 4 * size));
                size++;
            } else {
                for(int k = 0; k < size; k++) {
                    for(int j = 0; j < 4; j++) {
                        int nx = x + dx[j] * k;
                        int ny = y + dy[j] * k;
                        visit[nx][ny] = false;
                    }
                }
                break;
            }
        }
        if (y + 1 == M) solve(x + 1, y, cnt, area);
        else solve(x, y + 1, cnt, area);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            int j = 0;
            for (char c : br.readLine().toCharArray()) {
                board[i][j++] = c;
            }
        }
        solve(0, 0, 0, 1);
        System.out.println(ans);
    }
}
