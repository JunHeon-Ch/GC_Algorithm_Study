package PS_2021.BOJ.이분탐색.공유기_설치_2110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/2110
 * 알고리즘: 이분탐색
 * 시간복잡도: O(nlogn), n=200,000(집의 개수)
 */

public class Main {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int[] house = new int[n];
        for(int i = 0; i < n; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(house);

        int low = 0, high = 1000000000;
        int ans = Integer.MIN_VALUE;
        while(low <= high) {
            int mid = (low + high) / 2;
            int cnt = 1, idx = 0;
            for(int i = 1; i < n; i++) {
                if(mid <= house[i] - house[idx]) {
                    cnt++;
                    idx = i;
                }
            }
            if(cnt < c) high = mid - 1;
            else {
                ans = mid;
                low = mid + 1;
            }
        }
        System.out.println(ans);
    }
}
