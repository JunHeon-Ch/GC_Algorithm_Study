package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baaaaaaaaaduk2 {
    static int n, m;
    static int[][] map;
    static int ans = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        go(0, 0, 0, new int[2][2]);

        System.out.println(ans);

    }

    static void go(int x, int y, int index, int[][] r) {
        if (index == 2) {
            int[][] newMap = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    newMap[i][j] = map[i][j];
                }
            }
            newMap[r[0][0]][r[0][1]] = 1;
            newMap[r[1][0]][r[1][1]] = 1;
            int cnt = count(newMap);

            ans = Math.max(ans, cnt);
            return;
        }
        if (x >= n) {
            return;
        }

        if (map[x][y] == 0) {
            r[index][0] = x;
            r[index][1] = y;
            y++;
            if (y >= m) {
                y = 0;
                x++;
            }
            go(x, y, index + 1, r);
            go(x, y, index, r);
        } else {
            y++;
            if (y >= m) {
                y = 0;
                x++;
            }
            go(x, y, index, r);
        }

    }

    static int count(int[][] map) {
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visit = new boolean[n][m];
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2 && !visit[i][j]) {
                    boolean[][] visited = new boolean[n][m];
                    visited[i][j] = true;
                    visit[i][j] = true;
                    q.add(new Pair(i, j));
                    boolean valid = true;
                    int cnt = 1;

                    while (!q.isEmpty()) {
                        Pair p = q.remove();
                        for (int k = 0; k < 4; k++) {
                            int nx = p.x + dx[k];
                            int ny = p.y + dy[k];

                            if (nx >= n || ny >= m || nx < 0 || ny < 0) continue;
                            if (map[nx][ny] == 0) {
                                valid = false;
                                cnt = 0;
                                break;
                            }
                            if (map[nx][ny] == 2 && !visited[nx][ny]) {
                                q.add(new Pair(nx, ny));
                                visited[nx][ny] = true;
                                visit[nx][ny] = true;
                                cnt++;
                            }
                        }
                        if (!valid) {
                            q = new LinkedList<>();
                            break;
                        }
                    }

                    if (!valid) cnt = 0;
                    result += cnt;


                }

            }
        }
        return result;

    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
