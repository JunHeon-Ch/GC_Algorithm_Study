package 프로그래머스.카카오.level2.프렌즈4블록;

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

    public int bfs(char[][] board, boolean[][] check, int sx, int sy) {
        int m = board.length;
        int n = board[0].length;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(sx, sy));
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            int i;
            Point[] next = new Point[3];
            for(i = 0; i < 3; i++) {
                int nx = p.getX() + dx[i];
                int ny = p.getY() + dy[i];
                if(nx < 0 || nx >= m || ny < 0 || ny >= n) break;
                if(board[nx][ny] != board[p.getX()][p.getY()]) break;
                next[i] = new Point(nx, ny);
            }
            if(i == 3) {
                check[p.x][p.y] = true;
                for(int j = 0; j < 3; j++) {
                    int nx = next[j].x;
                    int ny = next[j].y;
                    check[nx][ny] = true;
                    queue.add(next[j]);
                }
            }
        }

        return 0;
    }

    public void swap(char[][] board, int x1, int x2, int y) {
        char tmp = board[x1][y];
        board[x1][y] = board[x2][y];
        board[x2][y] = tmp;
    }

    public int solution(int m, int n, String[] board) {
        char[][] gameBoard = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                gameBoard[i][j] = board[i].charAt(j);
            }
        }

        int answer = 0;
        while(true) {
            boolean[][] check = new boolean[m][n];
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(check[i][j] || gameBoard[i][j] == '-') continue;
                    bfs(gameBoard, check, i, j);
                }
            }

            int result = 0;
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(check[i][j]) {
                        gameBoard[i][j] = '-';
                        result++;
                    }
                }
            }
            if(result == 0) break;
            else answer += result;

            for(int j = 0; j < n; j++) {
                for(int i = m - 1; i > 0; i--) {
                    if(check[i][j]) {
                        int k = i;
                        while(k >= 0 && check[k][j]) k--;
                        if(k == -1) continue;
                        swap(gameBoard, i, k, j);
                        check[i][j] = false;
                        check[k][j] = true;
                    }
                }
            }
        }

        return answer;
    }
}
