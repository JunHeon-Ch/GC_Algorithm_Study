package algo_16236;

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class dot {
        Integer x, y, dist;

        dot(int dist, int x, int y) {
            this.dist = dist;
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];

        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    map[i][j] = 0;
                    x = i;
                    y = j;
                }
            }
        }

        int ans = 0;
        int size = 2;
        int exp = 0;
        while (true) {
            dot p = bfs(map, x, y, size);
            if (p == null) break;
            map[p.x][p.y] = 0;
            exp++;
            ans += p.dist;
            if (size == exp) {
                size++;
                exp = 0;
            }
            x = p.x;
            y = p.y;
        }

        bw.write(ans + "\n");
        bw.close();


    }

    static dot bfs(int[][] map, int sx, int sy, int size) {
        int n = map.length;
        ArrayList<dot> ans = new ArrayList<>();
        int[][] d = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] = -1;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(sx);
        q.offer(sy);
        d[sx][sy] = 0;
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && d[nx][ny] == -1) {
                    boolean ok = false;
                    boolean eat = false;
                    if (map[nx][ny] == 0) {
                        ok = true;
                    } else if (map[nx][ny] < size) {
                        eat = true;
                        ok = true;
                    } else if (map[nx][ny] == size) {
                        ok = true;
                    }
                    if (ok) {
                        q.add(nx);
                        q.add(ny);
                        d[nx][ny] = d[x][y] + 1;
                        if (eat) {
                            ans.add(new dot(d[nx][ny], nx, ny));
                        }
                    }
                }
            }
        }
        if (ans.isEmpty()) {
            return null;
        }

        dot best = ans.get(0);
        for (dot p : ans) {
            if (best.dist > p.dist) {
                best = p;
            } else if (best.dist == p.dist && best.x > p.x) {
                best = p;
            } else if (best.dist == p.dist && best.x == p.x && best.y > p.y) {
                best = p;
            }
        }
        return best;
    }

}
