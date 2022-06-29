package PS_2021.BOJ.그리디.행복_유치원_13164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/13164
 * 알고리즘: 그리디
 * 풀이: https://c-king.tistory.com/258
    1. arr[0]과 arr[1], arr[1]과 arr[2], ..., arr[n - 2]과 arr[n - 1]의 차이를 diff 배열에 넣는다.
    2. diff 배열을 오름차순하여 [0, N-K)까지 더한다.
 * 시간복잡도: O(nlogn), n=300,000(원생의 수)
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] diff = new int[n - 1];
        int prev = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n - 1; i++) {
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
