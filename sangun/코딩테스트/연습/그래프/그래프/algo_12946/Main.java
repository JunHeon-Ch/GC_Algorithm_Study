package algo_12946;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int n;
    static char[][] map;
    static int[][] color;

    static int[] dx = {-1, -1, 0, 1, 1, 0};
    static int[] dy = {0, 1, 1, 0, -1, -1};

    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        color = new int[n][n];
        for (int[] k : color) {
            Arrays.fill(k, -1);
        }
        Queue<Integer> x = new LinkedList<>();
        Queue<Integer> y = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = temp.charAt(j);
                if (map[i][j] == 'X') {
                    x.offer(i);
                    y.offer(j);
                }
            }
        }
        while (!x.isEmpty()) {
            int nx = x.poll();
            int ny = y.poll();
            if (map[nx][ny] == 'X' && color[nx][ny] == -1) {
                dfs(nx, ny, 0);
            }
        }

        bw.write(cnt + "\n");
        bw.close();

    }

    static void dfs(int x, int y, int c) {
        color[x][y] = c;
        if (cnt <= 1) cnt = 1;

        for (int i = 0; i < 6; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= n || nx < 0 || ny >= n || ny < 0) continue;
            if (map[nx][ny] == '-') continue;
            if (color[nx][ny] == -1) dfs(nx, ny, 1 - c);
            // 두개의 색을 썼기때문에 2로 만들어줌
            if (cnt < 2) cnt = 2;
            // 주변 색이랑 같다는 것은 색을 무조건 3개 이상 사용해아함
            if (color[nx][ny] == c) {
                if (cnt < 3) cnt = 3;
            }
        }

    }

}