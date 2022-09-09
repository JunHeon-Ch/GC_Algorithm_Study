package PS_2022.BOJ._07_Two_Pointer.가장_긴_짝수_연속한_부분_수열_22862;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/22862
 * 알고리즘: 투포인터
 * 시간복잡도: O(n), n=1,000,000(수열 길이)
 */

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

        int l = 0, r = 0;
        int cnt = 0, ans = 0;
        while(r < n) {
            if(seq[r] % 2 == 0) r++;
            else if(cnt < k) {
                r++; cnt++;
            } else {
                if(seq[l] % 2 != 0) cnt--;
                l++;
            }
            ans = Math.max(ans, r - l - cnt);
        }
        System.out.println(ans);
    }
}
