package 브루트포스;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 십자가찾기 {
    static ArrayList<Pair> ans = new ArrayList<>();

    static char[][] map;
    static int n, m;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == '*') visited[i][j] = true;
            }
        }

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == '*') {
                    int scale = 1;
                    while (true) {
                        boolean flag = true;
                        for (int k = 0; k < 4; k++) {
                            int nx = i + dx[k] * scale;
                            int ny = j + dy[k] * scale;
                            if (nx < 0 || nx >= n || ny < 0 || ny >= m || map[nx][ny] != '*') {
                                flag = false;
                                break;
                            }
                        }
                        if (!flag) break;
                        for (int k = 0; k < 4; k++) {
                            int nx = i + dx[k] * scale;
                            int ny = j + dy[k] * scale;
                            visited[nx][ny] = false;
                        }
                        visited[i][j] = false;
                        list.add(new Pair(i + 1, j + 1, scale));
                        scale++;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j]) {
                    bw.write(-1 + "\n");
                    bw.flush();
                    bw.close();
                    return;
                }
            }
        }
        bw.write(list.size() + "\n");
        for (Pair temp : list) {
            bw.write(temp.x + " " + temp.y + " " + temp.k + "\n");
        }
        bw.flush();
        bw.close();

    }

    static class Pair {
        int x, y, k;

        public Pair(int x, int y, int k) {
            this.x = x;
            this.y = y;
            this.k = k;
        }
    }


}
