package PS_2021.프로그래머스.level3.아이템_줍기;

import java.util.*;

/*
https://programmers.co.kr/learn/courses/30/lessons/87694
 * 알고리즘: 시뮬레이션 + BFS
 * 시간복잡도: O(n^2), n=100(board 배열의 길이)
 */

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] board = new int[101][101];
        for(int[] rec : rectangle) {
            makeBorder(rec, board);
        }
        return bfs(board, new Point(characterX * 2, characterY * 2), new Point(itemX * 2, itemY * 2)) / 2;
    }

    public void makeBorder(int[] rec, int[][] board) {
        int x1 = rec[0] * 2;
        int x2 = rec[2] * 2;
        int y1 = rec[1] * 2;
        int y2 = rec[3] * 2;
        for(int i = x1; i <= x2; i++) {
            for(int j = y1; j <= y2; j++) {
                if(board[i][j] == 2) continue;
                board[i][j] = 2;
                if(i == x1 || i == x2 || j == y1 || j == y2) board[i][j] = 1;
            }
        }
    }

    public int bfs(int[][] board, Point sp, Point ep) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<Point> q = new LinkedList<>();
        int[][] d = new int[101][101];
        d[sp.x][sp.y] = 1;
        q.add(sp);
        while(!q.isEmpty()) {
            Point now = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx < 0 || nx > 100 || ny < 0 || ny > 100) continue;
                if(board[nx][ny] != 1 || d[nx][ny] != 0) continue;
                q.add(new Point(nx, ny));
                d[nx][ny] = d[now.x][now.y] + 1;
            }
        }
        return d[ep.x][ep.y] - 1;
    }
}

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
