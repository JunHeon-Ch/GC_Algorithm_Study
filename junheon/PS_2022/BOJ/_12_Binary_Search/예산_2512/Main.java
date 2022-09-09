package PS_2022.BOJ._12_Binary_Search.예산_2512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/2512
 * 알고리즘: 이분탐색
 * 시간복잡도: O(nlogn), n=10,000(지방의 수)
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        int max = Integer.parseInt(br.readLine());
        int l = 0, r = max;
        int ans = 0;
        while(l <= r) {
            int m = (l + r) / 2;
            int sum = 0, res = 0;
            for(int i = 0; i < n; i++) {
                if(num[i] < m) {
                    sum += num[i];
                    res = Math.max(res, num[i]);
                }
                else {
                    sum += m;
                    res = Math.max(res, m);
                }
            }
            if(sum <= max) {
                l = m + 1;
                ans = Math.max(ans, res);
            } else r = m - 1;
        }
        System.out.println(ans);
    }
}
