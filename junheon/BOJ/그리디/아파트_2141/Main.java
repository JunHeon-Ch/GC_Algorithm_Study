package BOJ.그리디.아파트_2141;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
https://www.acmicpc.net/problem/2141
 * 알고리즘: 그리디문제지만 누적합으로 품
 * 시간복잡도: O(nlogn), n=100,000(마을 수)
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Country[] countries = new Country[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int pos = Integer.parseInt(st.nextToken());
            int pop = Integer.parseInt(st.nextToken());
            countries[i] = new Country(pos, pop);
        }
        Arrays.sort(countries, Comparator.comparingInt(o -> o.pos));

        int[] pos = new int[n];
        for(int i = 0; i < n; i++) {
            pos[i] = countries[i].pos;
        }

        long[] left = new long[n];
        left[0] = 0;
        long cum = 0;
        for (int i = 1; i < n; i++) {
            cum += countries[i - 1].pop;
            left[i] = left[i - 1] + cum;
        }
        long[] right = new long[n];
        right[n - 1] = 0;
        cum = 0;
        for (int i = n - 2; i >= 0; i--) {
            cum += countries[i + 1].pop;
            right[i] = right[i + 1] + cum;
        }

        long min = Long.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (left[i] + right[i] < min) {
                ans = pos[i];
                min = left[i] + right[i];
            }
        }
        System.out.println(ans);
    }

    static class Country {
        int pos;
        long pop;

        public Country(int pos, long pop) {
            this.pos = pos;
            this.pop = pop;
        }
    }
}
