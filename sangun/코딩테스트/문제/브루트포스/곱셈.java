package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 곱셈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());


        System.out.println(go(a, b, c));
    }

    static long go(int a, int b, int c) {
        if (b == 1) {
            return a % c;
        }
        long k = go(a, b / 2, c);
        k = (k * k) % c;

        if (b % 2 == 1) {
            k = (k * a) % c;
        }
        return k;
    }
}
