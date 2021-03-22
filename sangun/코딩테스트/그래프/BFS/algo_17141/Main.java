package algo_17141;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static ArrayList<Pair> virus = new ArrayList<>();
    static ArrayList<Pair> input = new ArrayList<>();
    static boolean[] visit;
    static int ans = Integer.MAX_VALUE;
    static boolean ok = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    virus.add(new Pair(i, j));
                }
            }
        }
        visit = new boolean[virus.size()];

        dfs(0, 0);
        if (ans==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);

    }

    static void dfs(int index, int s) {
        if (index == m) {
            int value = bfs(input);
            if (ans > value && value >= 0) {
                ans = value;
            }
            return;
        }

        for (int i = s; i < virus.size(); i++) {
            if (visit[i]) continue;
            input.add(virus.get(i));
            visit[i] = true;
            dfs(index + 1, i + 1);
            visit[i] = false;
            input.remove(index);
        }
    }

    static int bfs(ArrayList<Pair> s) {
        Queue<Pair> q = new LinkedList<>();
        int[][] d = new int[n][n];
        for (int[] k : d) {
            Arrays.fill(k, -1);
        }
        for (int i = 0; i < m; i++) {
            q.add(s.get(i));
            d[s.get(i).x][s.get(i).y] = 0;
        }

        while (!q.isEmpty()) {

            Pair p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx >= n || nx < 0 || ny < 0 || ny >= n) continue;
                if (map[nx][ny] == 1) continue;
                if (d[nx][ny] != -1) continue;
                q.add(new Pair(nx, ny));
                d[nx][ny] = d[p.x][p.y] + 1;
            }
        }
        int result = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (d[i][j] == -1 && map[i][j] != 1) {
                    return -1;
                }
                if (d[i][j] > result) {
                    result = d[i][j];
                }
            }
        }
        return result;

    }

}
