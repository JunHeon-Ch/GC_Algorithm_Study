package PS_2022.BOJ.Simulation.마법사_상어와_파이어볼_20056;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
https://www.acmicpc.net/problem/20056
 * 알고리즘: 시뮬레이션
 * 시간복잡도: O(
 */

public class Main {

    static class Fireball {
        int m, s, d;

        public Fireball(int m, int s, int d) {
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    static int n, m;
    static Queue<Fireball>[][] q;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        q = new Queue[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                q[i][j] = new LinkedList<>();
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            q[r][c].add(new Fireball(m, s, d));
        }

        while (t-- > 0) {
            move();
            operate();
        }
        int ans = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                while(!q[i][j].isEmpty()) ans += q[i][j].poll().m;
            }
        }
        System.out.println(ans);
    }

    static void move() {
        Queue<Fireball>[][] tmp = new Queue[n + 1][n + 1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                tmp[i][j] = new LinkedList<>();
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                while(!q[i][j].isEmpty()) {
                    Fireball fb = q[i][j].poll();
                    int nx = i + dx[fb.d] * fb.s;
                    int ny = j + dy[fb.d] * fb.s;
                    if (nx > 0) nx = (nx % n == 0 ? n : nx % n);
                    else nx = n - Math.abs(nx) % n;
                    if (ny > 0) ny = (ny % n == 0 ? n : ny % n);
                    else ny = n - Math.abs(ny) % n;
                    tmp[nx][ny].add(fb);
                }
            }
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                while (!tmp[i][j].isEmpty()) q[i][j].add(tmp[i][j].poll());
            }
        }

    }

    static void operate() {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(q[i][j].size() < 2) continue;
                int m = 0, s = 0, d = -1, cnt = q[i][j].size();
                while (!q[i][j].isEmpty()) {
                    Fireball fb = q[i][j].poll();
                    m += fb.m;
                    s += fb.s;
                    if (d == -1) d = fb.d % 2;
                    else if (d >= 0 && d != fb.d % 2) d = -2;
                }
                if (m >= 5) {
                    int nd = d == -2 ? 1 : 0;
                    for (int k = 0; k < 4; k++) {
                        q[i][j].add(new Fireball(m / 5, s / cnt, nd));
                        nd += 2;
                    }
                }
            }
        }
    }
}
