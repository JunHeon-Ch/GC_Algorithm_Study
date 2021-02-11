package algo_16197;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    static char[][] map;
    static int min = Integer.MAX_VALUE;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visit = new boolean[n][m];
        int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
        boolean check = false;
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = temp.charAt(j);
                if (map[i][j] == 'o') {
                    if (!check) {
                        x1 = i;
                        y1 = j;
                        check = true;
                    } else {
                        x2 = i;
                        y2 = j;
                    }
                }
            }
        }

        dfs(x1, y1, x2, y2, 0);
        if (min > 10) bw.write(-1 + "\n");
        else bw.write(min + "\n");
        bw.close();

    }

    static void dfs(int x1, int y1, int x2, int y2, int cnt) {
        if (cnt>10) return;
        for (int i = 0; i < 4; i++) {
            int nx1 = x1 + dx[i];
            int nx2 = x2 + dx[i];
            int ny1 = y1 + dy[i];
            int ny2 = y2 + dy[i];
            if ((nx1 < 0 || nx1 >= n || ny1 < 0 || ny1 >= m) && (nx2 < 0 || nx2 >= n || ny2 < 0 || ny2 >= m)) {
                continue;
            }
            if (nx1 < 0 || nx1 >= n || ny1 < 0 || ny1 >= m) {
                cnt++;
                min = Math.min(min, cnt);
                return;
            }
            if (nx2 < 0 || nx2 >= n || ny2 < 0 || ny2 >= m) {
                cnt++;
                min = Math.min(min, cnt);
                return;
            }
            if (map[nx1][ny1] != '#' && map[nx2][ny2] == '#') {
                nx2 = x2;
                ny2 = y2;
                dfs(nx1, ny1, nx2, ny2, cnt + 1);
            } else if (map[nx1][ny1] == '#' && map[nx2][ny2] != '#') {
                nx1 = x1;
                ny1 = y1;
                dfs(nx1, ny1, nx2, ny2, cnt + 1);
            } else if (map[nx1][ny1] == '#' && map[nx2][ny2] == '#') {
                continue;
            } else {
                dfs(nx1, ny1, nx2, ny2, cnt + 1);
            }

        }
    }

}
