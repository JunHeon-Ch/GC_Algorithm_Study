package PS_2021.BOJ.코딩테스트.문제.브루트포스.텔레포트3_12908;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Point {
    int sx, sy, ex, ey;

    public Point(int sx, int sy, int ex, int ey) {
        this.sx = sx;
        this.sy = sy;
        this.ex = ex;
        this.ey = ey;
    }
}

public class Main {

    static int sx, sy, ex, ey, N;
    static List<Point> tp = new ArrayList<>();
    static int[] seq;
    static boolean[] visit;
    static long ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sx = Integer.parseInt(st.nextToken());
        sy = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        ex = Integer.parseInt(st.nextToken());
        ey = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            if (getDist(x1, y1, x2, y2) > 10) {
                tp.add(new Point(x1, y1, x2, y2));
                tp.add(new Point(x2, y2, x1, y1));
            }
        }
        tp.add(new Point(ex, ey, ex, ey));
        N = tp.size();
        seq = new int[N];
        visit = new boolean[N];
        ans = getDist(sx, sy, ex, ey);
        solve(0);
        System.out.println(ans);
    }

    private static void solve(int index) {
        if(index == N) {
            long res = calc();
            ans = Math.min(ans, res);
            return;
        }
        for(int i = 0; i < N; i++) {
            if(!visit[i]) {
                visit[i] = true;
                seq[index] = i;
                solve(index + 1);
                visit[i] = false;
            }
        }
    }

    private static long calc() {
        int nx = sx, ny = sy;
        long dist = 0;
        for(int i = 0; i < N; i++) {
            dist += getDist(nx, ny, tp.get(seq[i]).sx, tp.get(seq[i]).sy);
            if(tp.get(seq[i]).ex == ex && tp.get(seq[i]).ey == ey) break;
            dist += 10;
            nx = tp.get(seq[i]).ex;
            ny = tp.get(seq[i]).ey;
        }
        return dist;
    }

    private static long getDist(int sx, int sy, int ex, int ey) {
        return Math.abs(sx - ex) + Math.abs(sy - ey);
    }
}
