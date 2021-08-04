package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 치킨배달 {
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];
        ArrayList<Pair> home = new ArrayList<>();
        ArrayList<Pair> chicken = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    home.add(new Pair(i, j));
                } else if (map[i][j] == 2) {
                    chicken.add(new Pair(i, j));
                }
            }
        }
        go(0, 0, m, chicken, home, new Pair[m]);

        System.out.println(ans);
    }

    static void go(int index, int selected, int m, ArrayList<Pair> chicken, ArrayList<Pair> home, Pair[] p) {
        if (selected == m) {
            ans = Math.min(ans, calculate(home, p));
            return;
        }
        if (index >= chicken.size()) {
            return;
        }

        p[selected] = chicken.get(index);
        go(index + 1, selected + 1, m, chicken, home, p);
        go(index + 1, selected, m, chicken, home, p);

    }

    static int calculate(ArrayList<Pair> home, Pair[] chicken) {

        int total = 0;

        for (int i = 0; i < home.size(); i++) {
            int d = Integer.MAX_VALUE;
            for (int j = 0; j < chicken.length; j++) {
                d = Math.min(d, dist(home.get(i), chicken[j]));
            }
            total += d;
        }

        return total;
    }

    static int dist(Pair a, Pair b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
