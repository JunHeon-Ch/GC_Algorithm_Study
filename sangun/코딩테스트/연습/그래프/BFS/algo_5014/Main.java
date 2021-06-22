package algo_5014;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int f, s, g, u, d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());


        bfs();

    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);

        boolean[] visit = new boolean[f + 1];
        visit[s] = true;
        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {

                int floor = q.remove();
                if (floor == g) {
                    System.out.println(cnt);
                    return;
                }
                int up = floor + u;
                if (up <= f && !visit[up]) {
                    q.add(up);
                    visit[up] = true;
                }
                int down = floor - d;
                if (down > 0 && !visit[down]) {
                    q.add(down);
                    visit[down] = true;
                }
            }
            cnt++;
        }
        System.out.println("use the stairs");
    }

}
