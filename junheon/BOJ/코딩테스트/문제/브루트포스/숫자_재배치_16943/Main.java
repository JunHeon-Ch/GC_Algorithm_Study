package BOJ.코딩테스트.문제.브루트포스.숫자_재배치_16943;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] num;
    static boolean[] check;
    static int n, b, ans = -1;

    static void solve(int index, String str) {
        if (index == n) {
            int res = Integer.parseInt(str);
            if (res < b && ans < res) ans = res;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                check[i] = true;
                if (index == 0) {
                    if (num[i] != 0) solve(index + 1, str + num[i]);
                } else {
                    solve(index + 1, str + num[i]);
                }
                check[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] input = st.nextToken().toCharArray();
        n = input.length;
        b = Integer.parseInt(st.nextToken());
        num = new int[n];
        check = new boolean[n];
        for (int i = 0; i < n; i++) {
            num[i] = input[i] - '0';
        }
        solve(0, "");
        System.out.println(ans);
    }
}
