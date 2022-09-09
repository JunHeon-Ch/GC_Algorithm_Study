package PS_2022.BOJ._09_Graph_Traversal.미로_탐색_2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/2178
 * 알고리즘: BFS
 * 시간복잡도: O(nm), n=100(행), m=100(열)
 */

public class Main {

    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] board = new char[n][m];
        for(int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int[][] dist = new int[n][m];
        Queue<Pos> q = new LinkedList<>();
        dist[0][0] = 1;
        q.add(new Pos(0, 0));
        while(!q.isEmpty()) {
            Pos now = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(dist[nx][ny] > 0 || board[nx][ny] == '0') continue;
                dist[nx][ny] = dist[now.x][now.y] + 1;
                q.add(new Pos(nx, ny));
            }
        }
        System.out.println(dist[n - 1][m - 1]);
    }
}
