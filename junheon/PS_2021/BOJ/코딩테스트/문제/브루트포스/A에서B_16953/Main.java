package PS_2021.BOJ.코딩테스트.문제.브루트포스.A에서B_16953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long A, B;
    static int ans = -1;

    public static void solve(long res, int cnt) {
        if(res == B) {
            if(ans == -1 || ans > cnt) ans = cnt;
            return;
        }
        if(res > B) return;
        solve(res * 2, cnt + 1);
        solve(res * 10 + 1, cnt + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        solve(A, 0);
        if(ans != -1) System.out.println(ans + 1);
        else System.out.println(ans);
    }
}
