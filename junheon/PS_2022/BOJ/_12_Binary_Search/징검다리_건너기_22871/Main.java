package PS_2022.BOJ._12_Binary_Search.징검다리_건너기_22871;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/22871
 * 알고리즘: DP
 * 시간복잡도: O(n^2), n=5,000(돌의 개수)
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] num = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            num[i] = Long.parseLong(st.nextToken());
        }
        long[] d = new long[n];
        for(int i = 1; i < n; i++) {
            d[i] = Long.MAX_VALUE;
            for(int j = 0; j < i; j++) {
                d[i] = Math.min(d[i], Math.max(d[j], (i - j) * (1 +Math.abs(num[i] - num[j]))));
            }
        }
        System.out.println(d[n - 1]);
    }
}
