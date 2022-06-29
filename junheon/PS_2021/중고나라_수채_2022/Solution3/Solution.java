package PS_2021.중고나라_수채_2022.Solution3;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    int[][] board;
    int n, m, c;
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public int solution(int[][] board, int c) {
        this.board = board;
        this.c = c;
        Point s = null;
        Point e = null;
        n = board.length;
        m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 2) {
                    s = new Point(i, j);
                    board[i][j] = 0;
                } else if (board[i][j] == 3) {
                    e = new Point(i, j);
                    board[i][j] = 0;
                }
            }
        }
        return solve(s, e);
    }

    public int solve(Point s, Point e) {
        Queue<Point> queue = new LinkedList<>();
        int[][] dist = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                dist[i][j] = -1;
            }
        }

        queue.add(s);
        dist[s.x][s.y] = 0;
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                int nd = dist[cur.x][cur.y] + 1;
                if(board[nx][ny] == 1) nd += c;

                if(dist[nx][ny] == -1 || nd < dist[nx][ny]) {
                    dist[nx][ny] = nd;
                    queue.add(new Point(nx, ny));
                }
            }
        }
        return dist[e.x][e.y];
    }
}

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}