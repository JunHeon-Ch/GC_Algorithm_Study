package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 두스티커 {
    static Pair[] s;
    static int w, h;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());
        s = new Pair[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            s[i] = new Pair(a, b);
        }

        go(0, 0, new Pair[2]);
        System.out.println(ans);

    }

    static void go(int index, int selected, Pair[] p) {
        if (selected == 2) {
            if (valid(p[0].x, p[0].y, p[1].x, p[1].y)) {
                int result = p[0].x * p[0].y + p[1].x * p[1].y;
                ans = Math.max(ans, result);
            }
            return;
        }
        if (index >= s.length) {
            return;
        }
        p[selected] = s[index];
        go(index + 1, selected + 1, p);
        go(index + 1, selected, p);
    }

    static boolean isFeasible(int r1, int c1, int r2, int c2) {
        if (r1 + r2 <= h && Math.max(c1, c2) <= w) return true;
        if (Math.max(r1, r2) <= h && c1 + c2 <= w) return true;
        return false;
    }

    static boolean valid(int r1, int c1, int r2, int c2) {

        if (isFeasible(r1, c1, r2, c2)) return true; /* (안회전, 안회전) */
        if (isFeasible(c1, r1, r2, c2)) return true; /* (회전, 안회전) */
        if (isFeasible(r1, c1, c2, r2)) return true; /* (안회전, 회전) */
        if (isFeasible(c1, r1, c2, r2)) return true; /* (회전, 회전) */
        return false;

    }


    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
