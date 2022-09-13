package PS_2022.BOJ._04_Greedy.꿀_따기_21758;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/21758
 * 알고리즘: 그리디
 * 시간복잡도: O(n), n=100,000(장소의 수)
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n + 2];
        int[] lpsum = new int[n + 2];
        int[] rpsum = new int[n + 2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i <= n; i++) {
            lpsum[i] = lpsum[i - 1] + num[i];
        }
        for(int i = n; i > 0; i--) {
            rpsum[i] = rpsum[i + 1] + num[i];
        }

        int ans = 0;
        int res = rpsum[1] - rpsum[n];
        for(int i = 2; i < n; i++) {
            ans = Math.max(ans, res - num[i] + rpsum[1] - rpsum[i]);
        }
        res = lpsum[n] - lpsum[1];
        for(int i = 2; i < n; i++) {
            ans = Math.max(ans, res - num[i] + lpsum[n] - lpsum[i]);
        }
        for(int i = 2; i < n; i++) {
            ans = Math.max(ans, lpsum[i] - lpsum[1] + rpsum[i] - rpsum[n]);
        }
        System.out.println(ans);
    }
}
