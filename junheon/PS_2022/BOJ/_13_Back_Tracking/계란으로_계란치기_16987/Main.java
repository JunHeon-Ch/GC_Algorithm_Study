package PS_2022.BOJ._13_Back_Tracking.계란으로_계란치기_16987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/16987
 * 알고리즘: 완전탐색
 * 시간복잡도: O(n^n), n=8(계란의 수)
 */

public class Main {

    static int n;
    static int[] d, w;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        d = new int[n];
        w = new int[n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            d[i] = Integer.parseInt(st.nextToken());
            w[i] = Integer.parseInt(st.nextToken());
        }
        solve(0, 0);
        System.out.println(ans);
    }

    static void solve(int index, int res) {
        if(index == n) {
            ans = Math.max(ans, res);
            return;
        }
        if(d[index] <= 0 || res == n - 1) {
            solve(index + 1, res);
            return;
        }
        for(int i = 0; i < n; i++) {
            if(index == i || d[i] <= 0) continue;
            d[index] -= w[i];
            d[i] -= w[index];
            int cnt = 0;
            if(d[index] <= 0) cnt++;
            if(d[i] <= 0) cnt++;
            solve(index + 1, res + cnt);
            d[index] += w[i];
            d[i] += w[index];
        }
    }
}
