package BOJ.그리디.행복_유치원_13164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/13164
 * 풀이: https://c-king.tistory.com/258
    1. 1과 3, 3과 5, 5와 6, 6과 10의 차이를 diff배열에 넣는다.
    2. 이것들을 오름차순하여 index가 [ 0, N-K ) 까지 더한다.
 * 알고리즘: 그리디
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
