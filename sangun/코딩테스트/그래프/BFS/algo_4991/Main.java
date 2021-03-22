package algo_4991;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Pair temp = new Pair(-1, -1);
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) break;

            map = new char[n][m];
            ArrayList<Pair> dirty = new ArrayList<>();
            dirty.add(new Pair(0, 0));
            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                for (int j = 0; j < m; j++) {
                    map[i][j] = str.charAt(j);
                    if (map[i][j] == 'o') {
                        dirty.set(0, new Pair(i, j));
                    } else if (map[i][j] == '*') {
                        dirty.add(new Pair(i, j));
                    }
                }
            }
            int[][] d = new int[dirty.size()][dirty.size()];
            boolean ok = false;
            for (int i = 0; i < dirty.size(); i++) {
                int[][] dist = bfs(dirty.get(i).x, dirty.get(i).y);
                for (int j = 0; j < dirty.size(); j++) {
                    d[i][j] = dist[dirty.get(j).x][dirty.get(j).y];
                    if (d[i][j] == -1) {
                        ok = true;
                    }
                }
            }
            if (ok) {
                bw.write(-1 + "\n");
                continue;
            }
            int[] seq = new int[dirty.size() - 1];
            for (int i = 0; i < dirty.size() - 1; i++) {
                seq[i] = i + 1;
            }
            int ans = -1;
            do {
                int now = d[0][seq[0]];
                for (int i = 0; i < dirty.size() - 2; i++) {
                    now += d[seq[i]][seq[i + 1]];
                }
                if (ans == -1 || ans > now) {
                    ans = now;
                }
            } while (nex_permutation(seq));
            bw.write(ans + "\n");
        }
        bw.close();
    }

    // 들어가는 순서도 정해서 봐줘야함
    static boolean nex_permutation(int[] a) {
        int i = a.length - 1;
        while (i > 0 && a[i - 1] >= a[i]) i--;
        if (i <= 0) return false;
        int j = a.length - 1;
        while (a[i - 1] >= a[j]) j--;
        int temp = a[i - 1];
        a[i - 1] = a[j];
        a[j] = temp;
        j = a.length - 1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
        return true;
    }

    static int[][] bfs(int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));
        int n = map.length;
        int m = map[0].length;
        int[][] d = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                d[i][j] = -1;
            }
        }
        d[x][y] = 0;
        while (!q.isEmpty()) {
            Pair p = q.remove();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (map[nx][ny] == 'x') continue;
                    if (d[nx][ny] != -1) continue;
                    d[nx][ny] = d[p.x][p.y] + 1;
                    q.add(new Pair(nx, ny));
                }
            }
        }
        return d;
    }
}
