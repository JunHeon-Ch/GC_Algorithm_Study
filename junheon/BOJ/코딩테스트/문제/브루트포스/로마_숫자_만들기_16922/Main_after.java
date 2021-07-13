package BOJ.코딩테스트.문제.브루트포스.로마_숫자_만들기_16922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_after {

    public static boolean sum[];
    public static int num[];
    public static int ans = 0;

    public static void solve(int n, int start, int res) {
        if (n == 0) {
            if(!sum[res]) {
                sum[res] = true;
                ans++;
            }
            return;
        }
        for (int i = start; i < 4; i++) {
            solve(n - 1, i, res + num[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        sum = new boolean[n * 50 + 1];
        num = new int[] {1, 5, 10, 50};
        solve(n, 0, 0);
        System.out.println(ans);
    }
}
