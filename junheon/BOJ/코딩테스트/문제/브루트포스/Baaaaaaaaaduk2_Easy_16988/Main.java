package BOJ.코딩테스트.문제.브루트포스.Baaaaaaaaaduk2_Easy_16988;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int N, M;
    static int[][] board;
    static boolean[][] visit;
    static List<Point> blackList = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int cnt = 0, ans = 0;
    static boolean flag = false;

    public static void baduk(int x, int y) {
        visit[x][y] = true;
        cnt++;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if(board[nx][ny] == 0) flag = true;
            if(visit[nx][ny] || board[nx][ny] == 1) continue;
            baduk(nx, ny);
        }
    }

    public static void solve(int index, int x, int y) {
        if (index == 2) {
            int res = 0;
            visit = new boolean[N][M];
            for (Point point : blackList) {
                if(visit[point.x][point.y]) continue;
                flag = false;
                cnt = 0;
                baduk(point.x, point.y);
                if(!flag) res += cnt;
            }
            ans = Math.max(ans, res);
            return;
        }
        if (x == N) return;
        if (board[x][y] == 0) {
            board[x][y] = 1;
            if (y + 1 == M) {
                solve(index + 1, x + 1, 0);
            } else
                solve(index + 1, x, y + 1);
            board[x][y] = 0;
        }
        if (y + 1 == M) {
            solve(index, x + 1, 0);
        } else
            solve(index, x, y + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 2) blackList.add(new Point(i, j));
            }
        }
        solve(0, 0, 0);
        System.out.println(ans);
    }
}
