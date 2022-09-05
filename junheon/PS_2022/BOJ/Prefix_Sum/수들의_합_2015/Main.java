package PS_2022.BOJ.Prefix_Sum.수들의_합_2015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/2015
 * 알고리즘: 누적합
 * 시간복잡도: O(n), n=200,000(배열 크기)
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] psum = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            psum[i] = Integer.parseInt(st.nextToken());
            psum[i] += psum[i - 1];
        }

        Map<Integer, Integer> map = new HashMap<>();
        long ans = 0;
        for(int i = 1; i <= n; i++) {
            if(psum[i] == k) ans++;
            ans += map.getOrDefault(psum[i] - k, 0);
            map.put(psum[i], map.getOrDefault(psum[i], 0) + 1);
        }
        System.out.println(ans);
    }
}
