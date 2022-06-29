package PS_2021.BOJ.코딩테스트.문제.브루트포스.감시_15683;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Camera {
    int dir, number;
    int x, y;

    public Camera(int number, int dir, int x, int y) {
        this.number = number;
        this.dir = dir;
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int N, M, ans = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][] visit;
    static int[] dirs;

    public static void check(int x, int y, int dir) {
        int[] dx = {0, -1, 0, 1};
        int[] dy = {-1, 0, 1, 0};

        while (true) {
            x += dx[dir];
            y += dy[dir];
            if (x < 0 || x >= N || y < 0 || y >= M) break;
            if (map[x][y] == 6) break;
            visit[x][y] = true;
        }
    }

    public static int findArea() {
        int k = 0;
        Camera[] cams = new Camera[dirs.length];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visit[i][j] = false;
                if (map[i][j] == 0) continue;
                visit[i][j] = true;
                if (map[i][j] == 6) continue;
                cams[k] = new Camera(map[i][j], dirs[k], i, j);
                k++;
            }
        }

        for (Camera cam : cams) {
            if (cam.number < 4) {
                check(cam.x, cam.y, cam.dir);
                if (cam.number == 2) {
                    check(cam.x, cam.y, (cam.dir + 2) % 4);
                } else if (cam.number == 3) {
                    check(cam.x, cam.y, (cam.dir + 1) % 4);
                }
            } else {
                for (int i = 0; i < 4; i++) {
                    if (cam.number == 4 && cam.dir == i) continue;
                    check(cam.x, cam.y, i);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visit[i][j]) res++;
            }
        }
        return res;
    }

    public static void solve(int index) {
        if (index == dirs.length) {
            int res = findArea();
            ans = Math.min(ans, res);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (dirs[index] == -1) {
                dirs[index] = i;
                solve(index + 1);
                dirs[index] = -1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        int k = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0 && map[i][j] < 6) k++;
            }
        }

        dirs = new int[k];
        visit = new boolean[N][M];
        Arrays.fill(dirs, -1);
        solve(0);
        System.out.println(ans);
    }
}
