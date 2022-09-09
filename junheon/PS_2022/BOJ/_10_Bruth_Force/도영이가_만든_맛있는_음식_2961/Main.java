package PS_2022.BOJ._10_Bruth_Force.도영이가_만든_맛있는_음식_2961;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/2961
 * 알고리즘: 완전탐색
 * 시간복잡도: O(n!), n=10(재료의 개수)
 */

public class Main {

    static int n;
    static long[] sour;
    static long[] bitter;
    static long ans = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sour = new long[n];
        bitter = new long[n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sour[i] = Integer.parseInt(st.nextToken());
            bitter[i] = Integer.parseInt(st.nextToken());
        }

        solve(-1, 0, 1, 0);
        System.out.println(ans);
    }

    static void solve(int idx, int cnt, long val1, long val2) {
        if(cnt > 0) ans = Math.min(ans, Math.abs(val1 - val2));
        for(int i = idx + 1; i < n; i++) {
            solve(i, cnt + 1, val1 * sour[i], val2 + bitter[i]);
        }
    }
}
