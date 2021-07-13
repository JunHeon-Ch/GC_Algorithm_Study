package BOJ.코딩테스트.문제.브루트포스.양념_반_후라이드_반_16917;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        br.close();

        int ans = 0;
        if (a + b >= 2 * c) {
            if (x > y) {
                ans = c * y * 2;
                if (a >= 2 * c) ans += c * (x - y) * 2;
                else ans += a * (x - y);
            } else if (x < y) {
                ans = c * x * 2;
                if (b >= 2 * c) ans += c * (y - x) * 2;
                else ans += b * (y - x);
            } else {
                ans = c * x * 2;
            }
        } else {
            ans = a * x + b * y;
        }
        System.out.println(ans);
    }
}
