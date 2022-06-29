package PS_2021.BOJ.코딩테스트.문제.브루트포스.나3곱2_16936;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedWriter bw;
    static int N;
    static long[] num;
    static long[] ans;
    static boolean[] check;

    public static void solve(int index, int prev) throws IOException {
        if (index == N) {
            for (int i = 0; i < N; i++) {
                bw.write(ans[i] + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            if (check[i]) continue;
            check[i] = true;
            if (index == 0) {
                ans[index] = num[i];
                solve(index + 1, i);
            } else {
                if(num[prev] * 2 == num[i]) {
                    ans[index] = num[i];
                    solve(index + 1, i);
                }
                if(num[prev] % 3 == 0 && num[prev] / 3 == num[i]) {
                    ans[index] = num[i];
                    solve(index + 1, i);
                }
            }
            check[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        num = new long[N];
        ans = new long[N];
        check = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Long.parseLong(st.nextToken());
        }
        br.close();

        solve(0, 0);
        bw.flush();
        bw.close();
    }
}
