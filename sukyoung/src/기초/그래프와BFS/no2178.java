package 기초.그래프와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class no2178 {
    public static int n;
    public static int m;
    public static boolean[][] visit;
    public static int[][] maze;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visit = new boolean[n][m];
        maze = new int[n][m];
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                maze[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        visit[0][0] = true;
        bfs(0,0);
        System.out.println(maze[n-1][m-1]);
    }
    public static void bfs(int x, int y){
        Queue<Dot> q = new LinkedList<Dot>();
        q.add(new Dot(x, y));

        while (!q.isEmpty()) {
            Dot d = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = d.x + dx[i];
                int nextY = d.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) {
                    continue;
                }
                if (visit[nextX][nextY] || maze[nextX][nextY] == 0) {
                    continue;
                }

                q.add(new Dot(nextX, nextY));
                maze[nextX][nextY] = maze[d.x][d.y] + 1;
                //다음 좌표는 방문했음으로 표시
                visit[nextX][nextY] = true;
            }
        }
    }
}
class Dot {
    int x;
    int y;

    Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}