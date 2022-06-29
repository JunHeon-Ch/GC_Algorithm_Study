package PS_2021.BOJ.코딩테스트.문제.브루트포스.Maaaaaaaaaze_16985;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x, y, z;

    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class Main {

    static int[][][][] board = new int[5][5][5][4];
    static int[][][] maze = new int[5][5][5];
    static int[] rotation = new int[5];
    static int[] lineup;
    static boolean[] check;
    static int ans = -1;

    public static int bfs() {
        int[] dx = {-1, 1, 0, 0, 0, 0};
        int[] dy = {0, 0, -1, 1, 0, 0};
        int[] dz = {0, 0, 0, 0, -1, 1};
        int[][][] dist = new int[5][5][5];
        Queue<Point> queue = new LinkedList<>();
        dist[0][0][0] = 1;
        queue.add(new Point(0, 0, 0));
        while(!queue.isEmpty()) {
            Point now = queue.poll();
            for(int i = 0; i < 6; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                int nz = now.z + dz[i];
                if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || nz < 0 || nz >= 5) continue;
                if(dist[nx][ny][nz] > 0 || maze[nx][ny][nz] == 0) continue;
                dist[nx][ny][nz] = dist[now.x][now.y][now.z] + 1;
                queue.add(new Point(nx, ny, nz));
            }
        }
        if(dist[4][4][4] == 0) return -1;
        else return dist[4][4][4] - 1;
    }

    public static void solve(int index) {
        if(index == 5) {
            for (int k = 0; k < 5; k++) {
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        maze[i][j][k] = board[i][j][lineup[k]][rotation[k]];
                    }
                }
            }
            if (maze[0][0][0] != 0 && maze[4][4][4] != 0) {
                int res = bfs();
                if (res != -1) {
                    if (ans == -1 || ans > res) ans = res;
                }
            }
            return;
        }
        for(int i = 0; i < 5; i++) {
            if(check[i]) continue;
            check[i] = true;
            lineup[index] = i;
            solve(index + 1);
            check[i] = false;
        }
    }

    public static void rotate(int index) {
        if(index == 5) {
            lineup = new int[5];
            check = new boolean[5];
            solve(0);
            return;
        }
        for(int i = 0; i < 4; i++) {
            rotation[index] = i;
            rotate(index + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int k = 0; k < 5; k++) {
            for(int i = 0; i < 5; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 5; j++) {
                    board[i][j][k][0] = Integer.parseInt(st.nextToken());
                }
            }
        }
        for(int t = 1; t < 4; t++) {
            for(int k = 0; k < 5; k++) {
                for(int i = 0; i < 5; i++) {
                    for(int j = 0; j < 5; j++) {
                        board[j][4 - i][k][t] = board[i][j][k][t - 1];
                    }
                }
            }
        }

        rotate(0);
        System.out.println(ans);
    }
}
