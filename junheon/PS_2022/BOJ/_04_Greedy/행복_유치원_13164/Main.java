package PS_2022.BOJ._04_Greedy.행복_유치원_13164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/13164
 * 알고리즘: 그리디
 * 시간복잡도: O(n), n=300,000(원생의 수)
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] diff = new int[n - 1];
        st = new StringTokenizer(br.readLine());
        int prev = Integer.parseInt(st.nextToken());
        for(int i = 0; i < diff.length; i++) {
            int now = Integer.parseInt(st.nextToken());
            diff[i] = now - prev;
            prev = now;
        }
        Arrays.sort(diff);

        int ans = 0;
        for(int i = 0; i < n - k; i++) {
            ans += diff[i];
        }
        System.out.println(ans);
    }
}
