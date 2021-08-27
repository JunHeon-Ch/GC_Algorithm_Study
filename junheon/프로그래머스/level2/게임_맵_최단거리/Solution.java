package 프로그래머스.level2.게임_맵_최단거리;

import java.util.*;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {

    public int solution(int[][] maps) {
        int answer = bfs(maps);
        return answer;
    }

    private int bfs(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int[][] d = new int[n][m];
        boolean[][] v = new boolean[n][m];
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0));
        v[0][0] = true;
        d[0][0] = 1;
        while(!q.isEmpty()) {
            Point now = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(v[nx][ny] || maps[nx][ny] == 0) continue;
                v[nx][ny] = true;
                d[nx][ny] = d[now.x][now.y] + 1;
                q.offer(new Point(nx, ny));
            }
        }
        if(d[n - 1][m - 1] == 0) return -1;
        return d[n - 1][m - 1];
    }
}