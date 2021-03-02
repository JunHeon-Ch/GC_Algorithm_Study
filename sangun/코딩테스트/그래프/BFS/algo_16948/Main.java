package algo_16948;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, r1, c1, r2, c2;
    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};
    static boolean[][] visit;
    static int ans = 1;
    static boolean check = false;

    static class dot {
        int x, y;

        dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        visit = new boolean[n][n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        bfs();

        if (check) bw.write(ans + "\n");
        else bw.write(-1 + "\n");
        bw.close();
    }

    static void bfs() {
        Queue<dot> q = new LinkedList<>();
        q.offer(new dot(r1, c1));
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                dot temp = q.poll();
                int x = temp.x;
                int y = temp.y;
                for (int i = 0; i < 6; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    if (visit[nx][ny]) continue;
                    if (nx == r2 && ny == c2) {
                        check = true;
                        return;
                    }
                    visit[nx][ny] = true;
                    q.offer(new dot(nx, ny));
                }

            }
            ans++;
        }


    }
}
