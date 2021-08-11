package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 계란으로계란치기 {
    static int n;
    static int ans = 0;
    static boolean[] broken;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        Pair[] eggs = new Pair[n];
        broken = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            eggs[i] = new Pair(a, b);
        }
        go(0, eggs);
        System.out.println(ans);

    }

    static void go(int index, Pair[] eggs) {
        if (index == n) {
            int cnt = 0;
            for (boolean b : broken) {
                if (b) cnt++;
            }
            ans = Math.max(ans, cnt);
//            System.out.println(cnt);
            return;
        }
        if (index == n - 1) {
            boolean check = false;
            for (int i = 0; i < n - 1; i++) {
                if (!broken[i]) {
                    check = true;
                    break;
                }
            }
            if (!check) {
                go(index + 1, eggs);
                return;
            }
        }
        if (eggs[index].s > 0) {
            for (int i = 0; i < n; i++) {
                if (i == index) continue;
                if (broken[i]) continue;
                int s1 = eggs[index].s;
                int s2 = eggs[i].s;
                eggs[index].s -= eggs[i].w;
                eggs[i].s -= eggs[index].w;
                if (eggs[index].s <= 0) broken[index] = true;
                if (eggs[i].s <= 0) broken[i] = true;

                go(index + 1, eggs);

                if (broken[index]) broken[index] = false;
                if (broken[i]) broken[i] = false;
                eggs[index].s = s1;
                eggs[i].s = s2;
//                System.out.println(index);
            }
        } else {
            go(index + 1, eggs);
        }
    }


    static class Pair {
        int s, w;

        public Pair(int s, int w) {
            this.w = w;
            this.s = s;
        }
    }
}
