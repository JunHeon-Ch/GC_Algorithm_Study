package PS_2022.BOJ._07_Two_Pointer.겹치는_건_싫어_20922;

/*
https://www.acmicpc.net/problem/20922
 * 알고리즘: 투포인터
 * 시간복잡도: O(n), n=100,000(수열 길이)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] seq = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        int ans = 0;
        while(r < n) {
            if(map.getOrDefault(seq[r], 0) == k) {
                map.put(seq[l], map.get(seq[l]) - 1);
                l++;
            } else {
                map.put(seq[r], map.getOrDefault(seq[r], 0) + 1);
                r++;
            }
            ans = Math.max(ans, r - l);
        }
        System.out.println(ans);
    }
}
