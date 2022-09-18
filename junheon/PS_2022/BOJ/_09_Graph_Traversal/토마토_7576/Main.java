package PS_2022.BOJ._09_Graph_Traversal.토마토_7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/7576
 * 알고리즘: BFS
 * 시간복잡도: O(nm), n=1,000(세로 칸의 수), m=1,000(가로 칸의 수)
 */

public class Main {

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];
        int[][] dist = new int[n][m];
        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                dist[i][j] = -1;
                if(board[i][j] == 1) {
                    q.add(new Point(i, j));
                    dist[i][j] = 0;
                }
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while(!q.isEmpty()) {
            int k = q.size();
            while(k-- > 0) {
                Point now = q.poll();
                for(int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];
                    if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if(board[nx][ny] != 0 || dist[nx][ny] != -1) continue;
                    q.add(new Point(nx, ny));
                    dist[nx][ny] = dist[now.x][now.y] + 1;
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] != -1 && dist[i][j] == -1) {
                    System.out.println(-1);
                    return;
                }
                ans = Math.max(ans, dist[i][j]);
            }
        }
        System.out.println(ans);
    }
}
