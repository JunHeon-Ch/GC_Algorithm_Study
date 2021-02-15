package algo_13460;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

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
    static dot a, b, o;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        char[][] map = new char[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                String temp = st.nextToken();
                map[i][j] = temp.charAt(j);
                if (map[i][j] == 'A') {
                    a = new dot(i, j);
                } else if (map[i][j] == 'B') {
                    b = new dot(i, j);
                } else if (map[i][j] == 'O') {
                    o = new dot(i, j);
                }

            }
        }


    }

    static void go() {
        Queue<dot> q = new LinkedList<>();
        q.offer(a);
        q.offer(b);

        while (!q.isEmpty()) {
            dot 
        }
    }
}
