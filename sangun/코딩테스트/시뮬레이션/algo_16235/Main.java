package algo_16235;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, k;
    static int[][] a;
    static int[][] map;

    static class tree {
        int x, y, z;

        tree(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = 5;
            }
        }

        ArrayList<tree> t = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            t.add(new tree(a, b, c));
        }

        // 정렬
        for (int i = 0; i < t.size(); i++) {
            for (int j = 0; j < t.size() - i - 1; j++) {
                if (t.get(j).z > t.get(j + 1).z) {
                    tree temp = t.get(j);
                    t.add(j, t.get(j + 1));
                    t.remove(j + 1);
                    t.add(j + 1, temp);
                    t.remove(j + 1 + 1);
                }
            }
        }
        while (k-- > 0) {
            Queue<tree> dead = new LinkedList<>();
            // 봄
            ArrayList<tree> copy = new ArrayList<>();
            for (int i = 0; i < t.size(); i++) {
                if (map[t.get(i).x][t.get(i).y] < t.get(i).z) {
                    dead.add(t.get(i));
                } else {
                    map[t.get(i).x][t.get(i).y] -= t.get(i).z;
                    t.get(i).z++;
                    copy.add(t.get(i));
                }
            }
            // 여름
            while (!dead.isEmpty()) {
                tree tmp = dead.remove();
                map[tmp.x][tmp.y] += tmp.z / 2;
            }
            t = new ArrayList<>();

            // 가을
            for (int i = 0; i < copy.size(); i++) {
                if (copy.get(i).z % 5 == 0) {
                    for (int j = 0; j < 8; j++) {
                        int nx = copy.get(i).x + dx[j];
                        int ny = copy.get(i).y + dy[j];
                        if (nx >= n || nx < 0 || ny < 0 || ny >= n) continue;
                        t.add(new tree(nx, ny, 1));
                    }
                }
            }
            for (int i = 0; i < copy.size(); i++) {
                t.add(copy.get(i));
            }

            // 겨울
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] += a[i][j];
                }
            }

        }


        System.out.println(t.size());
    }
}
