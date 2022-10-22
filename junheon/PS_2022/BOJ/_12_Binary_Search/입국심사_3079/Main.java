package PS_2022.BOJ._12_Binary_Search.입국심사_3079;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/3079
 * 알고리즘: 이분탐색
 * 시간복잡도: O(n*log(m*Tk))
    n=100,000(입국심사대 수), m=1,000,000,000(친구 수), Tk=1,000,000,000(심사대에서 심사를 하는데 걸리는 시간)
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] num = new long[n];
        for (int i = 0; i < n; i++) {
            num[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(num);
        long l = 0, r = m * num[n - 1];
        long ans = Long.MAX_VALUE;
        while (l <= r) {
            long mid = (l + r) / 2;
            long res = 0;
            for (int i = 0; i < n; i++) {
                res += mid / num[i];
            }
            if (res < m) l = mid + 1;
            else {
                ans = Math.min(ans, mid);
                r = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
