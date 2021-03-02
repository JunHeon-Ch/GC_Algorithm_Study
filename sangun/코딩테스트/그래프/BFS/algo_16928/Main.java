package algo_16928;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] map = new int[101];
    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x] = y;

        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x] = y;
        }
        bfs();

        bw.write(cnt + "\n");
        bw.close();

    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        // 들렸던곳은 -1로 체크
        map[1] = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int x = q.poll();
                map[x] = -1;
                for (int i = 1; i <= 6; i++) {
                    int nx = x + i;
                    if (nx == 100) return;
                    if (nx > 100) continue;
                    if (map[nx] == -1) continue;
                    if (map[nx] != 0) {
                        q.offer(map[nx]);
                        map[nx] = -1;
                    } else {
                        q.offer(nx);
                        map[nx] = -1;
                    }
                }
            }
            cnt++;
        }
    }
}