package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A를B로 {
    static long a, b;
    static long ans = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        go(a, 1);

        if (ans == Long.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }

    }




    static void go(long num, long cnt) {
        if (num == b) {
            ans = Math.min(ans, cnt);
            return;
        }
        if (num > b) {
            return;
        }

        go(num * 2, cnt + 1);
        go(num * 10 + 1, cnt + 1);
    }

}
