//package PS_2021.프로그래머스.level2.프렌즈4블록;

import java.util.*;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

class Solution {

    static final int[] dx = {1, 1, 0};
    static final int[] dy = {0, 1, 1};

    public void bfs(Queue<Point> queue, char[][] board, boolean[][] check, int sx, int sy) {
        int m = board.length;
        int n = board[0].length;
        int i;
        Point[] next = new Point[3];
        for (i = 0; i < 3; i++) {
            int nx = sx + dx[i];
            int ny = sy + dy[i];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) break;
            if (board[nx][ny] != board[sx][sy]) break;
            next[i] = new Point(nx, ny);
        }
        if (i == 3) {
            if (!check[sx][sy]) {
                check[sx][sy] = true;
                queue.add(new Point(sx, sy));
            }
            for (int j = 0; j < 3; j++) {
                int nx = next[j].x;
                int ny = next[j].y;
                if (!check[nx][ny]) {
                    check[nx][ny] = true;
                    queue.add(next[j]);
                }
            }
        }
    }

    public int check4Block(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] check = new boolean[m][n];
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '-') continue;
                bfs(queue, board, check, i, j);
            }
        }
        int result = 0;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            board[p.x][p.y] = '-';
            result++;
        }
        return result;
    }

    public void dropBlock(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int j = 0; j < n; j++) {
            for (int i = m - 1; i > 0; i--) {
                if (board[i][j] == '-') {
                    int k = i;
                    while (k >= 0 && board[k][j] == '-') k--;
                    if (k == -1) break;
                    board[i][j] = board[k][j];
                    board[k][j] = '-';
                }
            }
        }
    }

    public int solution(int m, int n, String[] board) {
        char[][] gameBoard = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                gameBoard[i][j] = board[i].charAt(j);
            }
        }

        int answer = 0;
        while (true) {
            int result = check4Block(gameBoard);
            if (result == 0) break;
            else answer += result;
            dropBlock(gameBoard);
        }

        return answer;
    }
}
