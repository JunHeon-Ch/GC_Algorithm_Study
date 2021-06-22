package algo_9376;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 안되는 코드
public class Main {
    static class dot {
        int x, y;

        dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int ans = 10000;
    static dot[] prisoner = new dot[2];
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int k = 0; k < t; k++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            char[][] map = new char[n][m];
            boolean check = false;
            ArrayList<dot> wall = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                for (int j = 0; j < m; j++) {
                    map[i][j] = str.charAt(j);
                    if (map[i][j] == '$') {
                        if (!check) {
                            prisoner[0] = new dot(i, j);
                            check = true;
                        } else prisoner[1] = new dot(i, j);
                    } else if (map[i][j] == '#') wall.add(new dot(i, j));
                }
            }

            dfs(wall, 0, wall.size(), map, 0);
            bw.write(ans + "\n");
            ans = 10000;
        }
        bw.close();
    }

    static void dfs(ArrayList<dot> arr, int index, int size, char[][] map, int cnt) {
        if (index == size) {
            if (bfs(prisoner[0], map) && bfs(prisoner[1], map)) {
                ans = Math.min(ans, cnt);
            }
            return;
        }

        dfs(arr, index + 1, size, map, cnt);
        dot delete = arr.get(index);
        char temp = map[delete.x][delete.y];
        map[delete.x][delete.y] = '.';
        dfs(arr, index + 1, size, map, cnt + 1);
        map[delete.x][delete.y] = temp; // 어차피 마지막줄인데 왜 추가하지않으면 안되는지?

    }

    static boolean bfs(dot p1, char[][] map) {
        Queue<dot> q = new LinkedList<>();
        boolean[][] visit = new boolean[n][m];
        dot temp = p1;
        q.add(temp);
        visit[temp.x][temp.y] = true;

        while (!q.isEmpty()) {
            dot p = q.remove();
            int x = p.x;
            int y = p.y;
            if (x == n - 1 || x == 0 || y == m - 1 || y == 0) {
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (map[nx][ny] == '#' || map[nx][ny] == '*') continue;
                if (visit[nx][ny]) continue;
                q.add(new dot(nx, ny));
                visit[nx][ny] = true;
            }

        }

        return false;

    }
}
