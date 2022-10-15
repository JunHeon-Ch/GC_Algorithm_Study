package PS_2022.BOJ._05_DP._1학년_5557;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/5557
 * 알고리즘: DP
 * 시간복잡도: O(n), n=100(숫자의 개수)
 */

public class Main {

    static int[] num;
    static long[] d = new long[21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        d[num[0]] = 1;
        for(int i = 1; i < n - 1; i++) {
            long[] tmp = new long[d.length];
            for(int j = 0; j <= 20; j++) {
                if(d[j] == 0) continue;
                if(j - num[i] >= 0) tmp[j - num[i]] += d[j];
                if(j + num[i] <= 20) tmp[j + num[i]] += d[j];
            }
            d = Arrays.copyOf(tmp, d.length);
        }
        System.out.println(d[num[n - 1]]);
    }
}
