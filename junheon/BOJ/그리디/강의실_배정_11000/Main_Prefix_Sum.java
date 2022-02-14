package BOJ.그리디.강의실_배정_11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/11000
 * 알고리즘: 누적합 -> 메모리 초과
 */

public class Main_Prefix_Sum {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cum = new int[1000000001];
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            cum[s]++;
            cum[e]--;
        }
        int ans = 0;
        for(int i = 1; i < cum.length; i++) {
            cum[i] += cum[i - 1];
            ans = Math.max(ans, cum[i]);
        }
        System.out.println(ans);
    }
}
